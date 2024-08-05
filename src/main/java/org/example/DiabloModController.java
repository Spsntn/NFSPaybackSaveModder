package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiabloModController {


    String ANSI_RESET = "\u001B[0m";

    private ScreenController scr = new ScreenController();

    public String diabloModder(String hexString) throws NumberFormatException, IOException {


        List<String> diabloParts = new ArrayList<>();    //List of the default parts
        diabloParts.add("D2 CD 0B 20");
        diabloParts.add("53 DA D2 FA");
        diabloParts.add("C3 15 8B 90");
        diabloParts.add("F3 B8 B3 45");
        diabloParts.add("F2 5F D6 30");

        List<String> diabloMod = new ArrayList<>();    //List of the modded parts
        diabloMod.add("A4 B4 80 1A");
        diabloMod.add("46 22 2A A4");
        diabloMod.add("D5 29 C1 31");
        diabloMod.add("F6 F2 C4 A6");
        diabloMod.add("84 90 09 59");




        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();
        System.out.println("\n\u001B[31m To use this mod make sure to buy/swap a brand new lamborghini diablo with all stocks parts");

        if(!hasValidParts(diabloParts, hexString)){
            System.out.println("\n\u001B[31m WARNING!! YOU DON'T HAVE ALL THE STOCKS PART OF THE DIABLO SELECTED ON THE CAR. THE MOD COULD WORK ONLY PARTIALLY");
        }

        System.out.println("\n\u001B[34m1)" + ANSI_RESET + " Replace diablo with modded one");
        System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
        while (true) {

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 9) {
                scr.clearScr();
                break;
            }

            if (choice == 1) {
                for (int i = 0; i < diabloParts.size() - 1; i++) {
                    hexString = hexString.replace(diabloParts.get(i), diabloMod.get(i));
                }
                System.out.println("\nModded Diablo edit applied, press 9 then enter to save and exit\n");
            } else {
                scr.clearScr();
                scr.printTitle();
                System.out.println("\n\u001B[34m1)" + ANSI_RESET + " Replace diablo with modded one");
                System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
                System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }

        return hexString;
    }

    public boolean hasValidParts(List<String> diabloParts, String hexString){
        boolean exist = true;
        for(String p : diabloParts){
            if (!hexString.contains(p)) {
                exist = false;
                break;
            }
        }
        return exist;
    }


}
