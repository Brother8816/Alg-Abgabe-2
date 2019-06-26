package liste;

import data.Student;

public class NodeDouble extends Node {

	NodeDouble next;
	NodeDouble before;

	public NodeDouble(Student pData) {
		super(pData);
		next = null;
		before = null;

	}

}
