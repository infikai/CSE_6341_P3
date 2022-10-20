package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import interpreter.Interpreter;

public class CompExpr extends CondExpr {
    public static final int GE = 1;
    public static final int GT = 2;
    public static final int LE = 3;
    public static final int LT = 4;
    public static final int EQ = 5;
    public static final int NE = 6;
    public final Expr expr1, expr2;
    public final int op;
	public int type;
    public CompExpr(Expr e1, int oper, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	switch (op) { 
	case GE: ps.print(">="); break;
	case GT: ps.print(">"); break;
	case LE: ps.print("<="); break;
	case LT: ps.print("<"); break;
	case EQ: ps.print("=="); break;
	case NE: ps.print("!="); break;
	}
	expr2.print(ps);
	ps.print(")");
    }
	public void check(HashMap<String, Integer> table) {
		expr1.check(table);
		expr2.check(table);
		if(expr1.type() != expr2.type()) {
			Interpreter.fatalError("Violate rule 9: Both operands of a comparison operator < <= > >= == != must be of the same type.", Interpreter.EXIT_STATIC_CHECKING_ERROR);
		} else {
			type = expr1.type();
		}
	}
	public int type() {
		return type;
	}
	public Boolean evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
		Boolean ret = true;
		if(type == 1) {
			Long v1, v2;
			v1 = expr1.valofint(scanner, intval);
			v2 = expr2.valofint(scanner, intval);
			switch(op) {
				case GE:
					ret = v1 >= v2;
					break;
				case GT:
					ret = v1 > v2;
					break;
				case LE:
					ret = v1 <= v2;
					break;
				case LT:
					ret = v1 < v2;
					break;
				case EQ:
					ret = v1 == v2;
					break;
				case NE:
					ret = v1 != v2;
					break;
			}
		} else {
			Double v1, v2;
			v1 = expr1.valoffloat(scanner, floatval);
			v2 = expr2.valoffloat(scanner, floatval);
			switch(op) {
				case GE:
					ret = v1 >= v2;
					break;
				case GT:
					ret = v1 > v2;
					break;
				case LE:
					ret = v1 <= v2;
					break;
				case LT:
					ret = v1 < v2;
					break;
				case EQ:
					ret = v1 == v2;
					break;
				case NE:
					ret = v1 != v2;
					break;
			}
		}
		return ret;
	}
}