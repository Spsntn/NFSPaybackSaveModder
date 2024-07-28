package org.example;

import java.io.IOException;
import java.util.Scanner;

public class NosController {
    String ANSI_RESET = "\u001B[0m";

	private ScreenController scr = new ScreenController();
	
	public NosController() {
		
	}
	
	public String nosSelection(String hexString) throws NumberFormatException, IOException {
		String newHex = "C5 14 F7 03"; //That's the police nos cheat code 
        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();
        System.out.println("\n\u001B[34m1)" + ANSI_RESET +  " NOS cheat for Drag");
        System.out.println("\u001B[34m2)" + ANSI_RESET+ " NOS cheat for Runner");
        System.out.println("\u001B[34m3)" + ANSI_RESET+ " NOS cheat for Offroad");
        System.out.println("\u001B[34m9)" + ANSI_RESET+ " Exit & Save");
        while (true) {
        	
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 9) {
            	scr.clearScr();
                break;
            }

            switch (choice) {
                case 1:
                    if(hexString.contains("4C 15 B7 01")) {
                        hexString = hexString.replaceAll("4C 15 B7 01", newHex);
                        System.out.println("\nMod for Drag applied\n");
                    }else {
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                case 2:
                    if(hexString.contains("61 DA DC 03")) {
                        hexString = hexString.replaceAll("61 DA DC 03", newHex);
                        System.out.println("\nMod for Runner applied\n");
                    }else {
                    System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                case 3:
                    if(hexString.contains("0F D1 86 00")) {
                        hexString = hexString.replaceAll("0F D1 86 00", newHex);
                        System.out.println("\nMod for Offroad applied\n");
                    }else {
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                default:
                	scr.clearScr();
                	scr.printTitle();
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET +  " NOS cheat for Drag");
                    System.out.println("\u001B[34m2)" + ANSI_RESET+ " NOS cheat for Runner");
                    System.out.println("\u001B[34m3)" + ANSI_RESET+ " NOS cheat for Offroad");
                    System.out.println("\u001B[34m9)" + ANSI_RESET+ " Exit & Save");
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }

        
        return hexString;
	
	}
	
}
