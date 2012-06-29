package fr.alban.leet_translator.listener;

import fr.alban.leet_translator.model.Translator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/**
 * Listener class for the Leet to Text button.
 * 
 * @author Alban Menager
 * @author alban.menager{at}gmail.com
 */
public class BoutonLeetTextEcouteur implements OnClickListener{
	
	private EditText textOriginal;
	private EditText textLeet;
	private Translator traducteur;
	
	public BoutonLeetTextEcouteur(Translator traducteur, EditText textOriginal, EditText textLeet){
		this.traducteur = traducteur;
		this.textOriginal = textOriginal;
		this.textLeet = textLeet;
	}

	@Override
	public void onClick(View arg0) {
		if(!(textLeet.getText().toString().equals("")))
			textOriginal.setText(traducteur.traduireLeetVersText(textLeet.getText().toString().trim()));
	}
}
