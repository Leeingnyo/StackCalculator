import java.util.EmptyStackException;

public class StackCalculator {
	/**
	 * Calculate the postfix popping out tokens with recursion.
	 * */
	public static Long calculate(MyQueue<Token> postfix) throws WrongExpressionException {
		if (postfix.isEmpty()) throw new EmptyStackException();
		MyStack<Long> result = new MyStack<Long>();
		while (!postfix.isEmpty()){
			Token token = postfix.pop();
			if (token.isNumber()){
				result.push(token.getNumber());
			} else if (token.isOperator()) {
				Long a, b;
				switch (token.getOperator()){
				case '+': 
					a = result.pop();
					b = result.pop();
					result.push(b + a);
					break;
				case '-':
					a = result.pop();
					b = result.pop();
					result.push(b - a);
					break;
				case '*':
					a = result.pop();
					b = result.pop();
					result.push(b * a);
					break;
				case '/':
					a = result.pop();
					b = result.pop();
					//the case x/0
					if (a == 0L) throw new ArithmeticException();
					result.push(b / a);
					break;
				case '%':
					a = result.pop();
					b = result.pop();
					//the case x%0
					if (a == 0L) throw new ArithmeticException();
					result.push(b % a);
					break;
				case '~':
					a = result.pop();
					result.push(-a);
					break;
				case '^':
					a = result.pop();
					b = result.pop();
					//the case 0^x (x < 0) 
					if (b == 0L && a < 0L) throw new ArithmeticException();
					result.push((long)(Math.pow(b, a)));
					break;
				default:
					//undefined operator
					throw new WrongExpressionException();
				}				
			} else {
				throw new WrongExpressionException(); 
			}
		}
		if (result.size() == 1){
			//the result stack must have one element.
			return result.pop();
		}
		else throw new WrongExpressionException();
	}
}
