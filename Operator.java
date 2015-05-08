
/**
 * This class is for methods about the operator.
 * */
public class Operator {
	/**
	 * <b>Parameter</b>
	 * <p><code>Character</code> op - the variable for verification</p>
	 * <b>Return</b>
	 * <p>if op is operator</p>
	 * */
	public static boolean isOperator(Character op){
		return "+-*/%~^()".indexOf(op) >= 0;
	}
	/**
	 * <p>Return the priority of the operator with if the operator is in a stack</p>
	 * */
	public static int priority(Character op, boolean isInStack){
		return op == '^' && !isInStack ? 6 :
					op == '^' && isInStack ? 5 :
					op == '~' && !isInStack ? 4 :
					op == '~' && isInStack ? 2 :
					op == '*' || op == '/' || op == '%'? 2 :
					op == '+' || op == '-'? 1 : 0;
	}
}
