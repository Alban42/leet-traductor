package fr.alban.leet_translator.listener;

import fr.alban.leet_translator.model.Translator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/**
 * Listener class for the Text to leet button.
 * 
 * @author Alban Menager
 * @author alban.menager{at}gmail.com
 */
public class BoutonTextLeetEcouteur implements OnClickListener{
	
	private EditText textOriginal;
	private EditText textLeet;
	private Translator traducteur;
	
	public BoutonTextLeetEcouteur(Translator traducteur, EditText textOriginal, EditText textLeet){
		this.traducteur = traducteur;
		this.textOriginal = textOriginal;
		this.textLeet = textLeet;
	}

	@Override
	public void onClick(View arg0) {
		if(!(textOriginal.getText().toString().equals("")))
			textLeet.setText(traducteur.traduireTextVersLeet(textOriginal.getText().toString().trim()));
	}
}
