package ast;
import java.util.HashMap;
import java.util.Scanner;

public abstract class CondExpr extends ASTNode {
    public CondExpr(Location loc) {
	super(loc);
    }
    public abstract void check(HashMap<String, Integer> table);
    public abstract int type();
    public abstract Boolean evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval);
}