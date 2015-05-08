
/**
 * <p>
 * 	Thrown when the expression is empty or has only whitespace and empty parenthesis and
 * 	when stack is not empty nonetheless the calculating is over. 
 * </p>
 * <blockquote>Example) "", " ", "\t", "()1", "( )"</blockquote>
 * */
public class WrongExpressionException extends Exception {

	private static final long serialVersionUID = 1L;

}
