package ast;
import java.io.PrintStream;
import java.util.HashMap;
import interpreter.Interpreter;

public class FloatVarDecl extends VarDecl {
    public FloatVarDecl(String i, Location loc) {
	super(i,loc);
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }
    public void check(HashMap<String, Integer> table, HashMap<String, Boolean> Localident) {
        if(table.containsKey(ident) && Localident.getOrDefault(ident, false)) {
            Interpreter.fatalError("Violate rule 2: Each variable can be declared only once inside each <unitList>.", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
        table.put(ident, 2);
        Localident.put(ident, true);
        //System.out.printf("Put %s in the table\n", ident);
    }
    public int type() {
        return 2;
    }
}