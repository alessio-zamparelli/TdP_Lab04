package it.polito.tdp.lab04.model;

public class Studente {

	private int matricola;
	private String nome;
	private String cognome;
	private String CDS;
	
	public Studente(int matricola, String nome, String cognome, String cDS) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		CDS = cDS;
	}

	@Override
	public String toString() {
		return String.format("Studente [matricola=%s, nome=%s, cognome=%s, CDS=%s]", matricola, nome, cognome, CDS);
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
		return CDS;
	}

	
	
	
	
}
