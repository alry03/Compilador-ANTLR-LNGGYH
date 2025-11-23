import java.util.*;

public class GyhCGenerator extends gyhlngBaseVisitor<TabelaSimbolos.Tipo> {
    private final TabelaSimbolos tabela;
    private final Map<String, TabelaSimbolos.Tipo> tipos = new HashMap<>();
    private final List<String> codigo = new ArrayList<>();
    private final List<String> decls = new ArrayList<>();
    private final List<String> body = new ArrayList<>();
    private int indent = 1;
    private String lastExpr = "";

    public GyhCGenerator(TabelaSimbolos tabela) {
        this.tabela = tabela;
    }

    public List<String> getCodigo() { return codigo; }

    private void emit(String s) { body.add("    ".repeat(indent) + s); }

    private void addDecl(String s) { decls.add("    ".repeat(1) + s); }

    private String tipoC(TabelaSimbolos.Tipo t) {
        if (t == TabelaSimbolos.Tipo.INTEGER) return "int";
        if (t == TabelaSimbolos.Tipo.REAL) return "double";
        if (t == TabelaSimbolos.Tipo.BOOLEAN) return "int";
        return "int";
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

    @Override
    public TabelaSimbolos.Tipo visitPrograma(gyhlngParser.ProgramaContext ctx) {
        codigo.clear();
        decls.clear();
        body.clear();
        indent = 1;
        codigo.add("#include <stdio.h>");
        codigo.add("int main(void) {");
        if (ctx.declaracoes() != null) visit(ctx.declaracoes());
        visit(ctx.bloco());
        codigo.addAll(decls);
        codigo.addAll(body);
        codigo.add("    return 0;");
        codigo.add("}");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitProgramaBr(gyhlngParser.ProgramaBrContext ctx) {
        codigo.clear();
        decls.clear();
        body.clear();
        indent = 1;
        codigo.add("#include <stdio.h>");
        codigo.add("int main(void) {");
        if (ctx.declaracoesBr() != null) visit(ctx.declaracoesBr());
        if (ctx.comandosBr() != null) visit(ctx.comandosBr());
        codigo.addAll(decls);
        codigo.addAll(body);
        codigo.add("    return 0;");
        codigo.add("}");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitDeclaracao(gyhlngParser.DeclaracaoContext ctx) {
        TabelaSimbolos.Tipo tipo = tipoDe(ctx.tipo().getText());
        List<String> vars = new ArrayList<>();
        for (int i = 0; i < ctx.listaVars().VAR().size(); i++) {
            String nome = ctx.listaVars().VAR(i).getText();
            tipos.put(nome, tipo);
            vars.add(nome);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(tipoC(tipo)).append(" ");
        for (int i = 0; i < vars.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(vars.get(i));
        }
        sb.append(";");
        addDecl(sb.toString());
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitDeclaracaoBr(gyhlngParser.DeclaracaoBrContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo tipo = tipoDe(ctx.tipo().getText());
        tipos.put(nome, tipo);
        addDecl(tipoC(tipo) + " " + nome + ";");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitBloco(gyhlngParser.BlocoContext ctx) {
        emit("{");
        indent++;
        TabelaSimbolos.Tipo t = super.visitBloco(ctx);
        indent--;
        emit("}");
        return t;
    }

    @Override
    public TabelaSimbolos.Tipo visitAtribuicao(gyhlngParser.AtribuicaoContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo tv = obterTipo(nome);
        TabelaSimbolos.Tipo te = visit(ctx.expressao());
        String e = lastExpr;
        if (tv == TabelaSimbolos.Tipo.REAL && te == TabelaSimbolos.Tipo.INTEGER) e = "(double)(" + e + ")";
        emit(nome + " = " + e + ";");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitAtribuicaoBr(gyhlngParser.AtribuicaoBrContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo tv = obterTipo(nome);
        TabelaSimbolos.Tipo te = visit(ctx.expressao());
        String e = lastExpr;
        if (tv == TabelaSimbolos.Tipo.REAL && te == TabelaSimbolos.Tipo.INTEGER) e = "(double)(" + e + ")";
        emit(nome + " = " + e + ";");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoLeitura(gyhlngParser.ComandoLeituraContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo t = obterTipo(nome);
        if (t == TabelaSimbolos.Tipo.REAL) emit("scanf(\"%lf\", &" + nome + ");");
        else emit("scanf(\"%d\", &" + nome + ");");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoLeituraBr(gyhlngParser.ComandoLeituraBrContext ctx) {
        String nome = ctx.VAR().getText();
        TabelaSimbolos.Tipo t = obterTipo(nome);
        if (t == TabelaSimbolos.Tipo.REAL) emit("scanf(\"%lf\", &" + nome + ");");
        else emit("scanf(\"%d\", &" + nome + ");");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoEscrita(gyhlngParser.ComandoEscritaContext ctx) {
        TabelaSimbolos.Tipo t = visit(ctx.expressao());
        String e = lastExpr;
        if (t == TabelaSimbolos.Tipo.REAL) emit("printf(\"%lf\\n\", " + e + ");");
        else if (t == TabelaSimbolos.Tipo.INTEGER || t == TabelaSimbolos.Tipo.BOOLEAN) emit("printf(\"%d\\n\", " + e + ");");
        else emit("printf(\"%s\\n\", " + e + ");");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoEscritaBr(gyhlngParser.ComandoEscritaBrContext ctx) {
        if (ctx.VAR() != null) {
            String nome = ctx.VAR().getText();
            TabelaSimbolos.Tipo t = obterTipo(nome);
            if (t == TabelaSimbolos.Tipo.REAL) emit("printf(\"%lf\\n\", " + nome + ");");
            else if (t == TabelaSimbolos.Tipo.INTEGER || t == TabelaSimbolos.Tipo.BOOLEAN) emit("printf(\"%d\\n\", " + nome + ");");
            else emit("printf(\"%s\\n\", " + nome + ");");
        } else {
            String s = ctx.CADEIA().getText();
            String sn = s.substring(0, s.length() - 1) + "\\n\"";
            emit("printf(" + sn + ");");
        }
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoCondicional(gyhlngParser.ComandoCondicionalContext ctx) {
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        String e = lastExpr;
        emit("if (" + e + ") {");
        indent++;
        visit(ctx.comando(0));
        indent--;
        emit("}");
        if (ctx.SENAO() != null) {
            emit("else {");
            indent++;
            visit(ctx.comando(1));
            indent--;
            emit("}");
        }
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoCondicionalBr(gyhlngParser.ComandoCondicionalBrContext ctx) {
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        String e = lastExpr;
        emit("if (" + e + ") {");
        indent++;
        visit(ctx.comandoBr(0));
        indent--;
        emit("}");
        if (ctx.SENAO() != null) {
            emit("else {");
            indent++;
            visit(ctx.comandoBr(1));
            indent--;
            emit("}");
        }
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitSubAlgBr(gyhlngParser.SubAlgBrContext ctx) {
        emit("{");
        indent++;
        TabelaSimbolos.Tipo t = super.visitSubAlgBr(ctx);
        indent--;
        emit("}");
        return t;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoRepeticao(gyhlngParser.ComandoRepeticaoContext ctx) {
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        String e = lastExpr;
        emit("while (" + e + ") {");
        indent++;
        visit(ctx.comando());
        indent--;
        emit("}");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitComandoRepeticaoBr(gyhlngParser.ComandoRepeticaoBrContext ctx) {
        TabelaSimbolos.Tipo c = visit(ctx.expressao());
        String e = lastExpr;
        emit("while (" + e + ") {");
        indent++;
        visit(ctx.comandoBr());
        indent--;
        emit("}");
        return null;
    }

    @Override
    public TabelaSimbolos.Tipo visitExpressao(gyhlngParser.ExpressaoContext ctx) {
        if (ctx.opRelacional() != null) {
            TabelaSimbolos.Tipo a = visit(ctx.expressaoSimples(0));
            String ae = lastExpr;
            TabelaSimbolos.Tipo b = visit(ctx.expressaoSimples(1));
            String be = lastExpr;
            String op = ctx.opRelacional().getText();
            String cop;
            if ("<".equals(op)) cop = "<";
            else if ("<=".equals(op)) cop = "<=";
            else if (">".equals(op)) cop = ">";
            else if (">=".equals(op)) cop = ">=";
            else if ("==".equals(op) || "=".equals(op)) cop = "==";
            else cop = "!=";
            lastExpr = "(" + ae + ") " + cop + " (" + be + ")";
            return TabelaSimbolos.Tipo.BOOLEAN;
        }
        return visit(ctx.expressaoSimples(0));
    }

    @Override
    public TabelaSimbolos.Tipo visitExpressaoSimples(gyhlngParser.ExpressaoSimplesContext ctx) {
        TabelaSimbolos.Tipo r = visit(ctx.termo(0));
        String re = lastExpr;
        for (int i = 1; i < ctx.termo().size(); i++) {
            TabelaSimbolos.Tipo t = visit(ctx.termo(i));
            String te = lastExpr;
            String op = ctx.getChild(2 * i - 1).getText().toUpperCase();
            if (op.equals("OU")) { lastExpr = "(" + re + ") || (" + te + ")"; r = TabelaSimbolos.Tipo.BOOLEAN; }
            else {
                String cop = op.equals("+") ? "+" : "-";
                lastExpr = "(" + re + ") " + cop + " (" + te + ")";
                if (r == TabelaSimbolos.Tipo.REAL || t == TabelaSimbolos.Tipo.REAL) r = TabelaSimbolos.Tipo.REAL; else if (r == TabelaSimbolos.Tipo.INTEGER && t == TabelaSimbolos.Tipo.INTEGER) r = TabelaSimbolos.Tipo.INTEGER; else r = TabelaSimbolos.Tipo.INDEFINIDO;
            }
            re = lastExpr;
        }
        return r;
    }

    @Override
    public TabelaSimbolos.Tipo visitTermo(gyhlngParser.TermoContext ctx) {
        TabelaSimbolos.Tipo r = visit(ctx.fator(0));
        String re = lastExpr;
        for (int i = 1; i < ctx.fator().size(); i++) {
            TabelaSimbolos.Tipo t = visit(ctx.fator(i));
            String te = lastExpr;
            String op = ctx.getChild(2 * i - 1).getText().toUpperCase();
            if (op.equals("E")) { lastExpr = "(" + re + ") && (" + te + ")"; r = TabelaSimbolos.Tipo.BOOLEAN; }
            else {
                String cop = op.equals("*") ? "*" : "/";
                lastExpr = "(" + re + ") " + cop + " (" + te + ")";
                if (r == TabelaSimbolos.Tipo.REAL || t == TabelaSimbolos.Tipo.REAL) r = TabelaSimbolos.Tipo.REAL; else if (r == TabelaSimbolos.Tipo.INTEGER && t == TabelaSimbolos.Tipo.INTEGER) r = TabelaSimbolos.Tipo.INTEGER; else r = TabelaSimbolos.Tipo.INDEFINIDO;
            }
            re = lastExpr;
        }
        return r;
    }

    @Override
    public TabelaSimbolos.Tipo visitFator(gyhlngParser.FatorContext ctx) {
        if (ctx.VAR() != null) {
            String nome = ctx.VAR().getText();
            lastExpr = nome;
            return obterTipo(nome);
        }
        if (ctx.numero() != null) {
            if (ctx.numero().NumInt() != null) { lastExpr = ctx.numero().NumInt().getText(); return TabelaSimbolos.Tipo.INTEGER; }
            lastExpr = ctx.numero().NumReal().getText();
            return TabelaSimbolos.Tipo.REAL;
        }
        if (ctx.CADEIA() != null) { lastExpr = ctx.CADEIA().getText(); return TabelaSimbolos.Tipo.INDEFINIDO; }
        if (ctx.expressao() != null) return visit(ctx.expressao());
        String txt = ctx.getText().toUpperCase();
        if (txt.startsWith("NAO")) { TabelaSimbolos.Tipo tf = visit(ctx.fator()); lastExpr = "!(" + lastExpr + ")"; return TabelaSimbolos.Tipo.BOOLEAN; }
        if (txt.equals("VERDADEIRO")) { lastExpr = "1"; return TabelaSimbolos.Tipo.BOOLEAN; }
        if (txt.equals("FALSO")) { lastExpr = "0"; return TabelaSimbolos.Tipo.BOOLEAN; }
        lastExpr = "0";
        return TabelaSimbolos.Tipo.INDEFINIDO;
    }
}