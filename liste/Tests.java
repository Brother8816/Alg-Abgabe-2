package liste;

import org.junit.Before;
import org.junit.Test;

import data.Student;

public class Tests {

	
	SinglyLinkedList sll;
	Student s1,s2,s3;
	
	
	@Before
	public void start() {
		
		s1 = new Student("Io", "Kasto", 10, 11);
		s2 = new Student("Son", "Goku", 9001, 11);
		s3 = new Student("Naruto", "Uzumaki", 3, 9);
		
		sll = new SinglyLinkedList();
		
		sll.addAtStart(s1);
		sll.addAtStart(s2);
		sll.addAtStart(s3);
	}
	
	@Test
	public void charTest() {
		char begin = '0';
		char end = 'z';
		
		for(int i = begin; i <= end; i++) {
			
			char c = (char) i;
			System.out.println(c);
		}
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
}
