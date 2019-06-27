package cli;

import java.util.Scanner;

public class MainMenu {
	
	MainOptions[] opts;
	
	SubMenu subMenu;
	
	public static Scanner scan;
	
	public MainMenu() {
		opts = MainOptions.values();
		scan = new Scanner(System.in);
	}
	
	protected void start() {
		
		int pick = -1;
		
		System.out.println(Phrases.framing("Hauptmenü"));
		for(int i = 0; i < opts.length; i++) {
			System.out.printf("%-3d: %s%n", i, opts[i]);
		}
		
		pick = Phrases.insertNumber(opts);
		
		if(pick >= 0)
		{
			switch(pick) {
			case 0:
				subMenu = new SinglyLinkedMenu();
				break;
			case 1:
				subMenu = new DoublyLinkedMenu();
				break;
			case 2:
				System.out.println("Programm wird beendet!");
				System.exit(0);
				break;
			default:
				break;
			}
			
			subMenu.start();
		}
		
		if(pick < 0) {
			System.out.println("Beende...");
		}
	}
	
	public static void refreshScan() {
		scan = new Scanner(System.in);
	}
}
