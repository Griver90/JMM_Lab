package finki.ukim.mk.lab1;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MyActivityAleksnadar extends Activity {

	private ListAdapterProdukt adapter;
	private ListView lstview;
	private dbManagment MyDB;
	private ArrayList<Produkt> lstProd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aleksandar);
		
		  Intent intent = getIntent();
		  String text = "Korisnik so ime: "+intent.getStringExtra("ime")+" Email adresa: "+intent.getStringExtra("email")+" i Telefonski broj: "+intent.getStringExtra("telefon");
		  TextView tx = (TextView) findViewById(R.id.txtInfoFrom);
		  tx.setText(text);
		  
		  MyDB = new dbManagment(this);
		  lstProd = new ArrayList<Produkt>();		  
		  adapter = new ListAdapterProdukt(this, lstProd);
		  
		  IntentFilter filter = new IntentFilter(getFromDBTask.ASYNC_TASK_DOWNLOAD); 
		  registerReceiver(new DownloadReciver(), filter);
		  startService(new Intent(this, RetriveService.class));
		  
		  
	      lstview = (ListView) findViewById(R.id.lstProdukti);
		  lstview.setAdapter(adapter);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		MyDB = new dbManagment(this);
		MyDB.Open();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		MyDB.Close();
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
		float pop = Float.parseFloat(((EditText) findViewById(R.id.txtPopustProdukt)).getText().toString()) ;
		Produkt p = new Produkt(ime,cena,pop);
		
		adapter.add(p);
		MyDB.Open();
		MyDB.Insert(p);
		MyDB.Close();
		
	}

	public void Refresh()
	{
		adapter.addAll(RetriveService.Prod);
	}
	
	class DownloadReciver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			
			Refresh();			
			MyActivityAleksnadar.this.unregisterReceiver(this);

		}
	}
}
