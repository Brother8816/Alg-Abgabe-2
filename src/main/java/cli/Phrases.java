package cli;

import java.util.InputMismatchException;

import data.Student;

public class Phrases {

	private static String insertName(String info) {
		
		String ret = "";
		
		MainMenu.refreshScan();
		
		System.out.println(info + "Erlaubte Eingaben: (a-z) und (A-Z)");
		
		System.out.print(">");
		String scan = MainMenu.scan.next();
		
		String lowerScan = scan.toLowerCase();
		
		for(int i = 0; i < lowerScan.length(); i++) {
			
			char c = lowerScan.charAt(i);
			
			if(c < 'a' || c > 'z') {
				
				System.out.println("Bitte keine Sonderzeichen verwenden!");
				
				ret = insertName(info);
			} else {
				ret = scan;
			}
			
		}
		
		
		
		return ret;
	}
	
	public static boolean binaryOption() {

		System.out.println("(y/n)");
		System.out.print(">");

		MainMenu.refreshScan();
		String choice = MainMenu.scan.next().toLowerCase();

		while (!(choice.equals("y") || choice.equals("n") || choice.equals("yes") || choice.equals("no"))) {
			System.out.println("Bitte mit y (ja) oder n (nein) antworten");
			System.out.print(">");
			choice = MainMenu.scan.next().toLowerCase();
			System.out.println(choice);
		}

		if (choice.equals("y") || choice.equals("yes")) {
			return true;
		} else
			return false;
	}

	public static String framing(String message) {
		String ret = "";
		char fill = '#';

		for (int l = 0; l < 3; l++) {
			if (l != 1) {
				for (int i = 0; i < message.length() + 4; i++) {
					ret += fill;
				}
			} else {
				ret += String.format("%c %s %c", fill, message, fill);
			}
			ret += "\n";
		}

		return ret;
	}

	public static int getIndex(int maxIndex) {
		int index = -1;

		System.out.println("Wähle einen Index von 0 bis " + maxIndex + "!");

		System.out.print(">");

		try {
			index = MainMenu.scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Nur Zahlen sind erlaubt!");
			index = -1;
		} catch (Exception e2) {

		}

		if (index < 0 || index > maxIndex) {
			System.out.println("Bitte nur Zahlen von 0 bis " + maxIndex + " auswählen!");
			index = -1;
		}

		return index;
	}

	public static Student insertStudent() {

		Student student;

		String vorname;
		String nachname;
		int matrikelnummer = -1;
		int studiengang = -1;

		System.out.println("Eingabe der folgenden Werte:");
		vorname = insertName("Vorname: ");
		nachname = insertName("Nachname: ");

		try {
			System.out.println("Matrikelnummer:");
			System.out.print(">");
			matrikelnummer = MainMenu.scan.nextInt();
			System.out.println("Studiengang:");
			System.out.print(">");
			studiengang = MainMenu.scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Nur Zahlen sind erlaubt!");
			return null;
		} catch (Exception e2) {
			return null;
		}

		student = new Student(vorname, nachname, matrikelnummer, studiengang);
		return student;
	}

	public static int insertNumber(MainOptions[] opts) {
		int pick = -1;

		System.out.println("Bitte wähle eine der Varianten durch Eingabe der entsprechenden Zahl:");
		System.out.print(">");

		try {
			pick = MainMenu.scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Nur Zahlen sind erlaubt!");
			pick = -1;
		} catch (Exception e2) {

		}

		if (pick < 0 || pick >= opts.length) {
			System.out.println("Bitte nur Zahlen von 0 bis " + (opts.length - 1) + " auswählen!");
			pick = -1;
		}

		return pick;
	}

	public static int insertNumber(SubOptions[] opts) {
		int pick = -1;

		System.out.println("Bitte wähle eine der Varianten durch Eingabe der entsprechenden Zahl:");
		System.out.print(">");

		try {
			pick = MainMenu.scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Nur Zahlen sind erlaubt!");
		} catch (Exception e2) {

		}

		if (pick < 0 || pick >= opts.length) {
			System.out.println("Bitte nur Zahlen von 0 bis " + (opts.length - 1) + " auswählen!");
			pick = -2;
		}

		return pick;
	}
}
