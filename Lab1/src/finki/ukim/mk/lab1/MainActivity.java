package finki.ukim.mk.lab1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void toMyActivity(View view){
    	Intent intent = new Intent(this, MyActivityAleksnadar.class);
    	intent.putExtra("ime",((EditText)findViewById(R.id.txtNameSurname)).getText().toString());
    	intent.putExtra("email", ((EditText)findViewById(R.id.txtEmail)).getText().toString());
    	intent.putExtra("telefon",((EditText)findViewById(R.id.txtPhone)).getText().toString());
    	
    	startActivity(intent);
    }
    
}
