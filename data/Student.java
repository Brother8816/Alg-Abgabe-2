package data;

import liste.Token;

public class Student {

	String vorname;
	String nachname;
	int matrikelnummer;
	int studiengang;
	
	public Student(String vorname, String nachname, int matrikelnummer, int studiengang) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
		this.studiengang = studiengang;
	}

	public String getData(Token t) {
		
		switch(t) {
		case VORNAME:
			return vorname;
		case NACHNAME:
			return nachname;
		case MATRIKELNUMMER:
			return new Integer(matrikelnummer).toString();
		case STUDIENGANG:
			return new Integer(studiengang).toString();
		default:
			return null;
		}
		
		
	}
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	public int getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(int studiengang) {
		this.studiengang = studiengang;
	}

	@Override
	public String toString() {
		return "Student [vorname=" + vorname + ", nachname=" + nachname + ", matrikelnummer=" + matrikelnummer
				+ ", studiengang=" + studiengang + "]";
	}
	
	

}
