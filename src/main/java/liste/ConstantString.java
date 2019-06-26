package liste;

public class ConstantString {

	public final static int MAX_NAME_LENGTH = 64;
	private final char FILL_CHAR = 'a';
	
	String s;
	String realString;
	
	public ConstantString(String s) {
		
		realString = s;
		
		if(s.length() <= MAX_NAME_LENGTH) {
			this.s = fillString(s.toLowerCase());
		}
		else {
			//TODO Exception
		}
	}
	
	private String fillString(String s) {	
		while(s.length() < MAX_NAME_LENGTH) {
			s += FILL_CHAR;
		}	
		return s;
	}
	
	
	public String getString() {
		return s;
	}
	
	public String getRealString() {
		return realString;
	}
}
