package bff;

import java.util.ArrayList;

public class Node {
	
	private int id;
	private ArrayList<Node> childs;

	
	public Node(int id){
		setChilds(new ArrayList<Node>());
		this.id = id;	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Node> getChilds() {
		return childs;
	}

	public void setChilds(ArrayList<Node> childs) {
		this.childs = childs;
	}
	
	
	
}
