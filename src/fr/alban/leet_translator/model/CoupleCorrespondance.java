package fr.alban.leet_translator.model;

import java.util.LinkedList;

/**
 * Couple class for the correcpondence between leet and text characters.
 * 
 * @author Alban Menager
 * @author alban.menager{at}gmail.com
 * 
 */
public class CoupleCorrespondance {

	private char caractereText;
	private LinkedList<String> liste;

	public CoupleCorrespondance(char caractereText, String caracteresLeet[]) {
		this.caractereText = caractereText;
		liste = new LinkedList<String>();

		for (String s : caracteresLeet) {
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
