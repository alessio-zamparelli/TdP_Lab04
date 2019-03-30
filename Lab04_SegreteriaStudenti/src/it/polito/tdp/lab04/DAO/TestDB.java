package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * This is a main to check the DB connection
		 */

		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		StudenteDAO sdao = new StudenteDAO();
		Studente s = sdao.getStudente(161245);
		System.out.println(s);

	}

}
