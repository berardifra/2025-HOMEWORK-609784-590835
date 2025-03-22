package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Borsa - Ha la responsabilità di memorizzare 
 * gli oggetti del giocatore. 
 * 
 * @see Attrezzo
 */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * Aggiunge un attrezzo alla borsa. 
	 * 
	 * @param attrezzo
	 * @return true se aggiunto, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null || (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()))
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		
		return true;
	}
	
	public int getPesoMax() {
		return this.pesoMax;
	}
	
	/**
	 * Restituisce un riferimento ad un attrezzo della borsa. 
	 * 
	 * @param nomeAttrezzo
	 * @return riferimento ad Attrezzo, null altrimenti
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = this.attrezzi[i];

		return a;
	}
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Verifica se un attrezzo è presente in borsa. 
	 * 
	 * @param nomeAttrezzo
	 * @return true è presente, false altrimenti
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa. 
	 * 
	 * @param nomeAttrezzo
	 * @return riferimento ad Attrezzo, null altrimenti
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		//verifico che ci sia
		int i=0;
		boolean trovato=false;
		for(i=0; i<this.numeroAttrezzi && !trovato; i++){
			if(this.attrezzi[i].getNome().equals(nomeAttrezzo))
				trovato=true;	
		}
		if(trovato) {
			this.numeroAttrezzi--;
			a = this.attrezzi[i-1];
			this.attrezzi[i-1] = this.attrezzi[this.numeroAttrezzi];
			this.attrezzi[this.numeroAttrezzi] = null;
		}
		return a;
	}
	
	/**
	 * Restituisce una rappresentazione stringa di questa borsa, 
	 * stampandone il peso e gli eventuali attrezzi contenuti, specificando il loro pero. 
	 * @return la rappresentazione stringa 
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(this.attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
