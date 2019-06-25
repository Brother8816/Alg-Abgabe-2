package liste;

import data.Student;

public class SinglyLinkedList implements InterList {

	private Node top;

	public SinglyLinkedList() {
	}

	@Override
	public Node createElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAtStart(Student s) {

		Node n = new Node(s);

		n.next = top;
		top = n;
	}

	@Override
	public void addAtEnd(Student s) {

		Node n = top;

		if (n != null) {

			while (n.next != null) {
				n = n.next;
			}

			Node node = new Node(s);
			n.next = node;
		} else {

			addAtStart(s);
		}
	}

	@Override
	public void printElement(Node n) {
		// TODO Auto-generated method stub
	}

	@Override
	public void printList() {

		Node n = top;

		System.out.println("Inhalt der Liste:");

		while (n != null) {
			System.out.println(n.data);

			n = n.next;
		}

	}

	@Override
	public int size() {

		Node n = top;
		int a = 0;

		while (n != null) {
			a++;
			n = n.next;
		}

		return a;
	}

	@Override
	//index based deletion
	public void delete(Node n) {

		if (top != null)
			top = top.next;
	}

	@Override
	public void deleteList() {

		top = null;
	}

	@Override
	public void printSearch(String search, Token t) {
		Node n = top;

		String result = "Ergebnis der Suche nach: " + search + " im Feld " + t + "\n";

		if (n != null) {

			while (n != null) {

				String data = n.data.getData(t);

				if (data.equals(search)) {
					result += n.data.toString() + "\n";
				}

				n = n.next;
			}
		}

		System.out.println(result);
	}

	@Override
	public void sort(Token t) {
		switch (t) {

		case VORNAME:
			sortName(t);
			break;
		case NACHNAME:
			sortName(t);
			break;
		case MATRIKELNUMMER:
			break;
		case STUDIENGANG:
			break;
		default:
			break;
		}
	}

	private Student[] asArray() {

		Student[] ret = new Student[size()];
		Node n = top;
		int index = 0;

		while (n != null) {
			ret[index] = n.data;
			n = n.next;
			index++;
		}

		return ret;
	}

	private void sortName(Token t) {
		
		final int chars = size();
		final int keys = 26;
		
		Student[] students = this.asArray();
		
		//instantiate the queues where the data will be sorted
		SinglyLinkedList[] queues = new SinglyLinkedList[keys];
		for(int i = 0; i < queues.length; i++) {
			queues[i] = new SinglyLinkedList();
		}
		
		//iterating over the length of the given strings
		for(int i = chars-1; i >= 0; i--) {
			
			//iterating over the given students
			for(int j = 0; j < students.length; j++) {
				
				String name = students[j].getData(t).toLowerCase();
				
				//iterating over the queues to find one that matches the current character of the current name
				for(int k = 0; k < keys; k++) {
					char current = (char) ('a'+ k);
					
					if(current == name.charAt(i)) {
						queues[k].addAtStart(students[j]);
					}
				}
			}
			
			int studentsArrayIndex = 0;
			for(int a = 0; a < queues.length; a++) {
				
				SinglyLinkedList queue = queues[a];
				Student[] s = queue.asArray();
				//writing the gained students into the students array
				for(int b = 0; b < s.length; b++) {
					students[studentsArrayIndex] = s[b];
					studentsArrayIndex++;
				}
				queue.deleteList();
			}
			studentsArrayIndex = 0;
		}
		
		System.out.println("Sortiert nach: "+t);
		for(int i = 0; i < students.length; i++) {
			System.out.println("-->"+students[i]);
		}
	}

	private void sortMatrikelnummer() {

	}

	private void sortStudiengang() {

	}

}
