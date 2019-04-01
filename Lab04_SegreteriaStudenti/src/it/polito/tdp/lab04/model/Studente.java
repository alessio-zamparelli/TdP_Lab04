package it.polito.tdp.lab04.model;

public class Studente {

	private int matricola;
	private String nome;
	private String cognome;
	private String cds;
	
	public Studente(int matricola, String nome, String cognome, String cds) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cds = cds;
	}

	@Override
	public String toString() {
		return String.format("matricola=%s\tnome=%s\tcognome=%s\tCDS=%s\n", matricola, nome, cognome, cds);
	}

	public int getMatricola() {
		return matricola;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCDS() {
		return cds;
	}

	
	
	
	
}
