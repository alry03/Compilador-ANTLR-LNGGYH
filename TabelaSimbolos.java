import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Classe para gerenciar a tabela de símbolos com suporte a escopos aninhados
 */
public class TabelaSimbolos {
    
    public enum Tipo {
        INTEGER, REAL, BOOLEAN, INDEFINIDO
    }
    
    public static class Simbolo {
        private String nome;
        private Tipo tipo;
        private boolean inicializado;
        
        public Simbolo(String nome, Tipo tipo) {
            this.nome = nome;
            this.tipo = tipo;
            this.inicializado = false;
        }
        
        public String getNome() { return nome; }
        public Tipo getTipo() { return tipo; }
        public boolean isInicializado() { return inicializado; }
        public void setInicializado(boolean inicializado) { this.inicializado = inicializado; }
    }
    
    private Stack<Map<String, Simbolo>> escopos;
    
    public TabelaSimbolos() {
        escopos = new Stack<>();
        // Escopo global
        escopos.push(new HashMap<>());
    }
    
    public void abrirEscopo() {
        escopos.push(new HashMap<>());
    }
    
    public void fecharEscopo() {
        if (escopos.size() > 1) {
            escopos.pop();
        }
    }

    public void enterScope() { abrirEscopo(); }
    public void exitScope() { fecharEscopo(); }
    
    public boolean declarar(String nome, Tipo tipo) {
        Map<String, Simbolo> escopoAtual = escopos.peek();
        if (escopoAtual.containsKey(nome)) {
            return false; // Variável já declarada no escopo atual
        }
        escopoAtual.put(nome, new Simbolo(nome, tipo));
        return true;
    }
    
    public Simbolo buscar(String nome) {
        // Busca do escopo mais interno para o mais externo
        for (int i = escopos.size() - 1; i >= 0; i--) {
            Map<String, Simbolo> escopo = escopos.get(i);
            if (escopo.containsKey(nome)) {
                return escopo.get(nome);
            }
        }
        return null; // Variável não encontrada
    }
    
    public boolean existe(String nome) {
        return buscar(nome) != null;
    }
    
    public Tipo getTipo(String nome) {
        Simbolo simbolo = buscar(nome);
        return simbolo != null ? simbolo.getTipo() : Tipo.INDEFINIDO;
    }
    
    public void marcarInicializado(String nome) {
        Simbolo simbolo = buscar(nome);
        if (simbolo != null) {
            simbolo.setInicializado(true);
        }
    }
    
    public boolean isInicializado(String nome) {
        Simbolo simbolo = buscar(nome);
        return simbolo != null && simbolo.isInicializado();
    }
}