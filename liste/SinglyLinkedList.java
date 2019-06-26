package liste;

import data.Student;

public class SinglyLinkedList implements InterList {

	private Node top;

	public SinglyLinkedList() {
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
	public void printElement(int index) {
		Node n = top;
		for (int i = 1; i < index; i++) {
			n = n.next;
		}
		System.out.println(n.data);

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
	// index based deletion
	public void delete(int index) {
		Node n = top;
		Node beforeNode;
		Node nextNode;
		for (int i = 1; i < index - 1; i++) {
			n = n.next;
		}
		beforeNode = n;
		n = n.next;
		nextNode = n.next;
		beforeNode.next = nextNode;
		System.out.println(n.data + " wurde geloescht");

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
			sortMatrikelnummer();
			break;
		case STUDIENGANG:
			sortStudiengang();
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

		// instantiate the queues where the data will be sorted
		SinglyLinkedList[] queues = new SinglyLinkedList[keys];
		for (int i = 0; i < queues.length; i++) {
			queues[i] = new SinglyLinkedList();
		}

		// iterating over the length of the given strings
		for (int i = chars - 1; i >= 0; i--) {

			// iterating over the given students
			for (int j = 0; j < students.length; j++) {

				String name = students[j].getData(t).toLowerCase();

				// iterating over the queues to find one that matches the current character of
				// the current name
				for (int k = 0; k < keys; k++) {
					char current = (char) ('a' + k);

					if (current == name.charAt(i)) {
						queues[k].addAtStart(students[j]);
					}
				}
			}

			int studentsArrayIndex = 0;
			for (int a = 0; a < queues.length; a++) {

				SinglyLinkedList queue = queues[a];
				Student[] s = queue.asArray();
				// writing the gained students into the students array
				for (int b = 0; b < s.length; b++) {
					students[studentsArrayIndex] = s[b];
					studentsArrayIndex++;
				}
				queue.deleteList();
			}
			studentsArrayIndex = 0;
		}

		System.out.println("Sortiert nach: " + t);
		for (int i = 0; i < students.length; i++) {
			System.out.println("-->" + students[i]);
		}
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
			zarr = maxHeapMatrikelnummer(zarr);
			zs = zarr[0];
			zarr[0] = zarr[zarr.length - 1];
			zarr[zarr.length - 1] = zs;

			for (int k = 0; k < zarr.length; k++) {
				arr[k] = zarr[k];

			}

		}

		arrayToList(arr);

	}

	private Student[] maxHeapMatrikelnummer(Student[] arr) {
		Student zs;
		int n;
		do {
			n = 0;
			for (int i = 1; i < arr.length / 2 + 1; i++) {
				if (i * 2 < arr.length) {

					if (arr[i * 2 - 1].getMatrikelnummer() > arr[i * 2].getMatrikelnummer()) {
						if (arr[i * 2 - 1].getMatrikelnummer() > arr[i - 1].getMatrikelnummer()) {
							zs = arr[i - 1];
							arr[i - 1] = arr[i * 2 - 1];
							arr[i * 2 - 1] = zs;
							n = n + 1;

						}
					} else {
						if (arr[i * 2].getMatrikelnummer() > arr[i - 1].getMatrikelnummer()) {
							zs = arr[i - 1];
							arr[i - 1] = arr[i * 2];
							arr[i * 2] = zs;
							n = n + 1;
						}
					}
				} else {
					if (arr[i * 2 - 1].getMatrikelnummer() > arr[i - 1].getMatrikelnummer()) {
						zs = arr[i - 1];
						arr[i - 1] = arr[i * 2 - 1];
						arr[i * 2 - 1] = zs;
						n = n + 1;
					}
				}
			}
		} while (n != 0);

		return arr;

	}

	private void arrayToList(Student[] s) {
		top = null;
		for (int i = 0; i < s.length; i++) {
			addAtEnd(s[i]);

		}

	}

	private void sortStudiengang() {
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
			zarr = maxHeapStudiengang(zarr);
			zs = zarr[0];
			zarr[0] = zarr[zarr.length - 1];
			zarr[zarr.length - 1] = zs;

			for (int k = 0; k < zarr.length; k++) {
				arr[k] = zarr[k];

			}

		}

		arrayToList(arr);

	}

	private Student[] maxHeapStudiengang(Student[] arr) {
		Student zs;
		int n;
		do {
			n = 0;
			for (int i = 1; i < arr.length / 2 + 1; i++) {
				if (i * 2 < arr.length) {

					if (arr[i * 2 - 1].getStudiengang() > arr[i * 2].getStudiengang()) {
						if (arr[i * 2 - 1].getStudiengang() > arr[i - 1].getStudiengang()) {
							zs = arr[i - 1];
							arr[i - 1] = arr[i * 2 - 1];
							arr[i * 2 - 1] = zs;
							n = n + 1;

						}
					} else {
						if (arr[i * 2].getStudiengang() > arr[i - 1].getStudiengang()) {
							zs = arr[i - 1];
							arr[i - 1] = arr[i * 2];
							arr[i * 2] = zs;
							n = n + 1;
						}
					}
				} else {
					if (arr[i * 2 - 1].getStudiengang() > arr[i - 1].getStudiengang()) {
						zs = arr[i - 1];
						arr[i - 1] = arr[i * 2 - 1];
						arr[i * 2 - 1] = zs;
						n = n + 1;
					}
				}
			}
		} while (n != 0);

		return arr;

	}

}
