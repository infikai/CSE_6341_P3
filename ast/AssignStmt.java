package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;
import interpreter.Interpreter;

public class AssignStmt extends Stmt {
    public final String ident;
    public final Expr expr;
    public AssignStmt(String i, Expr e, Location loc) {
	super(loc);
	ident = i;
	expr = e;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + ident + " = ");
	expr.print(ps);
	ps.print(";");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
    public void check(HashMap<String, Integer> table, HashMap<String, Boolean> Localident) {
        int ident_type = 0;
        if(table.containsKey(ident)) {
            ident_type = table.get(ident);
        } else {
            Interpreter.fatalError("Violate rule 4: The variable on the left-hand side of the assignment must have a declaration in some earlier.", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
        expr.check(table);
        if(expr.type() != ident_type) {
            Interpreter.fatalError("Violate rule 5: The type of the variable on the left-hand side of = must be the same as the type of the expression on the right-hand side.", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
    }
    public void evaluate(Scanner scanner, HashMap<String, Long> intMap, HashMap<String, Double> floatMap) {
        
    }
}