package liste;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import data.Student;

public class Tests {

	SinglyLinkedList sll;
	Student s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;

	@Before
	public void start() {

		s1 = new Student("Io", "Kasto", 1, 11);
		s2 = new Student("Son", "Goku", 9, 11);
		s3 = new Student("Naruto", "Uzumaki", 3, 9);
		s4 = new Student("Boruto", "Uzumaki", 6, 25);
		s5 = new Student("Robert", "Kleinschmidt", 4, 221);
		s6 = new Student("Jane", "Do", 0, 0);
		s7 = new Student("Chuck", "Noris", 8, 88);
		s8 = new Student("Harry", "Potter", 5, 457);
		s9 = new Student("Ron", "Weasly", 2, 457);
		s10 = new Student("Hermine", "Granger", 7, 489);

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
	}

	@Ignore
	public void charTest() {
		char begin = '0';
		char end = 'z';

		for (int i = begin; i <= end; i++) {

			char c = (char) i;
			System.out.println(c);
		}
	}

	@Ignore
	public void ausgabe() {
		sll.printList();
	}

	@Ignore
	public void suchTest() {

		String search = "Goku";

		sll.printSearch(search, Token.NACHNAME);

	}

	@Ignore
	public void suchTestB() {
		String search = "11";

		sll.printSearch(search, Token.STUDIENGANG);
	}

	@Test
	public void heapSortMatrikelnummer() {
		sll.sort(Token.MATRIKELNUMMER);
		System.out.println("Liste sortiert nach Matrikelnummer");
		sll.printList();
	}
}
