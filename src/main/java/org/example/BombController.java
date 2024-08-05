package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombController {

    String ANSI_RESET = "\u001B[0m";

    private ScreenController scr = new ScreenController();

    public String bombModAdder(String hexString) throws NumberFormatException, IOException {

        String bombId = "E4 68 50 00"; //That's the trunk bomb id
        String AventadorID = "32 E8 8F 84";
        String G63ID = "2D 0B 24 03";




        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();

        if(!hasValidID(AventadorID, hexString)  || !hasValidID(G63ID, hexString)){
            System.out.println("\n\u001B[31m WARNING!! NO VALID ID FOUND TO USE THIS OPTION. ANY CHANGES WILL NOT FOUND");
        }

        System.out.println("\n\u001B[34m1)" + ANSI_RESET + " Replace all the Aventadors with Bomb");
        System.out.println("\u001B[34m2)" + ANSI_RESET + " Replace all the G63 with Bomb");
        System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
        while (true) {

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 9) {
                scr.clearScr();
                break;
            }

            switch (choice) {
                case 1:
                        hexString = hexString.replaceAll(AventadorID, bombId);
                        System.out.println("\nAventador bomb applied\n");
                    break;
                case 2:
                    hexString = hexString.replaceAll(G63ID, bombId);
                    System.out.println("\nG63 bomb applied\n");
                    break;
                default:
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET + " Replace all the Aventadors with Bomb");
                    System.out.println("\u001B[34m2)" + ANSI_RESET + " Replace all the G63 with Bomb");
                    System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }

        return hexString;
    }

    public boolean hasValidID(String ID, String hexString){
        return hexString.contains(ID);
    }

}
