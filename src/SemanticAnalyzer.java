import java.util.ArrayList;
import java.util.List;

public class SemanticAnalyzer extends gyhlngBaseVisitor<TabelaSimbolos.Tipo> {
    private final TabelaSimbolos tabela;
    private final List<String> erros;
    private boolean inProgramaBr = false;
    private boolean afterBlockBr = false;
    private boolean programBrScopeOpen = false;
    
    public SemanticAnalyzer() {
        this.tabela = new TabelaSimbolos();
        this.erros = new ArrayList<>();
    }
    
    public boolean temErros() { return !erros.isEmpty(); }
    public List<String> getErros() { return erros; }
    public TabelaSimbolos getTabela() { return tabela; }
    
    private void erro(int linha, String mensagem) {
        erros.add("Linha " + linha + ": " + mensagem);
    }
    
    private TabelaSimbolos.Tipo tipoDe(String s) {
        if ("INTEGER".equals(s)) return TabelaSimbolos.Tipo.INTEGER;
        if ("REAL".equals(s)) return TabelaSimbolos.Tipo.REAL;
        if ("BOOLEAN".equals(s)) return TabelaSimbolos.Tipo.BOOLEAN;
        return TabelaSimbolos.Tipo.INDEFINIDO;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitPrograma(gyhlngParser.ProgramaContext ctx) {
        return super.visitPrograma(ctx);
    }
    
    @Override
    public TabelaSimbolos.Tipo visitProgramaBr(gyhlngParser.ProgramaBrContext ctx) {
        inProgramaBr = true;
        programBrScopeOpen = true;
        tabela.enterScope();
        if (ctx.declaracoesBr() != null) visit(ctx.declaracoesBr());
        if (ctx.comandosBr() != null) visit(ctx.comandosBr());
        if (programBrScopeOpen) {
            tabela.exitScope();
            programBrScopeOpen = false;
        }
        inProgramaBr = false;
        afterBlockBr = false;
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitBloco(gyhlngParser.BlocoContext ctx) {
        tabela.enterScope();
        TabelaSimbolos.Tipo t = super.visitBloco(ctx);
        tabela.exitScope();
        return t;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitSubAlgBr(gyhlngParser.SubAlgBrContext ctx) {
        tabela.enterScope();
        TabelaSimbolos.Tipo t = super.visitSubAlgBr(ctx);
        tabela.exitScope();
        if (inProgramaBr && programBrScopeOpen) {
            afterBlockBr = true;
            tabela.exitScope();
            programBrScopeOpen = false;
        }
        return t;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitDeclaracao(gyhlngParser.DeclaracaoContext ctx) {
        TabelaSimbolos.Tipo tipo = tipoDe(ctx.tipo().getText());
        for (int i = 0; i < ctx.listaVars().VAR().size(); i++) {
            String nome = ctx.listaVars().VAR(i).getText();
            if (!tabela.declarar(nome, tipo)) {
                erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' redeclarada no mesmo escopo.");
            }
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitDeclaracaoBr(gyhlngParser.DeclaracaoBrContext ctx) {
        TabelaSimbolos.Tipo tipo = tipoDe(ctx.tipo().getText());
        String nome = ctx.VAR().getText();
        if (!tabela.declarar(nome, tipo)) {
            erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' redeclarada no mesmo escopo.");
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitAtribuicao(gyhlngParser.AtribuicaoContext ctx) {
        String nome = ctx.VAR().getText();
        if (!tabela.existe(nome)) {
            erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' usada antes da declaração.");
            return null;
        }
        TabelaSimbolos.Tipo tv = tabela.getTipo(nome);
        TabelaSimbolos.Tipo te = visit(ctx.expressao());
        if (!tiposCompativeis(tv, te)) {
            erro(ctx.getStart().getLine(), "Erro: tipos incompatíveis em '" + nome + " := " + ctx.expressao().getText() + "'.");
        } else {
            tabela.marcarInicializado(nome);
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitAtribuicaoBr(gyhlngParser.AtribuicaoBrContext ctx) {
        if (inProgramaBr && afterBlockBr) {
            erro(ctx.getStart().getLine(), "Erro: comando fora do bloco INICIO..FINAL.");
        }
        String nome = ctx.VAR().getText();
        if (!tabela.existe(nome)) {
            erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' usada antes da declaração.");
            return null;
        }
        TabelaSimbolos.Tipo tv = tabela.getTipo(nome);
        TabelaSimbolos.Tipo te = visit(ctx.expressao());
        if (!tiposCompativeis(tv, te)) {
            erro(ctx.getStart().getLine(), "Erro: tipos incompatíveis em '" + nome + " := " + ctx.expressao().getText() + "'.");
        } else {
            tabela.marcarInicializado(nome);
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitComandoLeitura(gyhlngParser.ComandoLeituraContext ctx) {
        String nome = ctx.VAR().getText();
        if (!tabela.existe(nome)) {
            erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' usada antes da declaração.");
        } else {
            tabela.marcarInicializado(nome);
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitComandoLeituraBr(gyhlngParser.ComandoLeituraBrContext ctx) {
        if (inProgramaBr && afterBlockBr) {
            erro(ctx.getStart().getLine(), "Erro: comando fora do bloco INICIO..FINAL.");
        }
        String nome = ctx.VAR().getText();
        if (!tabela.existe(nome)) {
            erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' usada antes da declaração.");
        } else {
            tabela.marcarInicializado(nome);
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitComandoEscrita(gyhlngParser.ComandoEscritaContext ctx) {
        TabelaSimbolos.Tipo t = visit(ctx.expressao());
        if (t == TabelaSimbolos.Tipo.INDEFINIDO) {
            erro(ctx.getStart().getLine(), "Erro: expressão inválida em IMPRIMIR.");
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitComandoEscritaBr(gyhlngParser.ComandoEscritaBrContext ctx) {
        if (inProgramaBr && afterBlockBr) {
            erro(ctx.getStart().getLine(), "Erro: comando fora do bloco INICIO..FINAL.");
        }
        if (ctx.VAR() != null) {
            String nome = ctx.VAR().getText();
            if (!tabela.existe(nome)) {
                erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' usada antes da declaração.");
                return TabelaSimbolos.Tipo.INDEFINIDO;
            }
            if (!tabela.isInicializado(nome)) {
                erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' usada sem valor inicial.");
            }
            return tabela.getTipo(nome);
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitComandoCondicional(gyhlngParser.ComandoCondicionalContext ctx) {
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        if (c != TabelaSimbolos.Tipo.BOOLEAN) {
            erro(ctx.getStart().getLine(), "Erro: condição de SE deve ser booleana.");
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitComandoCondicionalBr(gyhlngParser.ComandoCondicionalBrContext ctx) {
        if (inProgramaBr && afterBlockBr) {
            erro(ctx.getStart().getLine(), "Erro: comando fora do bloco INICIO..FINAL.");
        }
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        if (c != TabelaSimbolos.Tipo.BOOLEAN) {
            erro(ctx.getStart().getLine(), "Erro: condição de SE deve ser booleana.");
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitComandoRepeticao(gyhlngParser.ComandoRepeticaoContext ctx) {
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        if (c != TabelaSimbolos.Tipo.BOOLEAN) {
            erro(ctx.getStart().getLine(), "Erro: condição de ENQTO deve ser booleana.");
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitComandoRepeticaoBr(gyhlngParser.ComandoRepeticaoBrContext ctx) {
        if (inProgramaBr && afterBlockBr) {
            erro(ctx.getStart().getLine(), "Erro: comando fora do bloco INICIO..FINAL.");
        }
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        if (c != TabelaSimbolos.Tipo.BOOLEAN) {
            erro(ctx.getStart().getLine(), "Erro: condição de ENQTO deve ser booleana.");
        }
        return null;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitExpressao(gyhlngParser.ExpressaoContext ctx) {
        if (ctx.opRelacional() != null) {
            TabelaSimbolos.Tipo a = visit(ctx.expressaoSimples(0));
            TabelaSimbolos.Tipo b = visit(ctx.expressaoSimples(1));
            String op = ctx.opRelacional().getText();
            int ln = ctx.getStart().getLine();
            if (op.equals("<") || op.equals("<=") || op.equals(">") || op.equals(">=")) {
                if (!isNumero(a) || !isNumero(b)) {
                    erro(ln, "Erro: tipos incompatíveis na comparação '" + ctx.expressaoSimples(0).getText() + " " + op + " " + ctx.expressaoSimples(1).getText() + "'.");
                    return TabelaSimbolos.Tipo.INDEFINIDO;
                }
            } else {
                boolean okEq = (isNumero(a) && isNumero(b)) || (a == TabelaSimbolos.Tipo.BOOLEAN && b == TabelaSimbolos.Tipo.BOOLEAN) || (a == b);
                if (!okEq) {
                    erro(ln, "Erro: comparação '" + ctx.expressaoSimples(0).getText() + " " + op + " " + ctx.expressaoSimples(1).getText() + "' com tipos incompatíveis.");
                    return TabelaSimbolos.Tipo.INDEFINIDO;
                }
            }
            return TabelaSimbolos.Tipo.BOOLEAN;
        }
        return visit(ctx.expressaoSimples(0));
    }
    
    @Override
    public TabelaSimbolos.Tipo visitExpressaoSimples(gyhlngParser.ExpressaoSimplesContext ctx) {
        TabelaSimbolos.Tipo r = visit(ctx.termo(0));
        for (int i = 1; i < ctx.termo().size(); i++) {
            TabelaSimbolos.Tipo t = visit(ctx.termo(i));
            String op = ctx.getChild(2 * i - 1).getText().toUpperCase();
            int ln = ctx.getStart().getLine();
            if (op.equals("OU")) {
                if (r != TabelaSimbolos.Tipo.BOOLEAN || t != TabelaSimbolos.Tipo.BOOLEAN) {
                    erro(ln, "Erro: operação lógica 'OU' requer booleanos.");
                    return TabelaSimbolos.Tipo.INDEFINIDO;
                }
                r = TabelaSimbolos.Tipo.BOOLEAN;
            } else {
                TabelaSimbolos.Tipo comb = combinarArit(r, t);
                if (comb == TabelaSimbolos.Tipo.INDEFINIDO) {
                    erro(ln, "Erro: operação aritmética apenas entre números.");
                    return comb;
                }
                r = comb;
            }
        }
        return r;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitTermo(gyhlngParser.TermoContext ctx) {
        TabelaSimbolos.Tipo r = visit(ctx.fator(0));
        for (int i = 1; i < ctx.fator().size(); i++) {
            TabelaSimbolos.Tipo t = visit(ctx.fator(i));
            String op = ctx.getChild(2 * i - 1).getText().toUpperCase();
            int ln = ctx.getStart().getLine();
            if (op.equals("E")) {
                if (r != TabelaSimbolos.Tipo.BOOLEAN || t != TabelaSimbolos.Tipo.BOOLEAN) {
                    erro(ln, "Erro: operação lógica 'E' requer booleanos.");
                    return TabelaSimbolos.Tipo.INDEFINIDO;
                }
                r = TabelaSimbolos.Tipo.BOOLEAN;
            } else {
                TabelaSimbolos.Tipo comb = combinarArit(r, t);
                if (comb == TabelaSimbolos.Tipo.INDEFINIDO) {
                    erro(ln, "Erro: operação aritmética apenas entre números.");
                    return comb;
                }
                r = comb;
            }
        }
        return r;
    }
    
    @Override
    public TabelaSimbolos.Tipo visitFator(gyhlngParser.FatorContext ctx) {
        if (ctx.VAR() != null) {
            String nome = ctx.VAR().getText();
            if (!tabela.existe(nome)) {
                erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' usada antes da declaração.");
                return TabelaSimbolos.Tipo.INDEFINIDO;
            }
            if (!tabela.isInicializado(nome)) {
                erro(ctx.getStart().getLine(), "Erro: variável '" + nome + "' usada sem valor inicial.");
            }
            return tabela.getTipo(nome);
        }
        if (ctx.numero() != null) {
            if (ctx.numero().NumInt() != null) return TabelaSimbolos.Tipo.INTEGER;
            return TabelaSimbolos.Tipo.REAL;
        }
        if (ctx.CADEIA() != null) {
            return TabelaSimbolos.Tipo.INDEFINIDO;
        }
        String txt = ctx.getText().toUpperCase();
        if (txt.equals("VERDADEIRO") || txt.equals("FALSO")) return TabelaSimbolos.Tipo.BOOLEAN;
        if (ctx.expressao() != null) return visit(ctx.expressao());
        if (txt.startsWith("NAO")) {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (ctx.getChild(i) instanceof gyhlngParser.FatorContext) {
                    TabelaSimbolos.Tipo tf = visit((gyhlngParser.FatorContext) ctx.getChild(i));
                    if (tf != TabelaSimbolos.Tipo.BOOLEAN) return TabelaSimbolos.Tipo.INDEFINIDO;
                    return TabelaSimbolos.Tipo.BOOLEAN;
                }
            }
        }
        return TabelaSimbolos.Tipo.INDEFINIDO;
    }
    
    private boolean isNumero(TabelaSimbolos.Tipo t) {
        return t == TabelaSimbolos.Tipo.INTEGER || t == TabelaSimbolos.Tipo.REAL;
    }
    
    private boolean tiposCompativeis(TabelaSimbolos.Tipo varType, TabelaSimbolos.Tipo exprType) {
        if (varType == exprType) return true;
        if (varType == TabelaSimbolos.Tipo.REAL && exprType == TabelaSimbolos.Tipo.INTEGER) return true;
        return false;
    }
    
    private TabelaSimbolos.Tipo combinarArit(TabelaSimbolos.Tipo a, TabelaSimbolos.Tipo b) {
        if (!isNumero(a) || !isNumero(b)) return TabelaSimbolos.Tipo.INDEFINIDO;
        if (a == TabelaSimbolos.Tipo.REAL || b == TabelaSimbolos.Tipo.REAL) return TabelaSimbolos.Tipo.REAL;
        return TabelaSimbolos.Tipo.INTEGER;
    }
}