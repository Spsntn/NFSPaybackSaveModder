package org.example;

import java.util.Scanner;

public class ArchetypeController {
    String ANSI_RESET = "\u001B[0m";
	private ScreenController scr = new ScreenController();
	private FileController file = new FileController();
	
	
	public ArchetypeController() {
		
	}
	
	public String archSelec(String hexString) {
		
		String raceCh = "31 FF 44 02"; //RaceCheat archetype
		String driftCh = "77 1A 0A 03"; //DriftCheat Arch
		String dragCh = "57 2B 16 00"; //DragCheat Arch
		String offCh = "A2 0B 49 00"; //OffRoadCheat Arch
		String runnerCh = "85 74 42 03"; //RunnerCheat Archetype

		
        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();
        System.out.println("\nSELECT THE ARCHETYPE THAT YOU WANT TO CHANGE:\n");
        System.out.println("\u001B[34m1)" + ANSI_RESET +" Race");
        System.out.println("\u001B[34m2)" + ANSI_RESET +" Drift");
        System.out.println("\u001B[34m3)" + ANSI_RESET +" Drag");
        System.out.println("\u001B[34m4)"+ ANSI_RESET+" Off-Road");
        System.out.println("\u001B[34m5)"+ ANSI_RESET+" Runner");
        System.out.println("\u001B[34m9)"+ ANSI_RESET+" Exit & Save");
        while (true) {
        	
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 9) {
            	scr.clearScr();
                break;
            }

            switch (choice) {
                case 1:
                    if (hexString.contains("8A DF D7 03")) {
                        hexString = hexString.replaceAll("8A DF D7 03", raceCh);
                        System.out.println("\nMod for Race applied\n");
                    } else {
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                case 2:
                    if(hexString.contains("3D 3F D0 01")){
                        hexString = hexString.replaceAll("3D 3F D0 01", driftCh);
                        System.out.println("\nMod for Drift applied\n");
                    }else {
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                case 3:
                    if(hexString.contains("EC B5 A2 01")) {
                        hexString = hexString.replaceAll("EC B5 A2 01", dragCh);
                        System.out.println("\nMod for Drag applied\n");
                    }else {
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                case 4:
                    if(hexString.contains("4D C9 CA 00")) {
                        hexString = hexString.replaceAll("4D C9 CA 00", offCh);
                        System.out.println("\nMod for Off-Road applied\n");
                    }else {
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                case 5:
                    if(hexString.contains("62 49 79 03")) {
                        hexString = hexString.replaceAll("62 49 79 03", runnerCh);
                        System.out.println("\nMod for Runner applied\n");
                    }else {
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                default:
                	scr.clearScr();
                	scr.printTitle();
                    System.out.println("\nSELECT THE ARCHETYPE THAT YOU WANT TO CHANGE:\n");
                    System.out.println("\u001B[34m1)" + ANSI_RESET +" Race");
                    System.out.println("\u001B[34m2)" + ANSI_RESET +" Drift");
                    System.out.println("\u001B[34m3)" + ANSI_RESET +" Drag");
                    System.out.println("\u001B[34m4)"+ ANSI_RESET+" Off-Road");
                    System.out.println("\u001B[34m5)"+ ANSI_RESET+" Runner");
                    System.out.println("\u001B[34m9)"+ ANSI_RESET+" Exit & Save");
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }

        
        return hexString;
	
		
	}
	

}
