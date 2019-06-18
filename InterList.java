package liste;

import data.Student;

public interface InterList {

	public Node createElement();

	public void addAtStart(Student s);

	public void addAtEnd(Student s);

	public void printElement(Node n);

	public void printList();

	public int size();

	public void delete(Node n);

	public void deleteList();

	public void printSearch(Token t);

	public void sort(Token t);
}