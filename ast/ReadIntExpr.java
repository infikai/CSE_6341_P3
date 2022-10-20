package ast;
import java.io.PrintStream;
import java.util.HashMap;

public class ReadIntExpr extends Expr {
    public ReadIntExpr(Location loc) {
	super(loc);
    }
    public void print(PrintStream ps) {
	ps.print("readint");
    }
    public void check(HashMap<String, Integer> table) {}
    public int type() {
        return 1;
    }
    public Long valofint(Scanner scanner, HashMap<String, Long> intval) {
        Long v = 0;
        try {
            v = scanner.nextLong();
        }
        catch (Exception e) {
            Interpreter.fatalError("Violate rule:", Interpreter.EXIT_FAILED_STDIN_READ);
        }
        return v;
    }
    public Double valoffloat(Scanner scanner, HashMap<String, Double> flostval) {
        return null;
    }
}