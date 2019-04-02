package it.polito.tdp.lab04.DAO;


import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * This is a main to check the DB connection
		 */

		TestDB tdb = new TestDB();
		tdb.run2();
		
		
		
	}
	
	@SuppressWarnings("unused")
	private void run1() {
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		StudenteDAO sdao = new StudenteDAO();
		Studente s = sdao.getStudente(161245);
		System.out.println(s);
	}
	
	private void run2() {
		StudenteDAO sdao = new StudenteDAO();
		CorsoDAO cdao = new CorsoDAO();
		Corso c = cdao.getTuttiICorsi().stream().filter(a->a.getCodins().equals("01AAAAA")).findFirst().orElse(null);
		Studente s = sdao.getStudente(111111);
		System.out.println("Corso: " + c);
		System.out.println("Studente: " + s);
		
		System.out.println("risultato: " + cdao.inscriviStudenteACorso(s, c));
		
	}

}
