package ast;
import java.io.PrintStream;
import java.util.HashMap;

public class UnaryMinusExpr extends Expr {
    public final Expr expr;
    public UnaryMinusExpr(Expr e, Location loc) {
	super(loc);
	expr = e; 
    }
    public void print(PrintStream ps) {
	ps.print("-(");
	expr.print(ps);
	ps.print(")");
    }
    public void check(HashMap<String, Integer> table) {
        expr.check(table);
    }
    public int type() {
        return expr.type();
    }
    public Long valofint(Scanner scanner, HashMap<String, Long> intval) {
        Long v;
        v = expr.valofint(scanner, intval);
        return -v;
    }
    public Double valoffloat(Scanner scanner, HashMap<String, DOuble> floatval) {
        Double v;
        v = expr.valoffloat(scanner, floatval);
        return -v;
    }
}