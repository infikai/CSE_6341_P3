package ast;
import java.io.PrintStream;
import java.util.HashMap;

public abstract class VarDecl extends ASTNode {
    public final String ident;
    public VarDecl(String i, Location loc) {
	super(loc);
	ident = i;
    }
    public abstract void print(PrintStream ps);
    public abstract void check(HashMap<String, Integer> table, HashMap<String, Boolean> Localident);
    public abstract int type();
}