package com.example.imagelistview;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ElectroMagnetCat extends ActionBarActivity{
	ListView lv;
    Context context;
 
    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.olp,R.drawable.olp,R.drawable.olp,R.drawable.olp,R.drawable.c,R.drawable.ind,R.drawable.actodc};
    public static String [] prgmNameList={"Ohm's Law Power","Ohm's Law Voltage","Ohm's Law Current","Ohm's Law Resistence"
    	,"Capacitance","Inductance","AC To DC Convertion"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        context=this;
 
        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomerAdapter(this, prgmNameList,prgmImages));
 
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
      // action with ID action_refresh was selected
      case R.id.about:
    	  Intent intent=new Intent(getApplicationContext(),AboutAndMain.class);
    	  intent.putExtra("direct", "about");
    	  startActivity(intent);
        //Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
           // .show();
        break;
      // action with ID action_settings was selected
      case R.id.contact:
        //Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
          //  .show();
    	  Intent i=new Intent(getApplicationContext(),AboutAndMain.class);
    	  i.putExtra("direct", "main");
    	  startActivity(i);
        break;
      default:
        break;
      }

      return true;
    } 

}
