package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlateController {

    String ANSI_RESET = "\u001B[0m";

    private ScreenController scr = new ScreenController();

    public String plateSelection(String hexString) throws NumberFormatException, IOException {

        String newHex = "C5 14 F7 03"; //That's the police nos cheat code
        List<String> plates = new ArrayList<>();    //List of the default plates
        plates.add("E1 F7 A4 01");
        plates.add("A2 29 F9 02");
        plates.add("EC AD C4 03");
        plates.add("E8 34 F6 03");
        plates.add("F7 01 5F 03");
        plates.add("0E 9E 7D 02");
        plates.add("12 55 C2 00");



        String CocaCola = "B9 EC EA 00";
        String NFSRivals = "28 B2 6D 02";
        String NFSDeluxe = "93 F1 D7 02";
        String EAAccess = "EE FE 93 01";

        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();

        if(!hasValidPlates(plates, hexString)){
            System.out.println("\n\u001B[31m WARNING!! NO VALID PLATES FOUND TO USE THIS OPTION. ANY CHANGES WILL NOT FOUND");
        }

        System.out.println("\n\u001B[34m1)" + ANSI_RESET + " All Plates to CocaCola");
        System.out.println("\u001B[34m2)" + ANSI_RESET + " All Plates to NFSRivals");
        System.out.println("\u001B[34m3)" + ANSI_RESET + " All Plates to NFSDeluxe");
        System.out.println("\u001B[34m4)" + ANSI_RESET + " All Plates to EAAcces");
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
                        hexString = replaceAll(plates, CocaCola, hexString);
                        System.out.println("\nCocaCola plate applied\n");
                    break;
                case 2:
                    hexString = replaceAll(plates, NFSRivals, hexString);
                    System.out.println("\nNFSRivals plate applied\n");
                    break;
                case 3:
                    hexString = replaceAll(plates, NFSDeluxe, hexString);
                    System.out.println("\nNFSDeluxe plate applied\n");
                    break;
                case 4:
                    hexString = replaceAll(plates, EAAccess, hexString);
                    System.out.println("\nEAAccess plate applied\n");
                    break;
                default:
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET + " All Plates to CocaCola");
                    System.out.println("\u001B[34m2)" + ANSI_RESET + " All Plates to NFSRivals");
                    System.out.println("\u001B[34m3)" + ANSI_RESET + " All Plates to NFSDeluxe");
                    System.out.println("\u001B[34m4)" + ANSI_RESET + " All Plates to EAAcces");
                    System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }

        return hexString;
    }

    public boolean hasValidPlates(List<String> plates, String hexString){
        boolean exist = false;
        for(String p : plates){
            if (hexString.contains(p)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    public String replaceAll(List<String> plates, String moddedPlate, String hexString){
        for(String p : plates){
            hexString = hexString.replaceAll(p, moddedPlate);
        }
        return hexString;
    }
}
