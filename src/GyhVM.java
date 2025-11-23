import java.util.*;

public class GyhVM {
    public enum Tipo { INTEGER, REAL, BOOLEAN, STR }
    static class Valor {
        final Tipo tipo; final Object v;
        Valor(Tipo t, Object v) { this.tipo = t; this.v = v; }
        int asInt() { return (Integer)v; }
        double asReal() { return (Double)v; }
        boolean asBool() { return ((Integer)v) != 0; }
        String asStr() { return (String)v; }
    }

    private final Map<String, Integer> labels = new HashMap<>();
    private final Map<String, Tipo> tipos = new HashMap<>();
    private final Map<String, Valor> mem = new HashMap<>();
    private final List<String> code;
    private int pc = 0;
    private final Deque<Valor> stack = new ArrayDeque<>();
    private Scanner in = new Scanner(System.in);

    public GyhVM(List<String> code) { this.code = code; indexLabels(); }

    public void setTipos(Map<String, Tipo> m) { tipos.clear(); tipos.putAll(m); }
    public void setInput(Scanner s) { this.in = s; }

    private void indexLabels() {
        for (int i = 0; i < code.size(); i++) {
            String line = code.get(i);
            String[] t = line.split(" ", 2);
            if (t[0].equals("LABEL") && t.length > 1) labels.put(t[1], i);
        }
    }

    public void run() {
        pc = 0;
        while (pc < code.size()) {
            String line = code.get(pc);
            String op, arg = null;
            int sp = line.indexOf(' ');
            if (sp >= 0) { op = line.substring(0, sp); arg = line.substring(sp + 1); } else op = line;
            switch (op) {
                case "LABEL": break;
                case "JMP": pc = labels.get(arg); continue;
                case "JMPF": { Valor a = pop(); if (!a.asBool()) { pc = labels.get(arg); continue; } break; }
                case "PUSH_INT": push(new Valor(Tipo.INTEGER, Integer.parseInt(arg))); break;
                case "PUSH_REAL": push(new Valor(Tipo.REAL, Double.parseDouble(arg))); break;
                case "PUSH_STR": push(new Valor(Tipo.STR, arg)); break;
                case "LOAD": load(arg); break;
                case "STORE": store(arg); break;
                case "I2R": { Valor a = pop(); push(new Valor(Tipo.REAL, (double)a.asInt())); break; }
                case "ADD": binNum((x,y)-> x+y, (x,y)-> x+y); break;
                case "SUB": binNum((x,y)-> x-y, (x,y)-> x-y); break;
                case "MUL": binNum((x,y)-> x*y, (x,y)-> x*y); break;
                case "DIV": binNum((x,y)-> x/y, (x,y)-> x/y); break;
                case "LT": relNum((x,y)-> x<y, (x,y)-> x<y); break;
                case "LEQ": relNum((x,y)-> x<=y, (x,y)-> x<=y); break;
                case "GT": relNum((x,y)-> x>y, (x,y)-> x>y); break;
                case "GEQ": relNum((x,y)-> x>=y, (x,y)-> x>=y); break;
                case "EQ": eq(); break;
                case "NEQ": neq(); break;
                case "AND": { Valor b = pop(); Valor a = pop(); push(new Valor(Tipo.INTEGER, (a.asBool() && b.asBool()) ? 1 : 0)); break; }
                case "OR": { Valor b = pop(); Valor a = pop(); push(new Valor(Tipo.INTEGER, (a.asBool() || b.asBool()) ? 1 : 0)); break; }
                case "NOT": { Valor a = pop(); push(new Valor(Tipo.INTEGER, (!a.asBool()) ? 1 : 0)); break; }
                case "INPUT_INT": { int v = Integer.parseInt(in.nextLine().trim()); mem.put(arg, new Valor(Tipo.INTEGER, v)); break; }
                case "INPUT_REAL": { double v = Double.parseDouble(in.nextLine().trim()); mem.put(arg, new Valor(Tipo.REAL, v)); break; }
                case "PRINT_INT": { Valor a = pop(); System.out.println(a.tipo == Tipo.REAL ? (int)a.asReal() : a.asInt()); break; }
                case "PRINT_REAL": { Valor a = pop(); System.out.println(a.tipo == Tipo.INTEGER ? (double)a.asInt() : a.asReal()); break; }
                case "PRINT_STR": { Valor a = pop(); System.out.println(a.asStr().replace('"',' ').trim()); break; }
                default: throw new RuntimeException("Instrucao desconhecida: " + op);
            }
            pc++;
        }
    }

    private void push(Valor v) { stack.push(v); }
    private Valor pop() { return stack.pop(); }

    private void load(String var) {
        Valor v = mem.get(var);
        if (v == null) {
            Tipo t = tipos.getOrDefault(var, Tipo.INTEGER);
            if (t == Tipo.REAL) v = new Valor(Tipo.REAL, 0.0);
            else if (t == Tipo.BOOLEAN) v = new Valor(Tipo.INTEGER, 0);
            else v = new Valor(Tipo.INTEGER, 0);
            mem.put(var, v);
        }
        push(v);
    }

    private void store(String var) {
        Valor v = pop();
        Tipo t = tipos.getOrDefault(var, v.tipo);
        if (t == Tipo.REAL) {
            if (v.tipo == Tipo.INTEGER) v = new Valor(Tipo.REAL, (double)v.asInt());
        } else if (t == Tipo.INTEGER) {
            if (v.tipo == Tipo.REAL) throw new RuntimeException("STORE incompatível: REAL em INTEGER");
        } else if (t == Tipo.BOOLEAN) {
            v = new Valor(Tipo.INTEGER, v.asBool() ? 1 : 0);
        }
        mem.put(var, v);
    }

    private interface NumI { int f(int a, int b); }
    private interface NumR { double f(double a, double b); }
    private void binNum(NumI fi, NumR fr) {
        Valor b = pop(); Valor a = pop();
        if (a.tipo == Tipo.REAL || b.tipo == Tipo.REAL) push(new Valor(Tipo.REAL, fr.f(a.tipo==Tipo.REAL?a.asReal():a.asInt(), b.tipo==Tipo.REAL?b.asReal():b.asInt())));
        else push(new Valor(Tipo.INTEGER, fi.f(a.asInt(), b.asInt())));
    }

    private interface RelI { boolean f(int a, int b); }
    private interface RelR { boolean f(double a, double b); }
    private void relNum(RelI fi, RelR fr) {
        Valor b = pop(); Valor a = pop();
        boolean r;
        if (a.tipo == Tipo.REAL || b.tipo == Tipo.REAL) r = fr.f(a.tipo==Tipo.REAL?a.asReal():a.asInt(), b.tipo==Tipo.REAL?b.asReal():b.asInt());
        else r = fi.f(a.asInt(), b.asInt());
        push(new Valor(Tipo.INTEGER, r ? 1 : 0));
    }

    private void eq() {
        Valor b = pop(); Valor a = pop();
        boolean r;
        if (a.tipo == Tipo.REAL || b.tipo == Tipo.REAL) r = (a.tipo==Tipo.REAL?a.asReal():a.asInt()) == (b.tipo==Tipo.REAL?b.asReal():b.asInt());
        else if (a.tipo == Tipo.INTEGER && b.tipo == Tipo.INTEGER) r = a.asInt() == b.asInt();
        else if (a.tipo == Tipo.INTEGER && b.tipo == Tipo.INTEGER) r = a.asInt() == b.asInt();
        else r = a.asBool() == b.asBool();
        push(new Valor(Tipo.INTEGER, r ? 1 : 0));
    }

    private void neq() {
        Valor b = pop(); Valor a = pop();
        boolean r;
        if (a.tipo == Tipo.REAL || b.tipo == Tipo.REAL) r = (a.tipo==Tipo.REAL?a.asReal():a.asInt()) != (b.tipo==Tipo.REAL?b.asReal():b.asInt());
        else if (a.tipo == Tipo.INTEGER && b.tipo == Tipo.INTEGER) r = a.asInt() != b.asInt();
        else r = a.asBool() != b.asBool();
        push(new Valor(Tipo.INTEGER, r ? 1 : 0));
    }
}