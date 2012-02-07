package fr.alban.leet_traductor.listener;

import fr.alban.leet_traductor.model.Traductor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class BoutonLeetTextEcouteur implements OnClickListener{
	
	private EditText textOriginal;
	private EditText textLeet;
	private Traductor traducteur;
	
	public BoutonLeetTextEcouteur(Traductor traducteur, EditText textOriginal, EditText textLeet){
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
