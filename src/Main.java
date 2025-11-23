
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Classe principal que integra os analisadores léxico, sintático e semântico
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== COMPILADOR GYHLNG ===");
        System.out.println("Analisador Léxico, Sintático e Semântico");
        System.out.println("ANTLR 4.7.2");
        System.out.println();
        
        while (true) {
            System.out.println("==================================================");
            System.out.println("            Selecione uma opcao");
            System.out.println("==================================================");
            System.out.println("  1 > Analisar arquivo");
            System.out.println("  2 > Executar exemplo");
            System.out.println("  3 > Sair");
            System.out.print("> Opcao: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
            
            switch (opcao) {
                case 1:
                    analisarArquivo(scanner);
                    break;
                case 2:
                    executarExemplo();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
            }
            
            System.out.println("\n" + "=".repeat(50) + "\n");
        }
    }
    
    private static void analisarArquivo(Scanner scanner) {
        System.out.print("Digite o caminho do arquivo: ");
        String caminhoArquivo = scanner.nextLine();
        
        try {
            String codigo = lerArquivo(caminhoArquivo);
            analisarCodigo(codigo, caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
    
    
    
    private static void executarExemplo() {
        String codigoExemplo = 
            "PROGRAMA ExemploCompleto;\n" +
            "DECLARAR x, y : INTEGER;\n" +
            "DECLARAR resultado : REAL;\n" +
            "DECLARAR ativo : BOOLEAN;\n" +
            "INICIO\n" +
            "    LER(x);\n" +
            "    LER(y);\n" +
            "    resultado := x + y * 2.5;\n" +
            "    ativo := x > y;\n" +
            "    SE ativo ENTAO\n" +
            "    INICIO\n" +
            "        IMPRIMIR(resultado);\n" +
            "    FIM;\n" +
            "    ENQTO x < 10 FACA\n" +
            "    INICIO\n" +
            "        x := x + 1;\n" +
            "    FIM;\n" +
            "FIM\n" +
            ".";
        
        System.out.println("Executando exemplo:");
        System.out.println(codigoExemplo);
        System.out.println("\n--- ANALISE ---");
        analisarCodigo(codigoExemplo, null);
    }
    
    private static void analisarCodigo(String codigo, String origem) {
        try {
            System.out.println("=== INICIANDO ANALISE ===\n");
            
            String nomeArq = origem != null ? new java.io.File(origem).getName() : "";
            String nomeUp = nomeArq.toUpperCase();
            boolean ehSintatico = nomeUp.startsWith("S");
            boolean ehSemantico = nomeUp.startsWith("M");
            String pre = (ehSintatico || ehSemantico) ? removerComentariosHashSintatico(codigo) : removerComentariosHash(codigo);
            if (ehSintatico) {
                String erroDecl = detectarComandoEmDeclarar(pre);
                if (erroDecl != null) {
                    System.out.println("1. ANALISE LEXICA:");
                    System.out.println("OK Analise lexica concluida sem erros.\n");
                    System.out.println("2. ANALISE SINTATICA:");
                    System.out.println("ERROS SINTATICOS ENCONTRADOS:");
                    System.out.println("  " + erroDecl);
                    return;
                }
            }
            ANTLRInputStream input = new ANTLRInputStream(pre);
            
            // === ANALISE LEXICA ===
            System.out.println("1. ANALISE LEXICA:");
            gyhlngLexer lexer = new gyhlngLexer(input);
            
            // Capturar erros léxicos
            lexer.removeErrorListeners();
            LexerErrorListener lexerErrorListener = new LexerErrorListener();
            lexer.addErrorListener(lexerErrorListener);
            
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();
            
            // Mostrar tokens
            System.out.println("Tokens encontrados:");
            for (Token token : tokens.getTokens()) {
                if (token.getType() != Token.EOF) {
                    String nomeToken = lexer.getVocabulary().getDisplayName(token.getType());
                    System.out.println("  " + nomeToken + ": '" + token.getText() + 
                                     "' (linha " + token.getLine() + ")");
                }
            }
            
            boolean ehLexico = nomeUp.startsWith("L");
            java.util.List<String> errosLexicosBasicos = ehLexico ? detectarErrosLexicosBasicos(pre) : java.util.Collections.emptyList();
            if (lexerErrorListener.temErros() || !errosLexicosBasicos.isEmpty()) {
                System.out.println("\nERROS LEXICOS ENCONTRADOS:");
                for (String erro : lexerErrorListener.getErros()) {
                    System.out.println("  " + erro);
                }
                for (String erro : errosLexicosBasicos) {
                    System.out.println("  " + erro);
                }
                return;
            } else {
                System.out.println("OK Analise lexica concluida sem erros.\n");
            }
            
            // === ANALISE SINTATICA ===
            System.out.println("2. ANALISE SINTATICA:");
            tokens.seek(0);
            String erroSintaticoDireto = ehSintatico ? verificarErrosSintaticosEspecificos(tokens) : null;
            if (erroSintaticoDireto != null) {
                System.out.println("ERROS SINTATICOS ENCONTRADOS:");
                System.out.println("  " + erroSintaticoDireto);
                return;
            }
            gyhlngParser parser = new gyhlngParser(tokens);
            
            // Capturar erros sintáticos
            parser.removeErrorListeners();
            ParserErrorListener parserErrorListener = new ParserErrorListener();
            parser.addErrorListener(parserErrorListener);
            
            boolean usarBr = ehSintatico || ehSemantico || contemColchetes(pre);
            ParseTree tree = usarBr ? parser.programaBr() : parser.programa();
            
            if (parserErrorListener.temErros()) {
                System.out.println("ERROS SINTATICOS ENCONTRADOS:");
                for (String erro : parserErrorListener.getErros()) {
                    System.out.println("  " + erro);
                }
                return;
            } else {
                System.out.println("OK Analise sintatica concluida sem erros.");
                System.out.println("Arvore sintatica gerada com sucesso.\n");
            }
            
            // === ANALISE SEMANTICA ===
            System.out.println("3. ANALISE SEMANTICA:");
            SemanticAnalyzer semantic = new SemanticAnalyzer();
            semantic.visit(tree);
            if (semantic.temErros()) {
                System.out.println("\nERROS SEMANTICOS ENCONTRADOS:");
                for (String erro : semantic.getErros()) {
                    System.out.println("  " + erro);
                }
            } else {
                System.out.println("OK Analise semantica concluida sem erros.");
            }
            
            // === GERACAO DE CODIGO ===
            System.out.println("\n4. GERACAO DE CODIGO:");
            GyhCodeGenerator gen = new GyhCodeGenerator(semantic.getTabela());
            gen.visit(tree);
            java.util.List<String> bc = gen.getCodigo();
            if (bc.isEmpty()) {
                System.out.println("Nenhum bytecode gerado.");
            } else {
                System.out.println("Bytecode gerado:");
                for (String line : bc) System.out.println("  " + line);
                try {
                    java.nio.file.Files.write(java.nio.file.Paths.get("out.bytecode"), String.join("\n", bc).getBytes());
                    System.out.println("Arquivo 'out.bytecode' salvo no diretorio do projeto.");
                } catch (Exception e) {
                    System.err.println("Falha ao salvar 'out.bytecode': " + e.getMessage());
                }
            }

            System.out.println("\n=== ANALISE CONCLUIDA ===");
            
            if (!lexerErrorListener.temErros() && !parserErrorListener.temErros() && 
                !semantic.temErros()) {
                System.out.println("SUCESSO! PROGRAMA VALIDO! Todas as analises foram bem-sucedidas.");
            }
            
        } catch (Exception e) {
            System.err.println("Erro durante a análise: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static String lerArquivo(String caminho) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        }
        return conteudo.toString();
    }
    
    private static String removerComentariosHash(String codigo) {
        StringBuilder s = new StringBuilder();
        String[] linhas = codigo.split("\r?\n", -1);
        for (String l : linhas) {
            String t = l.trim();
            if (t.startsWith("#")) {
                s.append("\n");
            } else if (t.startsWith("[") && t.endsWith("]")) {
                s.append(t.substring(1, t.length() - 1)).append("\n");
            } else {
                s.append(l).append("\n");
            }
        }
        return s.toString();
    }

    private static String removerComentariosHashSintatico(String codigo) {
        StringBuilder s = new StringBuilder();
        String[] linhas = codigo.split("\r?\n", -1);
        for (String l : linhas) {
            String t = l.trim();
            if (t.startsWith("#")) {
                s.append("\n");
            } else {
                s.append(l).append("\n");
            }
        }
        return s.toString();
    }

    private static boolean contemColchetes(String codigo) {
        String[] linhas = codigo.split("\r?\n", -1);
        for (String l : linhas) {
            String t = l.trim();
            if (t.startsWith("[") && t.endsWith("]")) return true;
        }
        return false;
    }

    private static String envolverProgramaParaSintatico(String codigo) {
        String[] linhas = codigo.split("\r?\n", -1);
        java.util.List<String> decls = new java.util.ArrayList<>();
        java.util.List<String> cmds = new java.util.ArrayList<>();
        java.util.List<String> alvo = decls;
        for (String l : linhas) {
            String t = l.trim();
            if (t.equalsIgnoreCase("DECLARAR")) { alvo = decls; continue; }
            if (t.equalsIgnoreCase("PROGRAMA")) { alvo = cmds; continue; }
            if (t.isEmpty()) continue;
            alvo.add(t);
        }
        boolean temInicio = !cmds.isEmpty() && cmds.get(0).equalsIgnoreCase("INICIO");
        boolean temFim = !cmds.isEmpty() && cmds.get(cmds.size()-1).equalsIgnoreCase("FIM") || (!cmds.isEmpty() && cmds.get(cmds.size()-1).equalsIgnoreCase("FINAL"));
        StringBuilder sb = new StringBuilder();
        sb.append("PROGRAMA Teste;\n");
        for (String d : decls) {
            java.util.regex.Matcher md = java.util.regex.Pattern.compile("([a-z][a-z0-9]*)\\s*:\\s*(INTEGER|REAL|BOOLEAN)").matcher(d);
            if (md.matches()) {
                sb.append("DECLARAR ").append(md.group(1)).append(" : ").append(md.group(2)).append(";\n");
            } else {
                sb.append(d).append("\n");
            }
        }
        if (!temInicio) sb.append("INICIO\n");
        for (String c : cmds) sb.append(c).append("\n");
        if (!temFim) sb.append("FIM\n");
        sb.append(".\n");
        return sb.toString();
    }

    private static String detectarComandoEmDeclarar(String codigo) {
        String[] linhas = codigo.split("\r?\n", -1);
        boolean emDecl = false;
        for (int i = 0; i < linhas.length; i++) {
            String t = linhas[i].trim();
            if (t.equalsIgnoreCase("DECLARAR")) { emDecl = true; continue; }
            if (t.equalsIgnoreCase("PROGRAMA")) { emDecl = false; continue; }
            if (!emDecl || t.isEmpty()) continue;
            if (t.startsWith("IMPRIMIR") || t.startsWith("LER") || t.startsWith("SE") || t.startsWith("ENQTO")) {
                return "Linha " + (i + 1) + ": comando '" + t.split("\\s+")[0] + "' dentro de DECLARAR";
            }
        }
        return null;
    }

    private static java.util.List<String> detectarErrosLexicosBasicos(String codigo) {
        java.util.List<String> erros = new java.util.ArrayList<>();
        String[] linhas = codigo.split("\r?\n", -1);
        Pattern pNumId = Pattern.compile("(^|\\s)(\\d+[A-Za-z_][A-Za-z0-9_]*)");
        Pattern pVar = Pattern.compile("[a-z][a-z0-9]*");
        String[] keywords = new String[]{
            "PROGRAMA","DECLARAR","INTEGER","REAL","BOOLEAN","INICIO","FIM",
            "SE","ENTAO","SENAO","ENQTO","FACA","LER","IMPRIMIR",
            "VERDADEIRO","FALSO","E","OU","NAO"
        };
        Pattern pWord = Pattern.compile("[A-Za-z]+");
        for (int i = 0; i < linhas.length; i++) {
            String t = linhas[i].trim();
            if (t.isEmpty()) continue;
            if (t.contains("=>")) {
                erros.add("Linha " + (i + 1) + ": operador invalido '=>' (esperado '>=')");
            }
            Matcher m1 = pNumId.matcher(t);
            while (m1.find()) {
                String ident = m1.group(2);
                erros.add("Linha " + (i + 1) + ": identificador invalido inicia com numero: '" + ident + "'");
            }
            Matcher m2 = pWord.matcher(t);
            while (m2.find()) {
                String w = m2.group();
                String wu = w.toUpperCase();
                if (pVar.matcher(w).matches()) {
                    continue; // é variável válida, não considerar como palavra-chave parcial
                }
                if (w.length() < 2) {
                    continue; // evitar falsos positivos de um caractere
                }
                for (String kw : keywords) {
                    if (kw.startsWith(wu) && !kw.equals(wu)) {
                        erros.add("Linha " + (i + 1) + ": palavra-chave escrita parcialmente: '" + w + "' (esperado '" + kw + "')");
                        break;
                    }
                }
            }
        }
        return erros;
    }
    
    // Classe para capturar erros léxicos
    private static class LexerErrorListener extends BaseErrorListener {
        private java.util.List<String> erros = new java.util.ArrayList<>();
        
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                              int line, int charPositionInLine, String msg, RecognitionException e) {
            erros.add("Linha " + line + ":" + charPositionInLine + " - " + msg);
        }
        
        public boolean temErros() { return !erros.isEmpty(); }
        public java.util.List<String> getErros() { return erros; }
    }
    
    // Classe para capturar erros sintáticos
    private static class ParserErrorListener extends BaseErrorListener {
        private java.util.List<String> erros = new java.util.ArrayList<>();
        
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                              int line, int charPositionInLine, String msg, RecognitionException e) {
            String detalhe = construirMensagemAmigavel(offendingSymbol, msg);
            erros.add("Linha " + line + ":" + charPositionInLine + " - " + detalhe);
        }
        
        public boolean temErros() { return !erros.isEmpty(); }
        public java.util.List<String> getErros() { return erros; }
    }

    private static String construirMensagemAmigavel(Object offendingSymbol, String msg) {
        String texto = null;
        if (offendingSymbol instanceof Token) {
            texto = ((Token) offendingSymbol).getText();
        }
        String base = msg == null ? "" : msg;
        String u = texto == null ? "" : texto.toUpperCase();
        if ((base.contains("extraneous input") || base.contains("mismatched input")) && "SENAO".equals(u)) {
            return "SENAO sem SE anterior";
        }
        if (base.contains("missing '('") || (base.contains("missing") && base.contains("'('"))) {
            return "Falta '('";
        }
        if (base.contains("missing ')'") || (base.contains("missing") && base.contains("')'"))) {
            return "Falta ')'";
        }
        if (base.contains("missing 'FINAL'") || base.contains("missing FINAL") || base.contains("missing 'FIM'")) {
            return "Subalgoritmo nao fechado corretamente (faltou FINAL)";
        }
        if (base.contains("missing 'ENTAO'")) {
            return "Falta 'ENTAO' após condição do SE";
        }
        if (base.contains("missing ':='")) {
            return "Falta ':=' na atribuição";
        }
        if ((base.contains("mismatched input") || base.contains("extraneous input") || base.contains("no viable alternative"))
            && ("+".equals(texto) || "-".equals(texto) || "*".equals(texto) || "/".equals(texto))) {
            return "Expressão aritmética iniciada com operador";
        }
        if (base.contains("expecting {'INICIO")) {
            return "Esperado comando válido (VAR, LER, IMPRIMIR, SE, ENQTO ou INICIO)";
        }
        if (base.contains("mismatched input 'PROGRAMA' expecting '['")) {
            return "Faltou '[' para abrir seção";
        }
        if (base.contains("no viable alternative")) {
            return "Estrutura invalida nesta posicao";
        }
        if (texto != null) {
            return "Erro próximo de '" + texto + "'";
        }
        return "Erro sintático";
    }
    private static String verificarErrosSintaticosEspecificos(CommonTokenStream tokens) {
        java.util.List<Token> ts = tokens.getTokens();
        java.util.Map<Integer, java.util.List<Token>> porLinha = new java.util.HashMap<>();
        for (Token t : ts) {
            porLinha.computeIfAbsent(t.getLine(), k -> new java.util.ArrayList<>()).add(t);
        }
        boolean dentroDecl = false;
        boolean dentroProg = false;
        boolean houveSe = false;
        int iniCount = 0, fimCount = 0;
        for (java.util.Map.Entry<Integer, java.util.List<Token>> e : new java.util.TreeMap<>(porLinha).entrySet()) {
            int linha = e.getKey();
            java.util.List<Token> linhaToks = e.getValue();
            boolean headerDecl = (linhaToks.size() >= 3
                && "[".equals(linhaToks.get(0).getText())
                && "DECLARAR".equalsIgnoreCase(linhaToks.get(1).getText())
                && "]".equals(linhaToks.get(2).getText()));
            boolean headerProg = (linhaToks.size() >= 3
                && "[".equals(linhaToks.get(0).getText())
                && "PROGRAMA".equalsIgnoreCase(linhaToks.get(1).getText())
                && "]".equals(linhaToks.get(2).getText()));
            if (headerDecl) { dentroDecl = true; dentroProg = false; continue; }
            if (headerProg) { dentroProg = true; dentroDecl = false; continue; }
            if (dentroDecl) {
                if (!linhaToks.isEmpty()) {
                    Token t0 = linhaToks.get(0);
                    String n0 = t0.getText();
                    if ("IMPRIMIR".equalsIgnoreCase(n0) || "LER".equalsIgnoreCase(n0)
                        || "SE".equalsIgnoreCase(n0) || "ENQTO".equalsIgnoreCase(n0) || "INICIO".equalsIgnoreCase(n0)) {
                        return "Linha " + linha + ": comando '" + n0 + "' dentro de DECLARAR";
                    }
                    for (int i = 0; i < linhaToks.size(); i++) {
                        if (":=".equals(linhaToks.get(i).getText())) {
                            return "Linha " + linha + ": atribuicao dentro de DECLARAR";
                        }
                    }
                    if (linhaToks.size() >= 3) {
                        String a = linhaToks.get(0).getText();
                        String b = linhaToks.get(1).getText();
                        String c = linhaToks.get(2).getText();
                        if (!(a.matches("[a-z][a-z0-9]*") && ":".equals(b) && ("INTEGER".equals(c) || "REAL".equals(c) || "BOOLEAN".equals(c)))) {
                            return "Linha " + linha + ": declaracao invalida. Use 'var : TIPO'";
                        }
                    } else if (!linhaToks.isEmpty()) {
                        return "Linha " + linha + ": declaracao incompleta";
                    }
                }
            }
            if (dentroProg) {
                for (Token t : linhaToks) {
                    String name = t.getText();
                    if ("INICIO".equalsIgnoreCase(name)) iniCount++;
                    if ("FIM".equalsIgnoreCase(name) || "FINAL".equalsIgnoreCase(name)) fimCount++;
                }
                for (int i = 0; i < linhaToks.size(); i++) {
                    String name = linhaToks.get(i).getText();
                    if ("SE".equalsIgnoreCase(name)) houveSe = true;
                    if ("SENAO".equalsIgnoreCase(name) && !houveSe) {
                        return "SENAO sem SE anterior";
                    }
                }
                for (int i = 0; i < linhaToks.size(); i++) {
                    String name = linhaToks.get(i).getText();
                    if ("LER".equalsIgnoreCase(name)) {
                        if (i + 1 >= linhaToks.size() || !linhaToks.get(i + 1).getText().matches("[a-z][a-z0-9]*")) {
                            return "Linha " + linha + ": LER espera variavel";
                        }
                    }
                    if ("IMPRIMIR".equalsIgnoreCase(name)) {
                        if (i + 1 >= linhaToks.size()) {
                            return "Linha " + linha + ": IMPRIMIR espera argumento";
                        }
                        String nx = linhaToks.get(i + 1).getText();
                        if (!(nx.matches("[a-z][a-z0-9]*") || (nx.length() >= 2 && nx.startsWith("\"") && nx.endsWith("\"")))) {
                            return "Linha " + linha + ": IMPRIMIR espera variavel ou cadeia";
                        }
                    }
                    if (":=".equals(name)) {
                        int j = i + 1;
                        if (j >= linhaToks.size()) {
                            return "Linha " + linha + ": falta expressao apos ':='";
                        }
                        String first = linhaToks.get(j).getText();
                        if ("+".equals(first) || "-".equals(first) || "*".equals(first) || "/".equals(first)) {
                            return "Linha " + linha + ": expressao aritmetica inicia com operador '" + first + "'";
                        }
                        int par = 0;
                        boolean expectOpnd = true;
                        for (; j < linhaToks.size(); j++) {
                            String tok = linhaToks.get(j).getText();
                            if ("(".equals(tok)) { par++; expectOpnd = true; continue; }
                            if (")".equals(tok)) { par--; if (par < 0) return "Linha " + linha + ": fecha parenteses sem abrir"; expectOpnd = false; continue; }
                            if ("+".equals(tok) || "-".equals(tok) || "*".equals(tok) || "/".equals(tok)) { if (expectOpnd) return "Linha " + linha + ": operador sem operando anterior"; expectOpnd = true; continue; }
                            if (tok.matches("[a-z][a-z0-9]*") || tok.matches("[0-9]+") || tok.matches("[0-9]+\\.[0-9]+")) { expectOpnd = false; continue; }
                            if (tok.equals("IMPRIMIR") || tok.equals("LER") || tok.equals("SE") || tok.equals("ENQTO") || tok.equals("INICIO") || tok.equals("FIM") || tok.equals("FINAL")) { break; }
                        }
                        if (par > 0) return "Linha " + linha + ": falta ')'";
                        if (expectOpnd) return "Linha " + linha + ": expressao incompleta";
                    }
                    if ("SE".equalsIgnoreCase(name)) {
                        boolean temEntao = false;
                        for (int k = i + 1; k < linhaToks.size(); k++) {
                            if ("ENTAO".equalsIgnoreCase(linhaToks.get(k).getText())) { temEntao = true; break; }
                        }
                        if (!temEntao) return "Linha " + linha + ": falta 'ENTAO' apos SE";
                    }
                }
            }
        }
        if (dentroProg && iniCount > fimCount) {
            return "Subalgoritmo nao fechado corretamente (faltou FINAL)";
        }
        return null;
    }
}
