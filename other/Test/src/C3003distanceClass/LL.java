package C3003distanceClass;

public class LL {
	private Node head;
	private int count = 0;
	public LL() {
		head = null;
		count = 0;
	}
	public void add(int data) {
		Node temp = new Node(data);
		if(head ==null) {
			head = temp;
			count++;
		}else {
			Node current = head;
			while(current.getNext()!= null) {
				current = current.getNext();
			}
			current.setNext(temp);
			count++;
		}
	}
	public String toString() {
		String out = "Count is " + count + "\n";
		Node c = head;
		while(c != null) {
			out += c.getValue() + "\n";
			c =c.getNext();
		}
		return out;
	}
}
class Node{
	private int value;
	private Node next;
	public Node(int data) {
		value = data;
		next = null;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node n) {
		next = n;
	}
	public int getValue() {
		return value;
	}
}