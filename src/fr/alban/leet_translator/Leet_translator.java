package fr.alban.leet_translator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import fr.alban.leet_translator.R;
import fr.alban.leet_translator.listener.BoutonLeetTextEcouteur;
import fr.alban.leet_translator.listener.BoutonTextLeetEcouteur;
import fr.alban.leet_translator.model.Translator;

/**
 * Main activity
 * 
 * @author Alban Menager
 * @author alban.menager{at}gmail.com
 * 
 */
public class Leet_translator extends Activity {

	private Button boutonTraductionTextLeet;
	private Button boutonTraductionLeetText;
	private EditText textOriginal;
	private EditText textTraduit;

	private Translator traducteur;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		traducteur = new Translator();

		// récupération du bouton grâce à son ID
		boutonTraductionTextLeet = (Button) findViewById(R.id.traductorTextLeet);
		boutonTraductionTextLeet.setEnabled(false);
		boutonTraductionLeetText = (Button) findViewById(R.id.traductorLeetText);
		boutonTraductionLeetText.setEnabled(false);

		textOriginal = (EditText) findViewById(R.id.textorig);
		textTraduit = (EditText) findViewById(R.id.texttraduit);

		LinearLayout parent = (LinearLayout) findViewById(R.id.parent);
		textOriginal.setMaxHeight((int) (parent.getHeight() * 0.45));
		textTraduit.setMaxHeight((int) (parent.getHeight() * 0.45));

		// on applique un écouteur d'évenement au clique sur le bouton
		boutonTraductionTextLeet.setOnClickListener(new BoutonTextLeetEcouteur(
				traducteur, textOriginal, textTraduit));
		boutonTraductionLeetText.setOnClickListener(new BoutonLeetTextEcouteur(
				traducteur, textOriginal, textTraduit));

		textOriginal.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (textOriginal.getText().toString().trim().equals("")) {
					boutonTraductionTextLeet.setEnabled(false);
				} else {
					boutonTraductionTextLeet.setEnabled(true);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

		textTraduit.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (textTraduit.getText().toString().trim().equals("")) {
					boutonTraductionLeetText.setEnabled(false);
				} else {
					boutonTraductionLeetText.setEnabled(true);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.clear_all:
			this.textOriginal.setText("");
			this.textTraduit.setText("");
			return true;
		case R.id.clear_text:
			this.textOriginal.setText("");
			return true;
		case R.id.clear_leet:
			this.textTraduit.setText("");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}