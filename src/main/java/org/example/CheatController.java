package org.example;

import java.io.IOException;
import java.util.Scanner;

public class CheatController {
    String ANSI_RESET = "\u001B[0m";
	FileController file = new FileController();
	ScreenController scr = new ScreenController();
	NosController nosContr = new NosController();
	ArchetypeController archCont = new ArchetypeController();
    CarController carContr = new CarController();
    PlateController plateContr = new PlateController();
    DiabloModController diabloContr = new DiabloModController();
    WhiteTiresController tireContr = new WhiteTiresController();
    HeightController heightContr = new HeightController();
    ManualModController manuContr = new ManualModController();


    LiveTunController liveContr = new LiveTunController();
	
	public CheatController() {
		
	}
	
	public String choise(String hexString, String path) throws NumberFormatException, IOException {
		
		Scanner scanner = new Scanner(System.in);

        while (true) {
            scr.clearScr();
        	scr.printTitle();
            System.out.println("\n\u001B[34m1)" + ANSI_RESET+ " Nos mod");
            System.out.println("\u001B[34m2)" + ANSI_RESET+ " Archetype mod");
            System.out.println("\u001B[34m3)" + ANSI_RESET+ " Live Tuning mod");
            System.out.println("\u001B[34m4)" + ANSI_RESET+ " Car Swap mod");
            System.out.println("\u001B[34m5)" + ANSI_RESET+ " Plate Swap mod");
            System.out.println("\u001B[34m6)" + ANSI_RESET+ " Diablo Led mod");
            System.out.println("\u001B[34m7)" + ANSI_RESET+ " White tire mod");
            System.out.println("\u001B[34m8)" + ANSI_RESET+ " Height mod");
            System.out.println("\u001B[34m9)" + ANSI_RESET+ " MANUAL MOD HEX");
            System.out.println("\u001B[34m10)" + ANSI_RESET+ " Exit & Save");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 10) {
                break;
            }

            switch (choice) {
                case 1:
                	hexString = nosContr.nosSelection(hexString);
                    break;
                case 2:
                	hexString = archCont.archSelec(hexString);
                    break;
                case 3:
                	hexString = liveContr.liveTunSel(hexString);
                    break;
                case 4:
                    hexString = carContr.carSelection(hexString);
                    break;
                case 5:
                    hexString = plateContr.plateSelection(hexString);
                    break;
                case 6:
                    hexString = diabloContr.diabloModder(hexString);
                    break;
                case 7:
                    hexString = tireContr.tireModder(hexString);
                    break;
                case 8:
                    hexString = heightContr.slamThem(hexString);
                    break;
                case 9:
                    hexString = manuContr.selectMod(hexString);
                    break;
                default:
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }
        scanner.close();
        
        return hexString;
	}
}
