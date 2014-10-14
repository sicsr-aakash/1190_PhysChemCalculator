package com.example.imagelistview;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;


public class Force extends ActionBarActivity{
	public TableLayout table_layout;
	public LinearLayout linear_layout;
	public TableRow row;
	public TextView force,formula;
	public EditText forceedit;
	public String name[]={"Force","Mass","Accelaration"};
	public int no_of_rows,no_of_cols;
	public String rows,cols;
	int flag=1;
	Button b1;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
         rows= extras.getString("rows");
         cols= extras.getString("cols");
         if (rows!= null && cols !=null) {
              no_of_rows=Integer.parseInt(rows);
              no_of_cols=Integer.parseInt(cols);
              }    
        }
   setContentView(R.layout.common_layout);
   table_layout = (TableLayout) findViewById(R.id.tableLayout1);
   table_layout.removeAllViews();
   BuildTable(no_of_rows, no_of_cols);
   linear_layout=(LinearLayout)findViewById(R.id.lin_lay);
   //linear_layout.removeAllViews();
   BuildLinear("Formula :","Force = Mass X Accelaration");
   //Button b2=(Button)findViewById(9);
   
     
    }
	
	private void BuildLinear(String label,String formula){
		TextView t1=(TextView)findViewById(R.id.rowno_id);
		t1.setText(label);
		TextView t2=(TextView)findViewById(R.id.colno_id);
		t2.setText(formula);
	}
	
	 private void BuildTable(final int rows, int cols) {

		  // outer for loop
		 int k=0;
		 
		  for (int i = 1; i <= rows; i++) {

		   TableRow row = new TableRow(this);
		   row.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				      LayoutParams.WRAP_CONTENT));
		   // inner for loop
		   
		   //for (int j = 1; j <= cols; j++) {

			   
			   if(k<=name.length){
		    TextView tv = new TextView(this);
		    tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
		    	      LayoutParams.WRAP_CONTENT));
	   
		    tv.setPadding(5, 5, 5, 5);
		    tv.setTextColor(Color.parseColor("#FFA500"));
		    tv.setText(name[k]);
		    row.addView(tv);
		    
		    final EditText ev = new EditText(this);
		    ev.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
		    	      LayoutParams.MATCH_PARENT));
		    ev.setId(i);
		    ev.setPadding(5, 5, 5, 5);
		    ev.setTextSize(10);
		    ev.setTextColor(Color.parseColor("#FFA500"));
		    ev.setHint("Enter SI value of "+name[k]);
		    ev.setFocusable(false);
		    ev.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_NUMBER_FLAG_SIGNED);
		
		    row.addView(ev);
		   CheckBox rb = new CheckBox(this);
		    rb.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
		    	      LayoutParams.WRAP_CONTENT));
		    rb.setTextSize(10);
		    
		    rb.setTextColor(Color.parseColor("#FFA500"));
		    rb.setPadding(5, 5, 5, 5);
		    
		
		    row.addView(rb);
		    rb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					
					if(isChecked == true){
						
						if(flag<rows)
							
						{
							flag++;
					    ev.setFocusableInTouchMode(true);
					    ev.setFocusable(true);
						}
						else{
							buttonView.setChecked(false);	
						}
					}else{
						flag--;
					    ev.setFocusableInTouchMode(false);
					    ev.setFocusable(false);
					    ev.setText(" ");
					    
					}
					
				}
			});	
		    k++;
			 //  }
			   
			     

		   }

		   table_layout.addView(row);

		  }
		   TableRow row1 = new TableRow(this);
		   row1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				      LayoutParams.WRAP_CONTENT));
		   
		   b1=new Button(this);
		   b1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,	
				      LayoutParams.MATCH_PARENT));
		   b1.setId(9);
		   b1.setText("Find Result");
		   b1.setBackgroundColor(Color.parseColor("#FFA500"));
		   row1.addView(b1);
		   table_layout.addView(row1);
		   b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Log.e("onclick","null");
					TextView res=(TextView)findViewById(R.id.result);
					EditText e1=(EditText)findViewById(1);
					Log.e("EI value","True"+e1.toString());
					EditText e2=(EditText)findViewById(2);
					EditText e3=(EditText)findViewById(3);
					String field1=e1.getText().toString();
					String field2=e2.getText().toString();
					String field3=e3.getText().toString();
					if(field1.trim().equals("")){
						
						double mass=Double.parseDouble(field2);
						double acc=Double.parseDouble(field3);
						double force=mass*acc;
						e1.setText(String.valueOf(force));
						res.setText("Resultant Force: "+String.valueOf(force)+" Newton");
						Log.e("Hello","null"+force);
					}
					if(field2.trim().equals("")){
						
						double force=Double.parseDouble(field1);
						double acc=Double.parseDouble(field3);
						if(acc==0){
							Toast.makeText(getApplicationContext(), "Acceleration Can't be Zero", Toast.LENGTH_SHORT).show();
							}
						else{
						double mass=force/acc;
						e2.setText(String.valueOf(mass));
						res.setText("Resultant Mass: "+String.valueOf(mass)+" Kilogram");
						Log.e("Hello","null"+mass);
						}
					}
					if(field3.trim().equals("")){
						
						double force=Double.parseDouble(field1);
						double mass=Double.parseDouble(field2);
						if(mass==0){
							Toast.makeText(getApplicationContext(), "Mass Can't be Zero", Toast.LENGTH_SHORT).show();
							}
						else{
						double acc=force/mass;
						e3.setText(String.valueOf(acc));
						res.setText("Resultant Accelaration: "+String.valueOf(acc)+" m/sec^2");
						Log.e("Hello","null"+acc);
						}
					}
				}
			});
			
		  
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
