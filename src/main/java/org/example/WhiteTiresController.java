package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhiteTiresController {

    String ANSI_RESET = "\u001B[0m";

    private ScreenController scr = new ScreenController();

    public String tireModder(String hexString) throws NumberFormatException, IOException {


        List<String> dragFront = new ArrayList<>();    //List of the front drag's tires
        dragFront.add("78 54 09 00");
        dragFront.add("93 FF 4A 02");
        dragFront.add("B6 36 47 02");
        dragFront.add("68 02 B2 00");


        List<String> dragRear = new ArrayList<>();    //List of the Rear drag's tires
        dragRear.add("2B 2F 9B 01");
        dragRear.add("5F 96 D8 01");
        dragRear.add("69 68 A0 03");
        dragRear.add("0C DB 6A 01");


        String whiteFront = "14 5E A7 02";
        String whiteRear = "C6 3A 1A 01";


        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();
        if((!hasValidTires(dragFront, hexString)) || (!hasValidTires(dragRear, hexString))){
            System.out.println("\n\u001B[31m WARNING!! NO VALID TIRES FOUND TO USE THIS OPTION. ANY CHANGES WILL NOT FOUND");
        }

        System.out.println("\n\u001B[34m1)" + ANSI_RESET + " All drags");
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
                    hexString = replaceAll(dragFront, whiteFront, hexString);
                    hexString = replaceAll(dragRear, whiteRear, hexString);
                    System.out.println("\nWhite Tires applied for Drags\n");
                    break;
                default:
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET + " All drags");
                    System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }

        return hexString;
    }

    public boolean hasValidTires(List<String> tires, String hexString){
        boolean exist = false;
        for(String p : tires){
            if (hexString.contains(p)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    public String replaceAll(List<String> tires, String moddedTire, String hexString){
        for(String p : tires){
            hexString = hexString.replaceAll(p, moddedTire);
        }
        return hexString;
    }

}
