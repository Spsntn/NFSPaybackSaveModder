package org.example;

import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;

public class cheat {

	public static void main(String[] args) {
			startProgram();
	}


	public static void startProgram() {
		AnsiConsole.systemInstall();
		final String ANSI_RESET = "\u001B[0m";

		ScreenController scr = new ScreenController();
		FileController file = new FileController();
		CheatController cheat = new CheatController();
		String hexFile = "";
		String path = "";

		Scanner scan = new Scanner(System.in);

		scr.printTitle();

		Scanner scanner = new Scanner(System.in);
			System.out.println("Insert the path to the\u001B[32m memory.dat"+ANSI_RESET+ " file :");
			while(hexFile == null || hexFile.isEmpty()) {
				path = scan.nextLine();
				try {
					hexFile = file.readfile(path + "\\memory.dat").toString();;
				} catch (IOException e) {
					scr.printTitle();
					e.printStackTrace();
					System.out.println("Insert the path to the\u001B[32m memory.dat"+ ANSI_RESET + " file :");
				}
			}

			try {
				hexFile = cheat.choise(hexFile, path);
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				System.out.println("Saving the modded memory.dat, please wait..");
				file.writefile(hexFile, path);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			scan.close();

	}

}


