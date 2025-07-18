package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

/**
 * gestisce il caso in cui si inserisca un comando non valido
 * 
 * @see Comando
 * @version hw2
 */
public class ComandoNonValido implements Comando {

	public static final String COMANDO_NON_VALIDO = "Comando non valido";

	@Override
	public void esegui(Partita partita) {
		partita.getIoconsole().mostraMessaggio(COMANDO_NON_VALIDO);

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
