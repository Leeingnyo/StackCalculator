import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;

public class CalculatorTest {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true){
			try {
				String input = br.readLine();
				if (input.compareTo("q") == 0)
					break;
				
				try {
					command(input);
				} catch (ArithmeticException e){
					//I catch the Exception and print out "ERROR"
					/*
					 * When the expression cannot be calculated.
					 * Example) x/0, x%0, 0^x (x < 0)
					 * */
					System.out.println("ERROR");
				} catch (DetachedNumberException e){
					/*
					 * When the expression has detached numbers
					 * Example) "1 1+1", "(12+2 2)*44"
					 * */
					System.out.println("ERROR");
				} catch (EmptyStackException e){
					/*
					 * When the attempt that popping on the empty stack has occurred.
					 * */
					System.out.println("ERROR");
				} catch (WrongExpressionException e){
					/*
					 * When the expression is empty or has only whitespace and has empty parenthesis.
					 * When stack is not empty nonetheless a calculation is over.
					 * Example) "", " ", "	", "()1"
					 * */
					System.out.println("ERROR");
				} catch (NumberFormatException e){
					/*
					 * When the input number exceeds range of Long.
					 * */
					System.out.println("ERROR");
				}
			} catch (Exception e){
				System.err.println("입력이 잘못되었습니다. 오류 : " + e.toString());
				e.printStackTrace();
			}
		}
	}

	private static void command(String input) throws WrongExpressionException, DetachedNumberException{
		MyQueue<Token> postfix = Postfix.makePostfix(input);
		String postfixExpression = postfix.toString();
		Long result = StackCalculator.calculate(postfix);
		System.out.println(postfixExpression);
		System.out.println(result);
	}
}