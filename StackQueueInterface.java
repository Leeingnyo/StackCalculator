
/**
 * <code>StackInterface</code> has methods that should be contained in a stack.
 * */
public interface StackQueueInterface<T> {
	public boolean isEmpty();
	public void push(T item);
	public T pop();
	public void clear();
	public T peek();
}
