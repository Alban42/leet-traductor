/**
 * 
 */
package fr.alban.leet_translator.model;

import java.util.ArrayList;

/**
 * Translator class.
 * 
 * @author Alban Menager
 * @author alban.menager{at}gmail.com
 * 
 */
public class Translator {

	private ArrayList<CoupleCorrespondance> tableauCorrespondance;

	public Translator() {
		tableauCorrespondance = new ArrayList<CoupleCorrespondance>();

		tableauCorrespondance.add(new CoupleCorrespondance('a', new String[] {
				"4", "@", "^", "aye", "/-\\", "|-\\" }));
		tableauCorrespondance.add(new CoupleCorrespondance('b',
				new String[] { "8", "13", "|3", "ß", "P>", "|:", "!3", "(3",
						"/3", ")3", "|3" }));
		tableauCorrespondance.add(new CoupleCorrespondance('c', new String[] {
				"(", "[", "¢" }));
		tableauCorrespondance.add(new CoupleCorrespondance('d', new String[] {
				"|)", "l)", ")", "|o", "[)", "I>", "|>", "T)", "</" }));
		tableauCorrespondance.add(new CoupleCorrespondance('e', new String[] {
				"3", "&", "€", "£", "ë", "[-", "|=-" }));
		tableauCorrespondance.add(new CoupleCorrespondance('f', new String[] {
				"|=", "l=", "ƒ", "|#", "ph", "/=" }));
		tableauCorrespondance.add(new CoupleCorrespondance('g', new String[] {
				"6", "&", "(_+", "9", "C-", "gee", "(y," }));
		tableauCorrespondance.add(new CoupleCorrespondance('h', new String[] {
				"|-|", "#", "/-/", "[-]", "]-[", ")-(", "(-)", ":-:", "|~|",
				"]~[", "}{", "]-[", "}-{", "hèch" }));
		tableauCorrespondance.add(new CoupleCorrespondance('i', new String[] {
				"!", "][", "eye", "3y3", "]", ":" }));
		tableauCorrespondance.add(new CoupleCorrespondance('j', new String[] {
				"_|", "_l", "_/", "¿", "</", "(/", ";" }));
		tableauCorrespondance.add(new CoupleCorrespondance('k', new String[] {
				"|<", "|{" }));
		tableauCorrespondance.add(new CoupleCorrespondance('l', new String[] {
				"1", "£", "1_", "][_," }));
		tableauCorrespondance
				.add(new CoupleCorrespondance('m', new String[] { "|v|", "[V]",
						"{V}", "|\\/|", "/\\/\\", "(u)", "(V)", "(\\/)",
						"/|\\", "^^", "/|/|", "//.", ".\\\\", "/^^\\", "///",
						"|^^|" }));
		tableauCorrespondance.add(new CoupleCorrespondance('n', new String[] {
				"/\\/", "^/", "|V", "|\\|", "[\\]", "<\\>", "{\\}", "[]\\",
				"//", "^", "[]", "/V" }));
		tableauCorrespondance.add(new CoupleCorrespondance('q', new String[] {
				"<|", "()_", "0_", "0.", "°|", "(_,)", "°l", "<l" }));
		tableauCorrespondance.add(new CoupleCorrespondance('o', new String[] {
				"0", "0", "oh", "[]", "¤", "°", "([])" }));
		tableauCorrespondance.add(new CoupleCorrespondance('p', new String[] {
				"l*", "lo", "lº", "l^(o)", "l>", "l\"", "|*", "|o", "|º",
				"|^(o)", "|>", "|\"", "9", "[]D", "|°", "|7", "/*" }));
		tableauCorrespondance.add(new CoupleCorrespondance('r', new String[] {
				"|2", "|?", "l?", "/2", "|^", "lz", "®", "[z", "12", "|2",
				"|²", ".-", ",-" }));
		tableauCorrespondance.add(new CoupleCorrespondance('s', new String[] {
				"5", "$", "z", "§", "ehs", "es", "_/¯" }));
		tableauCorrespondance.add(new CoupleCorrespondance('t', new String[] {
				"7", "+", "-|-", "1", "']['", "†", "|²" }));
		tableauCorrespondance.add(new CoupleCorrespondance('u', new String[] {
				"|_|", "(_)", "1_1", "v", "L|", "µ" }));
		tableauCorrespondance.add(new CoupleCorrespondance('v', new String[] {
				"\\/", "1/", "|/" }));
		tableauCorrespondance.add(new CoupleCorrespondance('w', new String[] {
				"\\v/", "\\/\\/", "vv", "'//", "\\`", "\\^/", "(n)", "\\X/",
				"\\|/", "\\_|_/", "\\_:_/", "`^/", "\\./" }));
		tableauCorrespondance.add(new CoupleCorrespondance('x', new String[] {
				"><", "}{", "ecks", "×", ")(" }));
		tableauCorrespondance.add(new CoupleCorrespondance('y', new String[] {
				"`/", "j", "¥", "'/" }));
		tableauCorrespondance.add(new CoupleCorrespondance('z', new String[] {
				"=/=", "7_", "~/_", "%", ">_", ">_", "-\\_", "'/_" }));
	}

	/**
	 * Translate the text into leet.
	 * 
	 * @param text
	 *            the text to translate.
	 * @return the string containing the translated text.
	 */
	public String traduireTextVersLeet(String text) {
		String resultat = "";

		for (int i = 0; i < text.length(); i++) {
			if (Character.toString(text.charAt(i)).matches("[a-zA-Z]")) {
				resultat += correspondanceLeet(text.charAt(i));
			} else {
				resultat += text.charAt(i);
			}
		}

		return resultat;
	}

	/**
	 * Translate the leet into text.
	 * 
	 * @param leet
	 *            the text to translate.
	 * @return the string containing the translated text.
	 */
	public String traduireLeetVersText(String leet) {
		String resultat = "";
		String buffer = "";

		for (int i = 0; i < leet.length(); i++) {
			if (leet.charAt(i) != ' ') {
				buffer += leet.charAt(i);

				if (correspondanceText(buffer) != ' ') {
					resultat += correspondanceText(buffer);
					buffer = "";
				} else if (i == leet.length() - 1) {
					resultat += buffer;
					buffer = "";
				}

				if (buffer.length() == 5) {
					i = i - 4;
					resultat += leet.charAt(i);
					buffer = "";
				}
			} else {
				resultat += ' ';
			}
		}

		return resultat;
	}

	/**
	 * Return the cleet correspondence for the text character in parameter.
	 * 
	 * @param caractereText
	 *            the character to translate.
	 * @return the leet correspondence.
	 */
	private String correspondanceLeet(char caractereText) {
		String resultat = "";
		caractereText = Character.toLowerCase(caractereText);

		resultat = findLeet(caractereText).getCaracteresLeet().getFirst();

		return resultat;
	}

	/**
	 * Return the text correspondence for the leet character.
	 * 
	 * @param caractereLeet the leet character to translate.
	 * @return the text correspondence.
	 */
	private char correspondanceText(String caractereLeet) {
		char resultat = ' ';

		if (findText(caractereLeet.toLowerCase()) != null) {
			resultat = findText(caractereLeet.toLowerCase()).getCaractereText();
		}

		return resultat;
	}

	/**
	 * Return the cleet correspondence for the text character in parameter.
	 * 
	 * @param caractereText
	 *            the character to translate.
	 * @return the leet correspondence.
	 */
	private CoupleCorrespondance findText(String caractereLeet) {

		CoupleCorrespondance couple = null;

		for (CoupleCorrespondance c : tableauCorrespondance) {
			for (String s : c.getCaracteresLeet()) {
				if (s.equals(caractereLeet)) {
					return c;
				}
			}
		}

		return couple;
	}

	/**
	 * Return the text correspondence for the leet character.
	 * 
	 * @param caractereLeet the leet character to translate.
	 * @return the text correspondence.
	 */
	private CoupleCorrespondance findLeet(char caractereText) {

		CoupleCorrespondance couple = null;

		for (CoupleCorrespondance c : tableauCorrespondance) {
			if (c.getCaractereText() == caractereText) {
				return c;
			}
		}

		return couple;
	}
}