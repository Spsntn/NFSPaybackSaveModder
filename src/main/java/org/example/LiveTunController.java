package org.example;

import java.io.IOException;
import java.util.Scanner;

public class LiveTunController {

    String ANSI_RESET = "\u001B[0m";

    private ScreenController scr = new ScreenController();

    public LiveTunController(){

    }

    public String liveTunSel(String hexString) throws NumberFormatException, IOException {
        String off_extr = "CF B3 9F 02"; //That's the offroad-extremity code;
        String gymk_extr = "F1 AB CB 02";//That's the heavinest of the car;

        Scanner scanner = new Scanner(System.in);

        scr.clearScr();
        scr.printTitle();
        System.out.println("\n\u001B[34m1)" + ANSI_RESET +  " Add offroad-extremity");
        System.out.println("\u001B[34m2)" + ANSI_RESET+ " Add heavinest settings");
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
                    if(hexString.contains("BB 8E E9 02")) {
                        hexString = hexString.replaceAll("BB 8E E9 02", off_extr);
                        System.out.println("\nOff-Extremity mod applied\n");
                    }else{
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                case 2:
                    if(hexString.contains("8A 43 B7 00")) {
                        hexString = hexString.replaceAll("8A 43 B7 00", gymk_extr);
                        System.out.println("\nGymk-Extremity(heavinest) mod applied on drags\n");
                    }else{
                        System.out.println("\nThere aren't any available possibility.\nIf you already chose this option please, select another or save and exit");
                    }
                    break;
                default:
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET +  " Add offroad-extremity");
                    System.out.println("\u001B[34m2)" + ANSI_RESET+ " Add heavinest settings");
                    System.out.println("\u001B[34m9)" + ANSI_RESET+ " Exit & Save");
                    System.out.println("\nInvalid Option.");
            }
        }


        return hexString;

    }

}
