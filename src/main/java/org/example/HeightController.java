package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeightController {

    String ANSI_RESET = "\u001B[0m";

    private ScreenController scr = new ScreenController();

    public String slamThem(String hexString) throws NumberFormatException, IOException {

        String hexVisualMod150mm = "D6 A3 73 01";
        String hexHeightMod150mm = "92 BA 50 03";

        List<String> visualHexes = new ArrayList<>();    //List of the visual hex codes
        visualHexes.add("3F 7D CB 02");
        visualHexes.add("C9 7A E2 0A");
        visualHexes.add("DE CE C1 0E");
        visualHexes.add("ED 25 45 18");
        visualHexes.add("B2 69 4C F4");
        visualHexes.add("5B 6F 09 0B");
        visualHexes.add("3F 66 B7 00");
        visualHexes.add("54 82 D8 22");
        visualHexes.add("84 6B 31 00");
        visualHexes.add("FC 37 4D 00");
        visualHexes.add("27 51 D3 16");

        List<String> heightHexes = new ArrayList<>(); //Lists of the hex of the height stance tune of the cars
        heightHexes.add("2C 5B 04 01");
        heightHexes.add("DA D9 02 02");
        heightHexes.add("18 4D 24 02");
        heightHexes.add("9A 60 FF 02");
        heightHexes.add("97 FA 76 01");
        heightHexes.add("00 17 92 01");
        heightHexes.add("FB 61 3C 02");
        heightHexes.add("2E 4C 61 03");
        heightHexes.add("83 0A 61 01");
        heightHexes.add("17 34 A5 02");
        heightHexes.add("19 6A 2A 03");




        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();

        if(!hasValidCodes(visualHexes, hexString) || !hasValidCodes(heightHexes, hexString)){
            System.out.println("\n\u001B[31m WARNING!! NO VALID CODES FOUND TO USE THIS OPTION. ANY CHANGES WILL NOT FOUND");
        }

        System.out.println("\n\u001B[34m1)" + ANSI_RESET + "Slam them down!!!!");
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
                    hexString = replaceAll(visualHexes, hexVisualMod150mm, hexString);
                    hexString = replaceAll(heightHexes, hexHeightMod150mm, hexString);
                    System.out.println("\nCocaCola plate applied\n");
                    break;
                default:
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET + "Slam them down!!!!");
                    System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }

        return hexString;
    }

    public boolean hasValidCodes(List<String> codes, String hexString){
        boolean exist = false;
        for(String p : codes){
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
