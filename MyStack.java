import java.util.EmptyStackException;


/**
 *<code> MyStack</code> is reference based stack.
 * */
public class MyStack<T> implements StackQueueInterface<T> {
	Node<T> top;
	int size;
	MyStack(){
		top = null;
	}
	public boolean isEmpty(){
		return top == null;
	}
	public void push(T item){
		Node<T> newNode = new Node<T>(item, top);
		top = newNode;
		size++;
	}
	public T pop(){
		if (top == null) throw new EmptyStackException();
		Node<T> temp = top;
		top = top.getNext();
		--size;
		return temp.getItem();
	}
	public void clear(){
		if (top == null) throw new EmptyStackException();
		top = null;
	}
	public T peek(){
		return top.getItem();
	}
	public int size(){
		return size;
	}
	public String toString(){
		if (top == null) throw new EmptyStackException();
		return makeString(top);
	}
	public String makeString(Node<T> node){
		if (node.getNext() != null)
			return makeString(node.getNext()) + " " + node.getItem().toString();
		else
			return node.getItem().toString();
	}
}
