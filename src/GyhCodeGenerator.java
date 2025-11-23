import java.util.*;

public class GyhCodeGenerator extends gyhlngBaseVisitor<TabelaSimbolos.Tipo> {
    private final TabelaSimbolos tabela;
    private final Map<String, Integer> memoria = new LinkedHashMap<>();
    private final Map<String, TabelaSimbolos.Tipo> tipos = new HashMap<>();
    private final List<String> codigo = new ArrayList<>();
    private int proxAddr = 0;
    private int lbl = 0;

    public GyhCodeGenerator(TabelaSimbolos tabela) {
        this.tabela = tabela;
    }

    public List<String> getCodigo() { return codigo; }

    private String novoLabel(String p) { return p + (lbl++); }

    private void mapearVariavel(String nome, TabelaSimbolos.Tipo tipo) {
        if (!memoria.containsKey(nome)) {
            memoria.put(nome, proxAddr++);
            tipos.put(nome, tipo);
        }
    }

    private void pushInt(int v) { codigo.add("PUSH_INT " + v); }
    private void pushReal(double v) { codigo.add("PUSH_REAL " + v); }
    private void pushStr(String s) { codigo.add("PUSH_STR " + s); }
    private void loadVar(String nome) { codigo.add("LOAD " + nome); }
    private void storeVar(String nome) { codigo.add("STORE " + nome); }

    @Override
    public TabelaSimbolos.Tipo visitProgramaBr(gyhlngParser.ProgramaBrContext ctx) {
        visit(ctx.declaracoesBr());
        visit(ctx.comandosBr());
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitDeclaracaoBr(gyhlngParser.DeclaracaoBrContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo tipo = tipoDe(ctx.tipo().getText());
        mapearVariavel(nome, tipo);
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitAtribuicaoBr(gyhlngParser.AtribuicaoBrContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo tv = obterTipo(nome);
        TabelaSimbolos.Tipo te = visit(ctx.expressao());
        if (tv == TabelaSimbolos.Tipo.REAL && te == TabelaSimbolos.Tipo.INTEGER) codigo.add("I2R");
        storeVar(nome);
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoLeituraBr(gyhlngParser.ComandoLeituraBrContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo t = obterTipo(nome);
        if (t == TabelaSimbolos.Tipo.REAL) codigo.add("INPUT_REAL " + nome); else codigo.add("INPUT_INT " + nome);
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoEscritaBr(gyhlngParser.ComandoEscritaBrContext ctx) {
        if (ctx.VAR() != null) {
            String nome = ctx.VAR().getText();
            TabelaSimbolos.Tipo t = obterTipo(nome);
            loadVar(nome);
            if (t == TabelaSimbolos.Tipo.REAL) codigo.add("PRINT_REAL");
            else if (t == TabelaSimbolos.Tipo.INTEGER) codigo.add("PRINT_INT");
            else codigo.add("PRINT_STR");
        } else {
            String s = ctx.CADEIA().getText();
            pushStr(s);
            codigo.add("PRINT_STR");
        }
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoCondicionalBr(gyhlngParser.ComandoCondicionalBrContext ctx) {
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        String Lf = novoLabel("L_false_");
        String Le = novoLabel("L_end_");
        codigo.add("JMPF " + Lf);
        visit(ctx.comandoBr(0));
        if (ctx.SENAO() != null) {
            codigo.add("JMP " + Le);
        }
        codigo.add("LABEL " + Lf);
        if (ctx.SENAO() != null) {
            visit(ctx.comandoBr(1));
            codigo.add("LABEL " + Le);
        }
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoRepeticaoBr(gyhlngParser.ComandoRepeticaoBrContext ctx) {
        String Ls = novoLabel("L_start_");
        String Le = novoLabel("L_end_");
        codigo.add("LABEL " + Ls);
        visit(ctx.expressao());
        codigo.add("JMPF " + Le);
        visit(ctx.comandoBr());
        codigo.add("JMP " + Ls);
        codigo.add("LABEL " + Le);
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitPrograma(gyhlngParser.ProgramaContext ctx) {
        if (ctx.declaracoes() != null) visit(ctx.declaracoes());
        visit(ctx.bloco());
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitDeclaracao(gyhlngParser.DeclaracaoContext ctx) {
        TabelaSimbolos.Tipo tipo = tipoDe(ctx.tipo().getText());
        for (int i = 0; i < ctx.listaVars().VAR().size(); i++) {
            String nome = ctx.listaVars().VAR(i).getText();
            mapearVariavel(nome, tipo);
        }
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitAtribuicao(gyhlngParser.AtribuicaoContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo tv = obterTipo(nome);
        TabelaSimbolos.Tipo te = visit(ctx.expressao());
        if (tv == TabelaSimbolos.Tipo.REAL && te == TabelaSimbolos.Tipo.INTEGER) codigo.add("I2R");
        storeVar(nome);
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoLeitura(gyhlngParser.ComandoLeituraContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo t = obterTipo(nome);
        if (t == TabelaSimbolos.Tipo.REAL) codigo.add("INPUT_REAL " + nome); else codigo.add("INPUT_INT " + nome);
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoEscrita(gyhlngParser.ComandoEscritaContext ctx) {
        TabelaSimbolos.Tipo t = visit(ctx.expressao());
        if (t == TabelaSimbolos.Tipo.REAL) codigo.add("PRINT_REAL");
        else if (t == TabelaSimbolos.Tipo.INTEGER) codigo.add("PRINT_INT");
        else codigo.add("PRINT_STR");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoCondicional(gyhlngParser.ComandoCondicionalContext ctx) {
        visit(ctx.expressao());
        String Lf = novoLabel("L_false_");
        String Le = novoLabel("L_end_");
        codigo.add("JMPF " + Lf);
        visit(ctx.comando(0));
        if (ctx.SENAO() != null) codigo.add("JMP " + Le);
        codigo.add("LABEL " + Lf);
        if (ctx.SENAO() != null) { visit(ctx.comando(1)); codigo.add("LABEL " + Le); }
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoRepeticao(gyhlngParser.ComandoRepeticaoContext ctx) {
        String Ls = novoLabel("L_start_");
        String Le = novoLabel("L_end_");
        codigo.add("LABEL " + Ls);
        visit(ctx.expressao());
        codigo.add("JMPF " + Le);
        visit(ctx.comando());
        codigo.add("JMP " + Ls);
        codigo.add("LABEL " + Le);
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitExpressao(gyhlngParser.ExpressaoContext ctx) {
        if (ctx.opRelacional() != null) {
            TabelaSimbolos.Tipo a = visit(ctx.expressaoSimples(0));
            TabelaSimbolos.Tipo b = visit(ctx.expressaoSimples(1));
            String op = ctx.opRelacional().getText();
            if (op.equals("<")) codigo.add("LT");
            else if (op.equals("<=")) codigo.add("LEQ");
            else if (op.equals(">")) codigo.add("GT");
            else if (op.equals(">=")) codigo.add("GEQ");
            else if (op.equals("==") || op.equals("=")) codigo.add("EQ");
            else codigo.add("NEQ");
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
            if (op.equals("OU")) { codigo.add("OR"); r = TabelaSimbolos.Tipo.BOOLEAN; }
            else {
                if (op.equals("+")) codigo.add("ADD"); else codigo.add("SUB");
                r = combinarArit(r, t);
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
            if (op.equals("E")) { codigo.add("AND"); r = TabelaSimbolos.Tipo.BOOLEAN; }
            else { if (op.equals("*")) codigo.add("MUL"); else codigo.add("DIV"); r = combinarArit(r, t); }
        }
        return r;
    }

    @Override
    public TabelaSimbolos.Tipo visitFator(gyhlngParser.FatorContext ctx) {
        if (ctx.VAR() != null) {
            String nome = ctx.VAR().getText();
            loadVar(nome);
            return obterTipo(nome);
        }
        if (ctx.numero() != null) {
            if (ctx.numero().NumInt() != null) { pushInt(Integer.parseInt(ctx.numero().NumInt().getText())); return TabelaSimbolos.Tipo.INTEGER; }
            pushReal(Double.parseDouble(ctx.numero().NumReal().getText()));
            return TabelaSimbolos.Tipo.REAL;
        }
        if (ctx.CADEIA() != null) { pushStr(ctx.CADEIA().getText()); return TabelaSimbolos.Tipo.INDEFINIDO; }
        if (ctx.expressao() != null) return visit(ctx.expressao());
        String txt = ctx.getText().toUpperCase();
        if (txt.startsWith("NAO")) { TabelaSimbolos.Tipo tf = visit(ctx.fator()); codigo.add("NOT"); return TabelaSimbolos.Tipo.BOOLEAN; }
        if (txt.equals("VERDADEIRO")) { codigo.add("PUSH_INT 1"); return TabelaSimbolos.Tipo.BOOLEAN; }
        if (txt.equals("FALSO")) { codigo.add("PUSH_INT 0"); return TabelaSimbolos.Tipo.BOOLEAN; }
        return TabelaSimbolos.Tipo.INDEFINIDO;
    }

    private TabelaSimbolos.Tipo tipoDe(String s) {
        if ("INTEGER".equals(s)) return TabelaSimbolos.Tipo.INTEGER;
        if ("REAL".equals(s)) return TabelaSimbolos.Tipo.REAL;
        if ("BOOLEAN".equals(s)) return TabelaSimbolos.Tipo.BOOLEAN;
        return TabelaSimbolos.Tipo.INDEFINIDO;
    }

    private TabelaSimbolos.Tipo obterTipo(String nome) {
        TabelaSimbolos.Tipo t = tipos.get(nome);
        if (t != null) return t;
        return tabela.getTipo(nome);
    }

    private boolean isNumero(TabelaSimbolos.Tipo t) { return t == TabelaSimbolos.Tipo.INTEGER || t == TabelaSimbolos.Tipo.REAL; }

    private TabelaSimbolos.Tipo combinarArit(TabelaSimbolos.Tipo a, TabelaSimbolos.Tipo b) {
        if (!isNumero(a) || !isNumero(b)) return TabelaSimbolos.Tipo.INDEFINIDO;
        if (a == TabelaSimbolos.Tipo.REAL || b == TabelaSimbolos.Tipo.REAL) return TabelaSimbolos.Tipo.REAL;
        return TabelaSimbolos.Tipo.INTEGER;
    }
}