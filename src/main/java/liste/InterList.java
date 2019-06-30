package liste;

import data.Student;

/**
 * 
 * @author Robert Kleinschmidt s0568268, Richard Hunstock s0569407
 * @version 1.0
 *
 */

public interface InterList {

	/**
	 * fügt einen Knoten zum Anfang der Liste Hinzu.
	 * 
	 * @param s Objekt Student wird als Daten dem Knoten übergeben.
	 */
	public void addAtStart(Student s);

	/**
	 * fügt einen Knoten zum Ende der Liste Hinzu.
	 * 
	 * @param s Objekt Student wird als Daten dem Knoten übergeben.
	 */
	public void addAtEnd(Student s);

	/**
	 * soll das Element am Index auf der Konsole ausgeben.
	 * 
	 * @param index zur Ermittlung des richtigen Knoten.
	 */
	public void printElement(int index);

	/**
	 * soll die ganze Liste auf der Konsole ausgeben.
	 * 
	 */
	public void printList();

	/**
	 * ermittelt die Groeße der Liste und gibt diese zurueck.
	 * 
	 * @return gibt einen int-Wert mit der Groeße zurueck.
	 */
	public int size();

	/**
	 * soll das Elemenet am Index loeschen.
	 * 
	 * @param index zur Ermittlung des richtigen Knoten.
	 */
	public void delete(int index);

	/**
	 * soll die ganze Liste loeschen.
	 * 
	 */
	public void deleteList();

	/**
	 * soll die Elemente mit dem gesuchten String finden und auf der Konsole
	 * ausgeben.
	 * 
	 * @param search uebergibt die gesuchten zeichen.
	 * @param t      uebergibt, in welchem Feld gesucht werden soll.
	 */
	public void printSearch(String search, Token t);

	/**
	 * soll die Liste nach dem gewuenschten Feld sortieren.
	 * 
	 * @param t nach welchem Feld sortiert werden soll.
	 */
	public void sort(Token t);
}