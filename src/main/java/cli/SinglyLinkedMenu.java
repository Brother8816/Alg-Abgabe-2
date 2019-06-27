package cli;

import data.Student;
import liste.SinglyLinkedList;
import liste.Token;

public class SinglyLinkedMenu implements SubMenu {

	Student student;

	SubOptions[] opts;
	SinglyLinkedList sll;

	public SinglyLinkedMenu() {
		opts = SubOptions.values();
		sll = new SinglyLinkedList();
	}

	@Override
	public void start() {
		MainMenu.refreshScan();
		int pick = -1;
		System.out.println(Phrases.framing("SinglyLinkedList Menü"));

		System.out.println("MOMENTAN ZWISCHENGESPEICHERTER STUDENT:");
		if (student != null)
			System.out.println(student.toString());
		else
			System.out.println("KEINER");

		System.out.println();

		for (int i = 0; i < opts.length; i++) {
			System.out.printf("%-3d: %s%n", i, opts[i]);
		}

		pick = Phrases.insertNumber(opts);

		if (pick >= 0) {
			switch (pick) {
			case 0:
				createElement();
				break;
			case 1:
				addAtStart();
				break;
			case 2:
				addAtEnd();
				break;
			case 3:
				printElement();
				break;
			case 4:
				printList();
				break;
			case 5:
				size();
				break;
			case 6:
				delete();
				break;
			case 7:
				deleteList();
				break;
			case 8:
				printSearch();
				break;
			case 9:
				sort();
				break;
			case 10:
				back();
				break;
			default:
				break;
			}
		}

		this.start();
	}

	@Override
	public void createElement() {
		student = Phrases.insertStudent();
	}

	@Override
	public void addAtStart() {
		if (student != null)
			sll.addAtStart(student);
		else
			System.out.println("!!!Bitte zuerst Studenten anlegen!!!");

		student = null;
	}

	@Override
	public void addAtEnd() {
		if (student != null)
			sll.addAtEnd(student);
		else
			System.out.println("!!!Bitte zuerst Studenten anlegen!!!");

		student = null;
	}

	@Override
	public void printElement() {

		if (sll.size() > 0) {
			int index = Phrases.getIndex(sll.size() - 1);
			if (index >= 0) {
				System.out.println("Das Element am Index " + index + ":");
				sll.printElement(index);
				System.out.println();
			} else {
				this.start();
			}
		} else {
			System.out.println("Die Liste ist leer!");
			this.start();
		}
	}

	@Override
	public void printList() {

		if (sll.size() > 0) {
			System.out.println();
			sll.printList();
			System.out.println();
		} else
			System.out.println("Die Liste ist leer!");
	}

	@Override
	public void size() {
		System.out.println("Die Größe der Liste:");
		System.out.println(sll.size());
		System.out.println();
	}

	@Override
	public void delete() {
		System.out.println("Lösche einen Index");
		int index = Phrases.getIndex(sll.size() - 1);

		sll.delete(index);
	}

	@Override
	public void deleteList() {

		System.out.println("LISTE WIRKLICH LÖSCHEN?");

		if (Phrases.binaryOption()) {
			System.out.println("Liste wird gelöscht!");
			sll.deleteList();
		} else {
			System.out.println("Abbruch...");
		}
		System.out.println();
	}

	@Override
	public void printSearch() {

		if (sll.size() > 0) {
			System.out.println("Suche nach einem speziellen Studenten");

			System.out.println("Suchen nach?");

			Token[] tokens = Token.values();
			for (int i = 0; i < tokens.length; i++) {
				System.out.printf("%-3d: %s%n", i, tokens[i]);
			}

			int pick = Phrases.getIndex(tokens.length - 1);

			Token t = null;

			if (pick >= 0) {
				switch (pick) {
				case 0:
					t = Token.VORNAME;
					break;
				case 1:
					t = Token.NACHNAME;
					break;
				case 2:
					t = Token.MATRIKELNUMMER;
					break;
				case 3:
					t = Token.STUDIENGANG;
					break;
				default:
					break;
				}

				System.out.println("Nach welchem Wort oder Zahl suchen?");
				System.out.print(">");
				MainMenu.refreshScan();
				String search = MainMenu.scan.next();

				sll.printSearch(search, t);

			}
		} else {
			System.out.println("Die Liste ist leer! Bitte zuerst Studenten anlegen!");
		}
	}

	@Override
	public void sort() {

		System.out.println("Sortieren wonach?");

		System.out.println("Namenssuche: RADIX SORT");
		System.out.println("Zahlensuche: HEAP SORT");
		
		Token[] tokens = Token.values();
		for (int i = 0; i < tokens.length; i++) {
			System.out.printf("%-3d: %s%n", i, tokens[i]);
		}

		int pick = Phrases.getIndex(tokens.length - 1);

		Token t = null;

		if (pick >= 0) {
			switch (pick) {
			case 0:
				t = Token.VORNAME;
				break;
			case 1:
				t = Token.NACHNAME;
				break;
			case 2:
				t = Token.MATRIKELNUMMER;
				break;
			case 3:
				t = Token.STUDIENGANG;
				break;
			default:
				break;
			}
			
			sll.sort(t);
		}
	}

	@Override
	public void back() {
		System.out.println("Beende...");
		System.exit(0);
	}

}
