
/**
 * <code>StackInterface</code> has methods that should be contained in a stack.
 * */
public interface StackInterface<T> {
	public boolean isEmpty();
	public void push(T item);
	public Node<T> pop();
	public void clear();
	public Node<T> peek();
}
