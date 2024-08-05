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
        dragFront.add("AF 67 E8 00");
        dragFront.add("FD BA AF 00");
        dragFront.add("54 F0 D7 03");
        dragFront.add("25 03 42 03");
        dragFront.add("66 E6 5D 02");
        dragFront.add("EC E8 EC 13");
        dragFront.add("EB 95 6F 7C");
        dragFront.add("B9 79 88 01");
        dragFront.add("8A 31 AE 00");
        dragFront.add("44 C6 2B 03");
        dragFront.add("20 D9 6F 00");
        dragFront.add("4F 13 31 02");
        dragFront.add("C2 CF B0 03");
        dragFront.add("E4 6F 91 02");
        dragFront.add("9D E2 4E 01");
        dragFront.add("E3 B2 DD 01");
        dragFront.add("21 E7 25 01");
        dragFront.add("29 7C 59 01");
        dragFront.add("3E 99 A2 03");
        dragFront.add("C5 E3 CC 03");
        dragFront.add("64 3F 96 00");



        List<String> dragRear = new ArrayList<>();    //List of the Rear drag's tires
        dragRear.add("2B 2F 9B 01");
        dragRear.add("5F 96 D8 01");
        dragRear.add("69 68 A0 03");
        dragRear.add("0C DB 6A 01");
        dragRear.add("20 81 BA 01");
        dragRear.add("FE DC 4D 01");
        dragRear.add("9A CF 2F 03");
        dragRear.add("5C 28 1B 01");
        dragRear.add("49 90 43 01");
        dragRear.add("F8 E8 EC 13");
        dragRear.add("7F 94 6F 7C");
        dragRear.add("B3 EA 23 03");
        dragRear.add("84 58 99 01");
        dragRear.add("20 9A 3F 02");
        dragRear.add("5B 5E 16 00");
        dragRear.add("84 71 E7 02");
        dragRear.add("26 81 20 03");
        dragRear.add("A3 69 B8 01");
        dragRear.add("9D 43 CE 03");
        dragRear.add("7D D4 13 03");
        dragRear.add("3E F4 0E 00");
        dragRear.add("60 2A 97 00");
        dragRear.add("B5 57 14 00");
        dragRear.add("89 69 43 00");
        dragRear.add("8C D3 67 03");




        String whiteFront = "14 5E A7 02";
        String whiteRear = "C6 3A 1A 01";


        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();
        if((!hasValidTires(dragFront, hexString)) || (!hasValidTires(dragRear, hexString))){
            System.out.println("\n\u001B[31m WARNING!! NO VALID TIRES FOUND TO USE THIS OPTION. ANY CHANGES WILL NOT FOUND");
        }

        System.out.println("\n\u001B[34m1)" + ANSI_RESET + " All the cars with white tires");
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
                    System.out.println("\nWhite Tires applied for all the cars\n");
                    break;
                default:
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET + " All the cars with white tires");
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
