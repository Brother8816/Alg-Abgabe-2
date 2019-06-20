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
		}

		return a;
	}

	@Override
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

		String result = "Ergebnis der Suche nach: "+search+" im Feld "+ t+"\n";
		
		if (n != null) {

			while (n != null) {
				
				String data = n.data.getData(t);
				
				if(data.equals(search)) {
					result += n.data.toString()+"\n";
				}
				
				n = n.next;
			}
		}
		
		System.out.println(result);
	}

	@Override
	public void sort(Token t) {
		switch(t) {
		
		case VORNAME:
			break;
		case NACHNAME:
			break;
		case MATRIKELNUMMER:
			break;
		case STUDIENGANG:
			break;
		default:
			break;
		}
	}
	
	private void sortVorname() {
		//Radix Sort
		int elements = size();
		
		Student[][] sorts = new Student[26][elements];
	}
	
	private void sortNachname() {
		//Radix Sort
		int elements = size();
		
		Student[][] sorts = new Student[26][elements];
	}
	
	private void sortMatrikelnummer() {
		
	}
	
	private void sortStudiengang() {
		
	}

}
