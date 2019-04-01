package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.DAO.StudenteDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model;
	private List<Corso> corsi;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<Corso> comboCorso;

	@FXML
	private Button btnCercaIscrittiCorso;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnCercaNome;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	@FXML
	private Button btnCerca;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	void doCercaCorsi(ActionEvent event) {
		int matricola = 0;
		try {
			matricola = Integer.parseInt(txtMatricola.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

		if (matricola == 0) {
			// TODO: errore del tipo
		}

		List<Corso> corsiMatricola = model.getCorsiMatricola(matricola);

		txtResult.clear();
		for (Corso corso : corsiMatricola)
			txtResult.appendText(String.format("%-7s   %d   %-50s %d\n", corso.getCodins(), corso.getCrediti(),
					corso.getNome(), corso.getPd()));

	}

	@FXML
	void doCercaIscrittiCorso(ActionEvent event) {

		Corso inCorso = comboCorso.getSelectionModel().getSelectedItem();
		if (inCorso.getNome().equals("")) {
			txtResult.setText("Selezionare almeno un corso");
			return;
		}

		List<Studente> studenti = model.getIscrittiCorso(inCorso);

		txtResult.clear();
		for (Studente studente : studenti)
			txtResult.appendText(String.format("%d %-25s %-25s %-20s\n", studente.getMatricola(), studente.getNome(),
					studente.getCognome(), studente.getCDS()));

	}

	/*
	 * permette di caricare uno studente data la matricola
	 */
	@FXML
	void doCercaNome(ActionEvent event) {
		// TODO: da completare il controllo magari scrivendo qualcosa a schermo
		int matricola = 0;

		try {
			matricola = Integer.parseInt(txtMatricola.getText());
			if (matricola == 0) {
				// TODO: da completare l'errore anche qui, la matricola non puo essere zero
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Studente s = model.getStudente(matricola);
		if (s == null) {
			// TODO: studente non trovato
			return;
		}
		txtNome.setText(s.getNome());
		txtCognome.setText(s.getCognome());

	}

	@FXML
	void doIscrivi(ActionEvent event) {

	}

	@FXML
	void doReset(ActionEvent event) {

		txtNome.clear();
		txtCognome.clear();
		txtMatricola.clear();
		txtResult.clear();

	}

	@FXML
	void initialize() {
		assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

		// Utilizzare questo font per incolonnare correttamente i dati
		txtResult.setStyle("-fx-font-family: monospace");

	}

	public void setModel(Model model) {
		this.model = model;
		setComboItems();
	}

	private void setComboItems() {

		corsi = model.getTuttiICorsi();
		corsi.add(new Corso("", 0, "", 0));
		Collections.sort(corsi);
		this.comboCorso.getItems().addAll(corsi);

	}
}
