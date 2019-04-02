package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;

	public Model() {
		this.corsoDAO = new CorsoDAO();
		this.studenteDAO = new StudenteDAO();
	}

	public List<Corso> getTuttiICorsi() {
		return corsoDAO.getTuttiICorsi();
	}

	public Studente getStudente(int matricola) {
		return studenteDAO.getStudente(matricola);
	}

	public List<Studente> getIscrittiCorso(Corso inCorso) {
		return corsoDAO.getIscrittiCorso(inCorso);
	}

	public List<Corso> getCorsiMatricola(int matricola) {

		return corsoDAO.getCorsiMatricola(matricola);
		
	}

	public boolean isMatricolaImmatricolata(int matricola) {
		return studenteDAO.getStudente(matricola)!=null;
	}
	
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return corsoDAO.inscriviStudenteACorso(studente, corso);
	}

}
