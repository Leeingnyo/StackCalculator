import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Postfix {
	/**
	 * Make the postfix with String input
	 * */
	static public MyQueue<Token> makePostfix(String input) throws WrongExpressionException, DetachedNumberException {
		//the case "", "  ", "	"
		if (Pattern.matches("^\\s*$", input)) throw new WrongExpressionException();
		//the case "()", "()1", "(	)"
		if (Pattern.matches("(.*\\([^\\d+]*\\).*|\\(\\))", input)) throw new WrongExpressionException();
		//the case "1 1", "1+2 4*5"
		if (Pattern.matches(".*\\d+\\s+\\d+.*", input)) throw new DetachedNumberException();
		//erase whitespace
		String processedInput = input.replaceAll("\\s+", "");
		MyQueue<Token> postfix = new MyQueue<Token>();
		MyStack<Character> operators = new MyStack<Character>();
		int numberOfParenthesis = 0;
		
		Token prev = null;
		while (!processedInput.equals("")){
			if (Operator.isOperator(processedInput.charAt(0))){
				Character operator = processedInput.charAt(0);
				if (operator == '-'
						&& ((prev != null && prev.isOperator() ? prev.getOperator() != ')' : false) 
								|| prev == null)
					){
					//when "^-E" of "[(+-*/%~^]-E", the '-' is unary.
					operator = '~';
				}
				if (operator == '('){
					operators.push(operator);
					numberOfParenthesis++;
				} else if (operator == ')'){
					--numberOfParenthesis;
					while (!operators.isEmpty() && (operator = operators.pop()) != '('){
						postfix.push(new Token(operator));
					}
					prev = new Token(')');
				} else {
					while (!operators.isEmpty()
							&& (Operator.priority(operator, false) <= Operator.priority(operators.peek(), true))){
						postfix.push(new Token(operators.pop()));
					}
					operators.push(operator);
					prev = new Token(operator);
				}
				processedInput = processedInput.substring(1);
			} else{
				Pattern pattern = Pattern.compile("^(\\d+)");
				Matcher matcher = pattern.matcher(processedInput);
				if (matcher.find()){
					postfix.push(prev = new Token(Long.parseLong(matcher.group(1))));
				} else {
					//if some token is not a operator or a number
					throw new WrongExpressionException();
				}
				processedInput = processedInput.replaceAll("^\\d+", "");
			}
		}
		while (!operators.isEmpty()){
			postfix.push(new Token(operators.pop()));
		}
		//when parenthesis is still open or overly close.
		if (numberOfParenthesis != 0) throw new WrongExpressionException();
		return postfix;
	}
}
