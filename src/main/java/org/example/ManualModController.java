package org.example;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mysql.cj.util.StringUtils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManualModController {

    String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_BOLD = "\u001B[1m";
    final String ANSI_LIGHT_BLUE = "\u001B[94m";
    final String ANSI_UNDERLINE = "\u001B[4m";
    final String ANSI_LIGHT_GREEN = "\u001B[92m";
    final String ANSI_GREEN = "\u001B[32m";


    private ScreenController scr = new ScreenController();

    public String selectMod(String hexString) throws NumberFormatException, IOException {


        Scanner scanner = new Scanner(System.in);
        boolean success = false;



        while (true) {
            scr.clearScr();
            scr.printTitle();
            System.out.println("\n\u001B[34m1)" + ANSI_RESET + " Replace single code");
            System.out.println("\u001B[34m2)" + ANSI_RESET + " Replace all codes");
            System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
            System.out.print("Select an option: ");

            if(success){
                System.out.println( ANSI_GREEN + ANSI_BOLD + "\nCodes substitute with success" + ANSI_RESET);
                success = false;
            }
            int choice = scanner.nextInt();

            if (choice == 9) {
                scr.clearScr();
                break;
            }

            switch (choice) {
                case 1:
                    while (true) {

                        System.out.println("\nPlease insert the code you want to substitute: ");
                        long input = scanner.nextInt();
                        String old = formatString(input);
                        if (hasValidPlates(old, hexString)) {
                            Pattern p = Pattern.compile(old);
                            Matcher m = p.matcher(hexString);
                            int count = 0;
                            while (m.find()){
                                count +=1;
                            }
                            System.out.println(count);
                            System.out.println(ANSI_GREEN + ANSI_BOLD + "(✓)"+ count + " HEX FOUND SUCCESSFULLY IN THE " + ANSI_UNDERLINE + "SAVE\n" + ANSI_RESET);
                            System.out.println("\nPlease enter which code you want to replace with: ");
                            long output = scanner.nextInt();
                            String nuovo = formatString(output);
                            hexString = hexString.replace(old, nuovo);
                            success = true;
                            break;
                        } else {
                            System.out.println(ANSI_RED + ANSI_BOLD + "(X) CAN'T FIND THE HEX IN THE " + ANSI_UNDERLINE + "SAVE" + ANSI_RESET + ANSI_RED + ANSI_BOLD + ", PLEASE TRY WITH ANOTHER ONE" + ANSI_RESET);
                        }
                    }
                    break;
                case 2:
                    while (true) {

                        System.out.println("\nPlease insert the code you want to substitute: ");
                        long input = scanner.nextInt();
                        String old = formatString(input);
                        if (hasValidPlates(old, hexString)) {
                            Pattern p = Pattern.compile(old);
                            Matcher m = p.matcher(hexString);
                            int count = 0;
                            while (m.find()){
                                count +=1;
                            }

                            System.out.println(ANSI_GREEN + ANSI_BOLD + "\n(✓)"+ count + " HEX FOUND SUCCESSFULLY IN THE " + ANSI_UNDERLINE + "SAVE\n" + ANSI_RESET);
                            System.out.println("\nPlease enter which code you want to replace with: ");
                            long output = scanner.nextInt();
                            String nuovo = formatString(output);
                            hexString = hexString.replaceAll(old, nuovo);
                            success = true;
                            break;
                        } else {
                            System.out.println(ANSI_RED + ANSI_BOLD + "(X) CAN'T FIND THE HEX IN THE " + ANSI_UNDERLINE + "SAVE" + ANSI_RESET + ANSI_RED + ANSI_BOLD + ", PLEASE TRY WITH ANOTHER ONE" + ANSI_RESET);
                        }
                    }
                    break;
                default:
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET + " Replace single code");
                    System.out.println("\u001B[34m2)" + ANSI_RESET + " Replace all codes");
                    System.out.println("\u001B[34m9)" + ANSI_RESET + " Exit & Save");
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }

        return hexString;
    }

    public boolean hasValidPlates(String hex, String hexString){
        boolean exist = hexString.contains(hex);
        return exist;
    }

    public String replaceAll(List<String> plates, String moddedPlate, String hexString){
        for(String p : plates){
            hexString = hexString.replaceAll(p, moddedPlate);
        }
        return hexString;
    }



    private static String formatString(long input) {
        String hex = String.format("%08X", input); // Converti il numero in una stringa esadecimale di lunghezza fissa
        // Verifica che la stringa abbia una lunghezza valida
        if (hex == null || hex.length() != 8) {
            throw new IllegalArgumentException("Input string must be non-null and have a length of 8.");
        }

        // Costruisce la stringa con spazi tra i gruppi di caratteri
        return hex.substring(6, 8) + " " +
                hex.substring(4, 6) + " " +
                hex.substring(2, 4) + " " +
                hex.substring(0, 2);
    }



}
