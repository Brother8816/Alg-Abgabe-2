package cli;

import java.util.InputMismatchException;

import data.Student;

public class Phrases {
	
	public static int getIndex(int maxIndex) {
		int index = -1;
		
		System.out.println("Wähle einen Index von 0 bis "+maxIndex+"!");
		
		System.out.print(">");
		
		try {
			index = MainMenu.scan.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Nur Zahlen sind erlaubt!");
			index = -1;
		} catch(Exception e2) {
			
		}
		
		if(index < 0 || index > maxIndex) {
			System.out.println("Bitte nur Zahlen von 0 bis "+maxIndex+" auswählen!");
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
		System.out.println("Vorname:");
		vorname = MainMenu.scan.next();
		System.out.println("Nachname:");
		nachname = MainMenu.scan.next();
		
		try {
			System.out.println("Matrikelnummer:");
			matrikelnummer = MainMenu.scan.nextInt();
			System.out.println("Studiengang:");
			studiengang = MainMenu.scan.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Nur Zahlen sind erlaubt!");
			return null;
		} catch(Exception e2) {
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
		} catch(InputMismatchException e) {
			System.out.println("Nur Zahlen sind erlaubt!");
			pick = -1;
		} catch(Exception e2) {
			
		}
		
		if(pick < 0 || pick >= opts.length) {
			System.out.println("Bitte nur Zahlen von 0 bis "+(opts.length-1)+" auswählen!");
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
		} catch(InputMismatchException e) {
			System.out.println("Nur Zahlen sind erlaubt!");
		} catch(Exception e2) {
			
		}
		
		if(pick < 0 || pick >= opts.length) {
			System.out.println("Bitte nur Zahlen von 0 bis "+(opts.length-1)+" auswählen!");
			pick = -2;
		}
		
		return pick;
	}
}
