package fr.alban.leet_traductor.model;

import java.util.LinkedList;

public class CoupleCorrespondance {
	
	private char caractereText;
	private LinkedList<String> liste;
	
	public CoupleCorrespondance(char caractereText, String caracteresLeet[]) {
		this.caractereText = caractereText;
		liste = new LinkedList<String>();

		for(String s: caracteresLeet){
			liste.add(s);
		}
	}
	public char getCaractereText() {
		return caractereText;
	}

	public LinkedList<String> getCaracteresLeet() {
		return liste;
	}
}
