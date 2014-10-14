package com.example.imagelistview;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	  	ListView lv;
	    Context context;
	 
	    ArrayList prgmName;
	    public static int [] prgmImages={R.drawable.p1,R.drawable.c1};
	    public static String [] prgmNameList={"Physics","Chemistry"};
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
	        // Inflate the menu items for use in the action bar
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.main, menu);
	        return super.onCreateOptionsMenu(menu);
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

