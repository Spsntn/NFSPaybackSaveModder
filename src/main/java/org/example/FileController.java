package org.example;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileController {
	
	public FileController(){
		
	}

	public StringBuilder readfile(String path) throws IOException {
    	DataInputStream input = null;
    	StringBuilder hexBuilder = new StringBuilder();
    	
        try {
            // Apre il file .dat utilizzando DataInputStream
            input = new DataInputStream(new FileInputStream(path));
            
            
            // Legge il file byte per byte e converte in stringa esadecimale
            long fileSize = new FileInputStream(path).getChannel().size();
            long bytesRead = 0;
            int ch;
            int lastPercent = -1;
            System.out.println("Reading memory.dat.. Please wait");
            while ((ch = input.read()) != -1) {
                // Formatta la stringa esadecimale aggiungendo spazi
                hexBuilder.append(String.format("%02X ", ch));
                bytesRead++;

                // Calcola e visualizza la percentuale di caricamento
                int percent = (int) ((bytesRead * 100) / fileSize);
                if (percent != lastPercent) {
                    System.out.print("\rLoading: " + percent + "%");
                    lastPercent = percent;
                }
            }
            System.out.println("\nDone.");
        }

        catch (Exception e) {
            // gestione dell'eccezione
            System.out.println("Errore generale: " + e.getMessage());
        }
        finally {
            // Chiude il DataInputStream
//            if (input != null) {
//                input.close();
//            }
        }
        return hexBuilder;
    }
	
	public void writefile(String hexString, String path) throws NumberFormatException, IOException {
    	// Percorso della nuova cartella da creare
        String percorsoCartella = path + "\\Saved_memory ";

        // Creazione dell'oggetto File per rappresentare la nuova cartella
        File Saved_memory = new File(percorsoCartella);

        // Creazione effettiva della cartella
        Saved_memory.mkdir();
        
    	FileOutputStream fos = new FileOutputStream(path + "\\Saved_memory\\" + "\\memory.dat");
        String[] hexArray = hexString.trim().split(" ");
        int totalElements = hexArray.length;
        int elementsWritten = 0;
        int lastPercent = -1;
        for (String hex : hexArray) {
            fos.write(Integer.parseInt(hex, 16));
            elementsWritten++;

            // Calcola e visualizza la percentuale di caricamento
            int percent = (int) ((elementsWritten * 100) / totalElements);
            if (percent != lastPercent) {
                System.out.print("\rLoading: " + percent + "%");
                lastPercent = percent;
            }
        }
        fos.close();
        
        System.out.println("\n\nModded memory.dat saved in " + path + "\\Saved_memory");
    }
}
