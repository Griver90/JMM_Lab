package finki.ukim.mk.lab1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapterProdukt extends ArrayAdapter<Produkt>{
	
	private  Context context;
	private  ArrayList<Produkt> produkt;
	
	public ListAdapterProdukt(Context context, ArrayList<Produkt> produkt) {
		super(context,R.layout.table_row_layout, produkt);
		this.context = context;
		this.produkt= produkt;
		
	}
	
	@Override
	public View getView(int pozicija, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.table_row_layout, parent, false);
	    
	    TextView ime = (TextView) rowView.findViewById(R.id.lblImeProdukt);
	    TextView cena = (TextView) rowView.findViewById(R.id.lblPriceProdukt);
	    ImageView img = (ImageView) rowView.findViewById(R.id.imgPopust);
	    
	        ime.setText(produkt.get(pozicija).getIme());
		    cena.setText(produkt.get(pozicija).getCena()+"");
		    float pop = produkt.get(pozicija).getPopust();
		    
		    if(pop<=25.0)
		    {
		    	img.setImageResource(R.drawable.popustne);
		    }
		    else if (pop>=75.0)
		    {
		    	img.setImageResource(R.drawable.popust75);
		    }
		    else if (pop>=50.0)
		    {
		    	img.setImageResource(R.drawable.popust50);
		    }
		    else
		    {
		    	img.setImageResource(R.drawable.popust25);
		    }
		return rowView;
	}
	
	public void add(Produkt p)
	{
		produkt.add(p);
		notifyDataSetChanged();
	}
	
	public void addAll(ArrayList<Produkt> produkti)
	{
		this.clear();
		for(Produkt p : produkti)
		{
			this.add(p);
		}
	}

}
