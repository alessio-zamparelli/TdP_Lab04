package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		
		Corso c = model.getTuttiICorsi().stream().findFirst().orElse(null);

//		model.getIscrittiCorso(c);
		System.out.println("ciao");
		System.out.println(model.getIscrittiCorso(c));
	}

}
