
/**
 * <code>Node&ltT&gt</code> has the item and next, which is based of <code>MyStack</code>
 * */
class Node<T> {
	private T item;
	private Node<T> next;
	Node(){
		this.item = null;
		this.next = null;
	}
	Node(T item){
		this.item = item;
		next = null;
	}
	Node(T item, Node<T> next){
		this.item = item;
		this.next = next;
	}
	void setItem(T item){
		this.item = item;
	}
	T getItem(){
		return this.item;
	}
	void setNext(Node<T> next){
		this.next = next;
	}
	Node<T> getNext(){
		return this.next;
	}
}