package liste;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import data.Student;

public class Tests {

	SinglyLinkedList sll;
	DoublyLinkedList dll;
	Student s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;

	@Before
	public void start() {

		s1 = new Student("Io", "Kasto", 10, 11);
		s2 = new Student("Son", "Goku", 9001, 11);
		s3 = new Student("Naruto", "Uzumaki", -3, 9);
		s4 = new Student("Boruto", "Uzumaki", -25, 25);
		s5 = new Student("Robert", "Kleinschmidt", 568268, 221);
		s6 = new Student("Jane", "Do", 0, 0);
		s7 = new Student("Chuck", "Noris", -88, 88);
		s8 = new Student("Harry", "Potter", 155465, 457);
		s9 = new Student("Ron", "Weasly", 21548, 457);
		s10 = new Student("Hermine", "Granger", 125545, 489);

		sll = new SinglyLinkedList();

		sll.addAtStart(s1);
		sll.addAtStart(s2);
		sll.addAtStart(s3);
		sll.addAtStart(s4);
		sll.addAtStart(s5);
		sll.addAtStart(s6);
		sll.addAtStart(s7);
		sll.addAtStart(s8);
		sll.addAtStart(s9);
		sll.addAtStart(s10);

		dll = new DoublyLinkedList();
		dll.addAtStart(s1);
		dll.addAtStart(s2);
		dll.addAtStart(s3);
		dll.addAtStart(s4);
		dll.addAtStart(s5);
		dll.addAtStart(s6);
		dll.addAtStart(s7);
		dll.addAtStart(s8);
		dll.addAtStart(s9);
		dll.addAtStart(s10);

	}

	@Ignore
	public void charTest() {
		char begin = 'a';
		char end = 'z';

		for (int i = begin; i <= end; i++) {

			char c = (char) i;
			System.out.println(i - begin + " " + i + " " + c);
		}
	}

	@Ignore
	public void sortVorname() {
		sll.sort(Token.VORNAME);
	}

	@Ignore
	public void sortNachname() {
		sll.sort(Token.NACHNAME);
	}

	@Test
	public void ausgabe() {
		sll.printList();
	}

	@Test
	public void suchTest() {

		String search = "Goku";

		sll.printSearch(search, Token.NACHNAME);

	}

	@Test
	public void suchTestB() {
		String search = "11";

		sll.printSearch(search, Token.STUDIENGANG);
	}

	@Test
	public void heapSortMatrikelnummer() {
		sll.sort(Token.MATRIKELNUMMER);
		System.out.println("Liste sortiert nach Matrikelnummer");
		sll.printList();
		System.out.println("Ende");
	}

	@Test
	public void heapSortStudiengang() {
		sll.sort(Token.STUDIENGANG);
		System.out.println("Liste sortiert nach Studiengang");
		sll.printList();
		System.out.println("Ende");
	}

	@Test
	public void printElem() {
		System.out.println("Ausgabe des Index 3");
		sll.printElement(3);
	}

	@Test
	public void delElem() {
		sll.delete(3);
		System.out.println("Inhalt der Liste nach löschen des Index 3");
		sll.printList();
		System.out.println("Ende");
	}

	@Test
	public void ausgabeDouble() {
		dll.printList();

	}

	@Test
	public void suchTestDouble() {

		String search = "Goku";

		dll.printSearch(search, Token.NACHNAME);

	}

	@Test
	public void suchTestBDouble() {
		String search = "11";

		dll.printSearch(search, Token.STUDIENGANG);
	}

	@Test
	public void heapSortMatrikelnummerDouble() {
		dll.sort(Token.MATRIKELNUMMER);
		System.out.println("Liste sortiert nach Matrikelnummer");
		dll.printList();
		System.out.println("Ende");
	}

	@Test
	public void heapSortStudiengangDouble() {
		dll.sort(Token.STUDIENGANG);
		System.out.println("Liste sortiert nach Studiengang");
		dll.printList();
		System.out.println("Ende");
	}

	@Test
	public void printElemDouble() {
		System.out.println("Ausgabe des Index 3 der Doppelten-Liste");
		dll.printElement(3);
	}

	@Test
	public void delElemDouble() {
		dll.delete(3);
		System.out.println("Inhalt der Liste nach löschen des Index 3");
		dll.printList();
		System.out.println("Ende");
	}

}
