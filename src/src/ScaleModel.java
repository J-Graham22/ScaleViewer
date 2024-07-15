package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class ScaleModel {
	
	private CircularLinkedList scale;
	private Node root;
	
	public ScaleModel() {
		scale = new CircularLinkedList();
		
		scale.add("A");
		scale.add("A#/Bb");
		scale.add("B");
		scale.add("C");
		scale.add("C#/Db");
		scale.add("D");
		scale.add("D#/Eb");
		scale.add("E");
		scale.add("F");
		scale.add("F#/Gb");
		scale.add("G");
		scale.add("G#/Ab");
		
		root = scale.getHead();
	}
	
	public CircularLinkedList getScale() {
		return this.scale;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node halfStep(Node start) {
		return start.next;
	}
	
	public Node wholeStep(Node start) {
		return start.next.next;
	}
	
	public Node wholeHalfStep(Node start) {
		return start.next.next.next;
	}
	
	public ArrayList<String> parsePattern(String rootNote, String scalePattern) {
		ArrayList<String> pattern = new ArrayList<String>();
		
		while(!this.getRoot().text.equals(rootNote)) {
			this.setRoot(this.getRoot().next);
		}
		
		Node hold = this.getRoot();
		pattern.add(hold.text);
		
		for(int i=0; i < scalePattern.length(); i++) {
			if(scalePattern.charAt(i) == 'H') {
				hold = halfStep(hold);
				pattern.add(hold.text);
			}
			
			if(scalePattern.charAt(i) == 'W') {
				hold = wholeStep(hold);
				pattern.add(hold.text);
			}
			
			if(scalePattern.charAt(i) == 'T') {
				hold = wholeHalfStep(hold);
				pattern.add(hold.text);
			}
		}
		
		return pattern;
	}
}
