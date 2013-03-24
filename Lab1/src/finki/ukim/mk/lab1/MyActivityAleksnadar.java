package finki.ukim.mk.lab1;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MyActivityAleksnadar extends Activity {

	private ListAdapterProdukt adapter;
	private ListView lstview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aleksandar);
		
		  /*Intent intent = getIntent();
		  String text = "Korisnik so ime: "+intent.getStringExtra("ime")+" Email adresa: "+intent.getStringExtra("email")+" i Telefonski broj: "+intent.getStringExtra("telefon");
		  TextView tx = (TextView) findViewById(R.id.txtInfoFrom);
		  tx.setText(text);*/
		  ArrayList<Produkt> arlp = new ArrayList<Produkt>();
		  adapter= new ListAdapterProdukt(this, arlp);
	      lstview = (ListView) findViewById(R.id.lstProdukti);
		  lstview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_activity_aleksnadar, menu);
		return true;
	}
	
	public void dodadiProdukt(View view) {
		
		String ime=((EditText) findViewById(R.id.txtImeProdukt)).getText().toString() ;
		int cena=Integer.parseInt(((EditText) findViewById(R.id.txtCenaProdukt)).getText().toString()) ;
		float pop = Float.parseFloat(((EditText) findViewById(R.id.txtCenaProdukt)).getText().toString()) ;
		Produkt p = new Produkt(ime,cena,pop);
		
		adapter.add(p);
	}

}
