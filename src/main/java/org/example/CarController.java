package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarController {

    private ScreenController scr = new ScreenController();

    private CarController2 car = new CarController2();
    String ANSI_RESET = "\u001B[0m";

    public CarController(){

    }

    public String carSelection(String hexString) throws NumberFormatException, IOException {
        String nissan180sx = "24 A9 49 FC"; //That's the Nissan180sx
        String g63 = "B8 88 5C 02"; //That's the AMG G63
        String policeCar = "FC 90 8A 00"; //That's the police car
        String truck = "7C A5 02 01"; //That's the truck car
        String victoria = "19 0E FF 55"; //That's the police car



        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_BOLD = "\u001B[1m";
        final String ANSI_LIGHT_BLUE = "\u001B[94m";
        final String ANSI_UNDERLINE = "\u001B[4m";
        final String ANSI_LIGHT_GREEN = "\u001B[92m";

        // Stampa del testo formattato
        System.out.println(ANSI_RED + ANSI_BOLD + "\n------------------------WARNING!!!!!----------------------" + ANSI_RESET);
        System.out.println("To use this option you first need to have some specific cars!!");
        System.out.println(ANSI_YELLOW + ANSI_BOLD + "[DRAG]" + ANSI_RESET + "You need to buy a " + ANSI_LIGHT_BLUE + ANSI_BOLD + "Nissan180SX" + ANSI_RESET + " in the drag dealership");
        System.out.println(ANSI_BLUE + ANSI_BOLD + "[RUNNER]" + ANSI_RESET + "You need to buy a " + ANSI_LIGHT_BLUE + ANSI_BOLD + "AMG G63" + ANSI_RESET + " in the runner dealership");
        System.out.println("If you don't have it, it will not work and give error!!");
        System.out.println();
        System.out.println("if you want more cars, you need to buy as many");
        System.out.println(ANSI_LIGHT_GREEN + ANSI_UNDERLINE + "Example" + ANSI_RESET + ": if you want 1 corvette and 1 truck, you need to buy 2");
        System.out.println("Nissan180SX, then click the corvette option and the truck one");
        System.out.println(ANSI_YELLOW + ANSI_BOLD + "\n--------------[DRAG]--------------" + ANSI_RESET);
        System.out.println("\u001B[34m1)" + ANSI_RESET +  " Get Corvette Police Car");
        System.out.println("\u001B[34m2)" + ANSI_RESET+ " Get Truck");
        System.out.println("\u001B[34m3)" + ANSI_RESET+ " Get Police Victoria (working lights)");
        System.out.println(ANSI_BLUE + ANSI_BOLD +   "-------------[RUNNER]-------------" + ANSI_RESET);
        System.out.println("\u001B[34m4)" + ANSI_RESET +  " Get Corvette Police Car");
        System.out.println("\u001B[34m5)" + ANSI_RESET+ " Get Truck");
        System.out.println("\u001B[34m6)" + ANSI_RESET+ " Get Police Victoria (working lights)");
        System.out.println("\n\u001B[34m7)" + ANSI_RESET+ ANSI_YELLOW + ANSI_BOLD + " ADVANCEMODE" + ANSI_RESET);
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
                    if(hexString.contains(nissan180sx)) {
                        Pattern pattern = Pattern.compile(nissan180sx);
                        Matcher matcher = pattern.matcher(hexString);
                        hexString = matcher.replaceFirst(policeCar);
                        System.out.println("\nAdded corvette police car\n");
                    }else {
                        System.out.println("\nThere aren't any car avaiable for the swap, please add more in the save then come back");
                    }
                    break;
                case 2:
                    if(hexString.contains(nissan180sx)) {
                        Pattern pattern = Pattern.compile(nissan180sx);
                        Matcher matcher = pattern.matcher(hexString);
                        hexString = matcher.replaceFirst(truck);
                        System.out.println("\nAdded truck\n");
                    }else {
                        System.out.println("\nThere aren't any car avaiable for the swap, please add more in the save then come back");
                    }
                    break;
                case 3:
                    if(hexString.contains(nissan180sx)) {
                        Pattern pattern = Pattern.compile(nissan180sx);
                        Matcher matcher = pattern.matcher(hexString);
                        hexString = matcher.replaceFirst(victoria);
                        System.out.println("\nAdded victoria police car\n");
                    }else {
                        System.out.println("\nThere aren't any car avaiable for the swap, please add more in the save then come back");
                    }
                    break;
                case 4:
                    if(hexString.contains(g63)) {
                        Pattern pattern = Pattern.compile(g63);
                        Matcher matcher = pattern.matcher(hexString);
                        hexString = matcher.replaceFirst(policeCar);
                        System.out.println("\nAdded corvette police car\n");
                    }else {
                        System.out.println("\nThere aren't any car avaiable for the swap, please add more in the save then come back");
                    }
                    break;
                case 5:
                    if(hexString.contains(g63)) {
                        Pattern pattern = Pattern.compile(g63);
                        Matcher matcher = pattern.matcher(hexString);
                        hexString = matcher.replaceFirst(truck);
                        System.out.println("\nAdded truck\n");
                    }else {
                        System.out.println("\nThere aren't any car avaiable for the swap, please add more in the save then come back");
                    }
                    break;
                case 6:
                    if(hexString.contains(g63)) {
                        Pattern pattern = Pattern.compile(g63);
                        Matcher matcher = pattern.matcher(hexString);
                        hexString = matcher.replaceFirst(victoria);
                        System.out.println("\nAdded victoria police car\n");
                    }else {
                        System.out.println("\nThere aren't any car avaiable for the swap, please add more in the save then come back");
                    }
                    break;
                case 7:
                    String temp = car.carSelection(hexString);
                    boolean uguale = false;
                    if(hexString.equals(temp)){
                        uguale = true;
                    }else{
                        hexString = temp;
                    }
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println(ANSI_RED + ANSI_BOLD + "\n------------------------WARNING!!!!!----------------------" + ANSI_RESET);
                    System.out.println("To use this option you first need to have some specific cars!!");
                    System.out.println(ANSI_YELLOW + ANSI_BOLD + "[DRAG]" + ANSI_RESET + "You need to buy a " + ANSI_LIGHT_BLUE + ANSI_BOLD + "Nissan180SX" + ANSI_RESET + " in the drag dealership");
                    System.out.println(ANSI_BLUE + ANSI_BOLD + "[RUNNER]" + ANSI_RESET + "You need to buy a " + ANSI_LIGHT_BLUE + ANSI_BOLD + "AMG G63" + ANSI_RESET + " in the runner dealership");
                    System.out.println("If you don't have it, it will not work and give error!!");
                    System.out.println();
                    System.out.println("if you want more cars, you need to buy as many");
                    System.out.println(ANSI_LIGHT_GREEN + ANSI_UNDERLINE + "Example" + ANSI_RESET + ": if you want 1 corvette and 1 truck, you need to buy 2");
                    System.out.println("Nissan180SX, then click the corvette option and the truck one");
                    System.out.println(ANSI_YELLOW + ANSI_BOLD + "\n--------------[DRAG]--------------" + ANSI_RESET);
                    System.out.println("\u001B[34m1)" + ANSI_RESET +  " Get Corvette Police Car");
                    System.out.println("\u001B[34m2)" + ANSI_RESET+ " Get Truck");
                    System.out.println("\u001B[34m3)" + ANSI_RESET+ " Get Police Victoria (working lights)");
                    System.out.println(ANSI_BLUE + ANSI_BOLD +   "-------------[RUNNER]-------------" + ANSI_RESET);
                    System.out.println("\u001B[34m4)" + ANSI_RESET +  " Get Corvette Police Car");
                    System.out.println("\u001B[34m5)" + ANSI_RESET+ " Get Truck");
                    System.out.println("\u001B[34m6)" + ANSI_RESET+ " Get Police Victoria (working lights)");
                    System.out.println("\n\u001B[34m7)" + ANSI_RESET+ ANSI_YELLOW + ANSI_BOLD + " ADVANCEMODE" + ANSI_RESET);
                    System.out.println("\u001B[34m9)" + ANSI_RESET+ " Exit & Save");
                    if(!uguale)System.out.println("\u001B[34m" + ANSI_RESET+ ANSI_LIGHT_GREEN + ANSI_BOLD +ANSI_UNDERLINE + "ADVANCEMODE APPLIED" + ANSI_RESET);
                    break;
                default:
                    scr.clearScr();
                    scr.printTitle();
                    System.out.println(ANSI_RED + ANSI_BOLD + "\n------------------------WARNING!!!!!----------------------" + ANSI_RESET);
                    System.out.println("To use this option you first need to have some specific cars!!");
                    System.out.println(ANSI_YELLOW + ANSI_BOLD + "[DRAG]" + ANSI_RESET + "You need to buy a " + ANSI_LIGHT_BLUE + ANSI_BOLD + "Nissan180SX" + ANSI_RESET + " in the drag dealership");
                    System.out.println(ANSI_BLUE + ANSI_BOLD + "[RUNNER]" + ANSI_RESET + "You need to buy a " + ANSI_LIGHT_BLUE + ANSI_BOLD + "AMG G63" + ANSI_RESET + " in the runner dealership");
                    System.out.println("If you don't have it, it will not work and give error!!");
                    System.out.println();
                    System.out.println("if you want more cars, you need to buy as many Nissan180SX!");
                    System.out.println(ANSI_LIGHT_GREEN + ANSI_UNDERLINE + "Example" + ANSI_RESET + ": you want 1 corvette and 1 truck, you need to buy 2");
                    System.out.println("Nissan180SX, then click the corvette option then the truck one");
                    System.out.println(ANSI_YELLOW + ANSI_BOLD + "--------------[DRAG]--------------" + ANSI_RESET);
                    System.out.println("\n\u001B[34m1)" + ANSI_RESET +  " Get Corvette Police Car");
                    System.out.println("\u001B[34m2)" + ANSI_RESET+ " Get Truck");
                    System.out.println("\u001B[34m3)" + ANSI_RESET+ " Get Police Victoria (working lights)");
                    System.out.println(ANSI_BLUE + ANSI_BOLD + "-------------[RUNNER]-------------" + ANSI_RESET);
                    System.out.println("\n\u001B[34m4)" + ANSI_RESET +  " Get Corvette Police Car");
                    System.out.println("\u001B[34m5)" + ANSI_RESET+ " Get Truck");
                    System.out.println("\u001B[34m6)" + ANSI_RESET+ " Get Police Victoria (working lights)");
                    System.out.println("\u001B[34m7)" + ANSI_RESET+ ANSI_YELLOW + ANSI_BOLD + " ADVANCEMODE" + ANSI_RESET);
                    System.out.println("\u001B[34m9)" + ANSI_RESET+ " Exit & Save");
                    System.out.println("\n\u001B[31;1mInvalid Option.\u001B[0m");
            }
        }


        return hexString;

    }

}
