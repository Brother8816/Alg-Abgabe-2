package liste;

import data.Student;

public interface InterList {

	public Node createElement(Student s);

	public void addAtStart(Student s);

	public void addAtEnd(Student s);

	public void printElement(int index);

	public void printList();

	public int size();

	public void delete(int index);

	public void deleteList();

	public void printSearch(String search, Token t);

	public void sort(Token t);
}