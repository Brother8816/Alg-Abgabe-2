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
			break;
		case NACHNAME:
			break;
		case MATRIKELNUMMER:
			sortMatrikelnummer();
			break;
		case STUDIENGANG:
			break;
		default:
			break;
		}
	}

	private void sortVorname() {
		// Radix Sort
		int elements = size();

		Student[][] sorts = new Student[26][elements];
	}

	private void sortNachname() {
		// Radix Sort
		int elements = size();

		Student[][] sorts = new Student[26][elements];
	}

	private void sortMatrikelnummer() {

		Student[] arr = new Student[size()];
		Node n = top;
		Student zs;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = n.data;
			n = n.next;
		}

		for (int i = 0; i < arr.length; i++) {
			Student[] zarr = new Student[arr.length - i];
			for (int k = 0; k < zarr.length; k++) {
				zarr[k] = arr[k];
			}
			zarr = maxHeap(zarr);
			zs = zarr[0];
			zarr[0] = zarr[zarr.length - 1];
			zarr[zarr.length - 1] = zs;

			for (int k = 0; k < zarr.length; k++) {
				arr[k] = zarr[k];

			}

		}

		arrayToList(arr);
		/*
		 * for (int i = 0; i < arr.length; i++) {
		 * System.out.println("zwischenergebniss"); System.out.println(arr[i]); }
		 */

	}

	private void arrayToList(Student[] s) {
		top = null;
		for (int i = 0; i < s.length; i++) {
			addAtEnd(s[i]);

		}

	}

	private Student[] maxHeap(Student[] arr) {
		Student zs;
		for (int i = 1; i < arr.length / 2; i++) {
			if (i * 2 < arr.length) {

				if (arr[i * 2 - 1].getMatrikelnummer() > arr[i * 2].getMatrikelnummer()) {
					if (arr[i * 2 - 1].getMatrikelnummer() > arr[i - 1].getMatrikelnummer()) {
						zs = arr[i - 1];
						arr[i - 1] = arr[i * 2 - 1];
						arr[i * 2 - 1] = zs;
					}
				} else {
					if (arr[i * 2].getMatrikelnummer() > arr[i - 1].getMatrikelnummer()) {
						zs = arr[i - 1];
						arr[i - 1] = arr[i * 2];
						arr[i * 2] = zs;
					}
				}
			} else {
				if (arr[i * 2 - 1].getMatrikelnummer() > arr[i - 1].getMatrikelnummer()) {
					zs = arr[i - 1];
					arr[i - 1] = arr[i * 2 - 1];
					arr[i * 2 - 1] = zs;
				}
			}
		}

		return arr;

	}

	private void sortStudiengang() {

	}

}
