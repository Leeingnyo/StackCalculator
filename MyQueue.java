import java.util.EmptyStackException;


public class MyQueue<T> implements StackQueueInterface<T> {
	Node<T> tail;
	int size;
	MyQueue() {
		tail = null;
		size = 0;
	}
	public void push(T item){
		Node<T> newNode = new Node<T>();
		newNode.setItem(item);
		if (isEmpty()) {
			newNode.setNext(newNode);
		} else {
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
		}
		tail = newNode;
		size++;
	}
	public T pop() {
		if (tail == null) throw new EmptyStackException();
		Node<T> first = tail.getNext();
		if (first == tail) {
			tail = null;
		} else {
			tail.setNext(first.getNext());
		}
		size--;
		return first.getItem();
	}
	public boolean isEmpty() {
		return tail == null;
	}
	int size(){
		return size;
	}
	public void clear() {
		tail = null;
		size = 0;
	}
	public T peek() {
		if (tail == null) throw new EmptyStackException();
		return tail.getNext().getItem();
	}
	public String toString(){
		if (tail == null) throw new EmptyStackException();
		String string = "";
		for (Node<T> i = tail.getNext(); i != tail; i = i.getNext()){
			string += i.getItem().toString() + " ";
		}
		string += tail.getItem().toString();
		return string;
	}
}
