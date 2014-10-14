package com.example.imagelistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutAndMain extends ActionBarActivity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra=getIntent().getExtras();
        if(extra!=null)
        {
        	String name=extra.getString("direct");
        	if(name.equals("about")){
        		setContentView(R.layout.aboutpage);
        	}
        	if(name.equals("main")){
        		setContentView(R.layout.mainscreen);
        		((TextView)findViewById(R.id.textView2)).setText(Html.fromHtml(
        				"1) Install and launch the application.<br/>"
			+"2) Open the application where there are two panels,"
			+" one for Physics and one for Chemistry.<br/>"
			+"3) User can go for either Physics or Chemistry"
			  +" to calculate according to user preference.<br/>"
			+"4) In Physics slot there are 5 major topics"
			  +" and in Chemistry there are 4 major topics.<br/>"
		+"5) When user gets into a particular topic,"
			+"   user can view fields according to the formula."
			  +" Example if Force=Mass * Acceleration,"
			  +" user needs to provide values for either force or"
			  +" mass or acceleration; any two from the above three.<br/>"
			+"6) NOTE: User needs to enter the values by clicking on the checkbox"
			  +" next to the fields.After viewing the result, if the user needs to enter values into the"
			  +" field that is not empty then he is required to uncheck the checkbox associated with the field"
			   +".<br/>  "));
        	}
        }
        else{
        setContentView(R.layout.activity_main);
        }
        
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
