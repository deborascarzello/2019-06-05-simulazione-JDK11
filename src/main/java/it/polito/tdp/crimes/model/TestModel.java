package it.polito.tdp.crimes.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();
		System.out.println(m.creaGrafo(2014));
		System.out.println(m.getAdiacentiVertice(6));
		
	}

}
