package data;

import liste.ConstantString;
import liste.Token;

public class Student {
	
	ConstantString vorname;
	ConstantString nachname;
	int matrikelnummer;
	int studiengang;
	
	//TODO catch special chars
	public Student(String vorname, String nachname, int matrikelnummer, int studiengang) {
		super();
		this.vorname = new ConstantString(vorname);
		this.nachname = new ConstantString(nachname);
		this.matrikelnummer = matrikelnummer;
		this.studiengang = studiengang;
	}

	public String getData(Token t) {
		
		switch(t) {
		case VORNAME:
			return vorname.getString();
		case NACHNAME:
			return nachname.getString();
		case MATRIKELNUMMER:
			return new Integer(matrikelnummer).toString();
		case STUDIENGANG:
			return new Integer(studiengang).toString();
		default:
			return null;
		}
		
		
	}
	
	public String getVorname() {
		return vorname.getRealString();
	}

	public String getNachname() {
		return nachname.getRealString();
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
		return "Student [vorname=" + vorname.getRealString() + ", nachname=" + nachname.getRealString() + ", matrikelnummer=" + matrikelnummer
				+ ", studiengang=" + studiengang + "]";
	}
	
	

}
