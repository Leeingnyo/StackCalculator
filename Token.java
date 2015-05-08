
/**
 * <p><code>Token</code> has a value of only operator or only number.
 * It compose the postfix expression.</p>
 * <b>Example</b>
 * <p>11+2 => [token(11), token(+), token(2)]</p>
 * */
public class Token {
	private Character operator;
	private Long number;
	/**
	 * It initialize the character.
	 * */
	Token(Character operator){
		this.operator = operator;
		this.number = null;
	}
	/**
	 * It initialize the number. 
	 * */
	Token(Long number){
		this.operator = null;
		this.number = number;
	}
	/**
	 * Return if the character exists and is operator. 
	 * */
	public boolean isOperator(){
		return operator != null && Operator.isOperator(operator);
	}
	/**
	 * Return if the number exists.
	 * */
	public boolean isNumber(){
		return number != null;
	}
	/**
	 * Return the number.
	 * */
	public Character getOperator(){
		return operator;
	}
	/**
	 * Return the number.
	 * */
	public Long getNumber(){
		return number;
	}
	public String toString(){
		return isOperator() ? operator.toString()
			: isNumber() ? number.toString() : "";
	}
}
