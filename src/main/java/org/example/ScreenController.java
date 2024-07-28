package org.example;

public class ScreenController {
	
	public ScreenController() {
		
	}
	
	public void printTitle() {
    	System.out.println(	"---------------------------------------------------------------------\r\n"
				+ 			"---------------------------------------------------------------------\r\n"
				+ 			"---------                 \u001B[31mNFS Payback Save-Mod\u001B[0m              ---------\r\n"
				+ 			"---------                                                   ---------\r\n"
				+ 			"---------                      \u001B[31mBy CladKey\u001B[0m                   ---------\r\n"
				+			"---------------------------------------------------------------------\r\n"
				+ 			"---------------------------------------------------------------------");
    }
    
    public void clearScr() {
    	System.out.print("\033c");
    }
	
}
