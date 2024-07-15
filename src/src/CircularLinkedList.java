package src;

public class CircularLinkedList {
	private Node head;
	private Node tail;
	
	public void add(String text) {
		Node node = new Node(text);
		
		if(head==null) {
			head = node;
		} else {
			tail.next = node;
		}
		
		tail = node;
		tail.next = head;
	}
	
	public Node getHead() {
		return head;
	}
}
