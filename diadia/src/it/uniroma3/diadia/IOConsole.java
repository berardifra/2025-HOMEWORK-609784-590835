package it.uniroma3.diadia;
import java.util.Scanner;

/**
 * Classe IOConsole - Gestisce la stampa e la lettura a schermo. 
 * 
 */
public class IOConsole {

	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		// scannerDiLinee.close();
		return riga;
	}
}
