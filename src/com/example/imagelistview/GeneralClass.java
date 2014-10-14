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


public class GeneralClass extends ActionBarActivity{
	public TableLayout table_layout;
	public LinearLayout linear_layout;
	public TableRow row;
	public TextView force,formula;
	public EditText forceedit;
	public String formula1=new String();
	public String cal=new String();
	public String []name=new String[10];
	public String []units=new String[10];
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
         cal= extras.getString("cal");
         name=extras.getStringArray("label");
         units=extras.getStringArray("units");
         formula1=extras.getString("formula");
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
   BuildLinear("Formula :",formula1);
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
					String []field=new String[rows+1];
					EditText []e=new EditText[rows+1];
					for(int i=1;i<=rows;i++){
						
						e[i]=(EditText)findViewById(i);
						field[i]=e[i].getText().toString();
					}
					switch(cal){
					case "PWV": 
					//EditText e1=((EditText)findViewById(1)).getText().;
						
									if(field[1].trim().equals("")){
						
									double force=Double.parseDouble(field[2]);
								
									
									double dis=Double.parseDouble(field[3]);
					
									double power=force*dis;
									e[1].setText(String.valueOf(power));
									res.setText("Resultant "+name[0]+": "+String.valueOf(power)+""+units[0]);
									Log.e("Hello","null"+power);
						
									}
									if(field[2].trim().equals("")){
						
										double power=Double.parseDouble(field[1]);
										double dis=Double.parseDouble(field[3]);
						
										if(dis==0){
										Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
										}
										else{
										double force=power/dis;
										e[2].setText(String.valueOf(force));
										res.setText("Resultant "+name[1]+": "+String.valueOf(force)+""+units[1]);
										Log.e("Hello","null"+force);
										}
									}
									if(field[3].trim().equals("")){
						
										double power=Double.parseDouble(field[1]);
										double force=Double.parseDouble(field[2]);
						
										if(force==0){
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
										}
										else{
											double dis=power/force;
											e[3].setText(String.valueOf(dis));
											res.setText("Resultant "+name[2]+": "+String.valueOf(dis)+""+units[2]);
											Log.e("Hello","null"+dis);
										}
									}
									break;
					case "PE": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double mass=Double.parseDouble(field[2]);
										double acc=Double.parseDouble(field[3]);
										
										double hi=Double.parseDouble(field[4]);
						
										double pe=mass*acc*hi;
										e[1].setText(String.valueOf(pe));
										res.setText("Resultant "+name[0]+": "+String.valueOf(pe)+""+units[0]);
										Log.e("Hello","null"+pe);
							
										}
										if(field[2].trim().equals("")){
							
											double pe=Double.parseDouble(field[1]);
											double acc=Double.parseDouble(field[3]);
											
											double hi=Double.parseDouble(field[4]);
							
											if(acc==0 || hi==0){
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double mass=pe/(acc*hi);
											e[2].setText(String.valueOf(mass));
											res.setText("Resultant "+name[1]+": "+String.valueOf(mass)+""+units[1]);
											Log.e("Hello","null"+mass);
											}
										}
										if(field[3].trim().equals("")){
							
											double pe=Double.parseDouble(field[1]);
											double mass=Double.parseDouble(field[2]);
											
											double hi=Double.parseDouble(field[4]);
							
											if(mass==0 || hi==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double acc=pe/(mass*hi);;
												e[3].setText(String.valueOf(acc));
												res.setText("Resultant "+name[2]+": "+String.valueOf(acc)+""+units[2]);
												Log.e("Hello","null"+acc);
											}
										}
										if(field[4].trim().equals("")){
											
											double pe=Double.parseDouble(field[1]);
											double mass=Double.parseDouble(field[2]);
											
											double acc=Double.parseDouble(field[3]);
							
											if(mass==0 || acc==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double hi=pe/(mass*acc);;
												e[3].setText(String.valueOf(hi));
												res.setText("Resultant "+name[2]+": "+String.valueOf(hi)+""+units[2]);
												Log.e("Hello","null"+hi);
											}
										}

										break;
										
					case "KE": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double M=Double.parseDouble(field[2]);
									
										
										double V=Double.parseDouble(field[3]);
						
										double KE=1/2*M*(V*V);
										e[1].setText(String.valueOf(KE));
										res.setText("Resultant "+name[0]+": "+String.valueOf(KE)+""+units[0]);
										Log.e("Hello","null"+KE);
							
										}
										if(field[2].trim().equals("")){
							
											double KE=Double.parseDouble(field[1]);
											double V=Double.parseDouble(field[3]);
							
											if(V==0) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double M=2*KE/(V*V);
											e[2].setText(String.valueOf(M));
											res.setText("Resultant "+name[1]+": "+String.valueOf(M)+""+units[1]);
											Log.e("Hello","null"+M);
											}
										}
										if(field[3].trim().equals("")){
							
											double KE=Double.parseDouble(field[1]);
											double M=Double.parseDouble(field[2]);
							
											if(M==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double V=Math.sqrt((2*KE)/M);;
												e[3].setText(String.valueOf(V));
												res.setText("Resultant "+name[2]+": "+String.valueOf(V)+""+units[2]);
												Log.e("Hello","null"+V);
											}
										}
										break;	
					case "Vel": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double D=Double.parseDouble(field[2]);
									
										
										double T=Double.parseDouble(field[3]);
						
										if(T==0) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
										else{
										double V=D/T;
										e[1].setText(String.valueOf(V));
										res.setText("Resultant "+name[0]+": "+String.valueOf(V)+""+units[0]);
										Log.e("Hello","null"+V);
										}
										}
										if(field[2].trim().equals("")){
							
											double V=Double.parseDouble(field[1]);
											double T=Double.parseDouble(field[3]);
					
											double D=V*T;
											e[2].setText(String.valueOf(D));
											res.setText("Resultant "+name[1]+": "+String.valueOf(D)+""+units[1]);
											Log.e("Hello","null"+D);
											
										}
										if(field[3].trim().equals("")){
							
											double V=Double.parseDouble(field[1]);
											double D=Double.parseDouble(field[2]);
							
											if(V==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double T=D/V;
												e[3].setText(String.valueOf(T));
												res.setText("Resultant "+name[2]+": "+String.valueOf(T)+""+units[2]);
												Log.e("Hello","null"+T);
											}
										}
										break;	
					case "SGW": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double obj=Double.parseDouble(field[2]);
									
										
										double evw=Double.parseDouble(field[3]);
										if(evw==0){
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
										}
										else{
										double Sgo=obj/evw;
										e[1].setText(String.valueOf(Sgo));
										res.setText("Resultant "+name[0]+": "+String.valueOf(Sgo)+""+units[0]);
										Log.e("Hello","null"+Sgo);
										}
										}
										if(field[2].trim().equals("")){
							
											double Sgo=Double.parseDouble(field[1]);
											double evw=Double.parseDouble(field[3]);
							
											
											
											double obj=Sgo*evw;
											e[2].setText(String.valueOf(obj));
											res.setText("Resultant "+name[1]+": "+String.valueOf(obj)+""+units[1]);
											Log.e("Hello","null"+obj);
											
										}
										if(field[3].trim().equals("")){
							
											double Sgo=Double.parseDouble(field[1]);
											double obj=Double.parseDouble(field[2]);
							
											if(Sgo==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double evw=obj/Sgo;
												e[3].setText(String.valueOf(evw));
												res.setText("Resultant "+name[2]+": "+String.valueOf(evw)+""+units[2]);
												Log.e("Hello","null"+evw);
											}
										}
										break;
											
					case "RWi": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double b=Double.parseDouble(field[2]);
									
										
										double h=Double.parseDouble(field[3]);
						
										double c=Double.parseDouble(field[4]);
										
										double  q=(2*c*b*(Math.sqrt(2*9.8))*Math.sqrt(h*h*h))/3;
										e[1].setText(String.valueOf(q));
										res.setText("Resultant "+name[0]+": "+String.valueOf(q)+""+units[0]);
										Log.e("Hello","null"+ q);
							
										}
										if(field[2].trim().equals("")){
							
											double q=Double.parseDouble(field[1]);
											
											
											double h=Double.parseDouble(field[3]);
							
											double c=Double.parseDouble(field[4]);
											
											if( c==0 || h==0) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double b=3*q/(2*c*Math.sqrt(2*9.8)*Math.sqrt(h*h*h));
											e[2].setText(String.valueOf(b));
											res.setText("Resultant "+name[1]+": "+String.valueOf(b)+""+units[1]);
											Log.e("Hello","null"+b);
											}
										}
										if(field[3].trim().equals("")){
							
	                                         double q=Double.parseDouble(field[1]);
											
											
											double b=Double.parseDouble(field[2]);
							
											double c=Double.parseDouble(field[4]);
											if(b==0 || c==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double h=Math.cbrt((3*q/(2*c*Math.sqrt(2*9.8)*b))*(3*q/(2*c*Math.sqrt(2*9.8)*b)));
												e[3].setText(String.valueOf(h));
												res.setText("Resultant "+name[2]+": "+String.valueOf(b)+""+units[2]);
												Log.e("Hello","null"+h);
											}
										}
										if(field[4].trim().equals("")){
											
	                                        double q=Double.parseDouble(field[1]);
											
											
											double b=Double.parseDouble(field[2]);
							
											double h=Double.parseDouble(field[3]);
											if(b==0 ||h==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double c=3*q/(2*b*Math.sqrt(2*9.8)*Math.sqrt(h*h*h));
												e[4].setText(String.valueOf(c));
												res.setText("Resultant "+name[3]+": "+String.valueOf(c)+""+units[3]);
												Log.e("Hello","null"+c);
											}
										}
											break;
					case "FR": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double A=Double.parseDouble(field[2]);
									
										
										double V=Double.parseDouble(field[3]);
						
										double Q=A*V;
										e[1].setText(String.valueOf(Q));
										res.setText("Resultant "+name[0]+": "+String.valueOf((Q))+""+units[0]);
										Log.e("Hello","null"+ Q);
							
										}
										if(field[2].trim().equals("")){
							
											double  Q=Double.parseDouble(field[1]);
											double  A=Double.parseDouble(field[3]);
							
											if(A==0) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double V=Q/A;
											e[2].setText(String.valueOf(V));
											res.setText("Resultant "+name[1]+": "+String.valueOf(V)+""+units[1]);
											Log.e("Hello","null"+V);
											}
										}
										if(field[3].trim().equals("")){
							
											double Q=Double.parseDouble(field[1]);
											double V=Double.parseDouble(field[2]);
							
											if(V==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double A=Q/V;
												e[3].setText(String.valueOf(A));
												res.setText("Resultant "+name[2]+": "+String.valueOf(A)+""+units[2]);
												Log.e("Hello","null"+A);
											}
										}
										break;
					case "FP": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double f=Double.parseDouble(field[2]);
									
										
										double a=Double.parseDouble(field[3]);
										if(a==0) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
										else{
										double p=f/a;
										e[1].setText(String.valueOf(p));
										res.setText("Resultant "+name[0]+": "+String.valueOf((p))+""+units[0]);
										Log.e("Hello","null"+ p);
										}
										}
										if(field[2].trim().equals("")){
							
											double  p=Double.parseDouble(field[1]);
											double  a=Double.parseDouble(field[3]);
											
											double f=p*a;
											e[2].setText(String.valueOf(f));
											res.setText("Resultant "+name[1]+": "+String.valueOf(f)+""+units[1]);
											Log.e("Hello","null"+f);
											
										}
										if(field[3].trim().equals("")){
							
											double p=Double.parseDouble(field[1]);
											double f=Double.parseDouble(field[2]);
							
											if(p==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double a=f/p;
												e[3].setText(String.valueOf(a));
												res.setText("Resultant "+name[2]+": "+String.valueOf(a)+""+units[2]);
												Log.e("Hello","null"+a);
											}
										}
										break;
						
					case "AB": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double pg=Double.parseDouble(field[2]);
									
										
										double pat=Double.parseDouble(field[3]);
						
										double pa=pg+pat;
										e[1].setText(String.valueOf(pa));
										res.setText("Resultant "+name[0]+": "+String.valueOf((pa))+""+units[0]);
										Log.e("Hello","null"+ pa);
							
										}
										if(field[2].trim().equals("")){
							
											double  pa=Double.parseDouble(field[1]);
											double  pat=Double.parseDouble(field[3]);
											double pg=pa-pat;;
											e[2].setText(String.valueOf(pg));
											res.setText("Resultant "+name[1]+": "+String.valueOf(pg)+""+units[1]);
											Log.e("Hello","null"+pg);
											
										}
										if(field[3].trim().equals("")){
							
											double pa=Double.parseDouble(field[1]);
											double pg=Double.parseDouble(field[2]);
											double pat=pa-pg;
												e[3].setText(String.valueOf(pat));
												res.setText("Resultant "+name[2]+": "+String.valueOf(pat)+""+units[2]);
												Log.e("Hello","null"+pat);
											
										}
										break;
					case "sv": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double V=Double.parseDouble(field[2]);
										
										if( V==0 ) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
										else{
											double  D=1/V;
										e[1].setText(String.valueOf(D));
										res.setText("Resultant "+name[0]+": "+String.valueOf(D)+""+units[0]);
										Log.e("Hello","null"+D);
										}
										}
										if(field[2].trim().equals("")){
							
											double D=Double.parseDouble(field[1]);
											
											if( D==0 ) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double V=1/D;
											e[2].setText(String.valueOf(V));
											res.setText("Resultant "+name[1]+": "+String.valueOf(V)+""+units[1]);
											Log.e("Hello","null"+V);
											}
										}
								break;
					case "BM": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double P=Double.parseDouble(field[2]);
									
										
										double Vi=Double.parseDouble(field[3]);
						
										double Vc=Double.parseDouble(field[4]);
										if(Vc==0 ) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
										else{
										double  B=P*(Vi/Vc);
										e[1].setText(String.valueOf(B));
										res.setText("Resultant "+name[0]+": "+String.valueOf(B)+""+units[0]);
										Log.e("Hello","null"+ B);
										}
										}
										if(field[2].trim().equals("")){
							
											double B=Double.parseDouble(field[1]);
											
											
											double Vi=Double.parseDouble(field[3]);
							
											double Vc=Double.parseDouble(field[4]);
											
											if(Vi==0) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double P=B*Vc/Vi;
											e[2].setText(String.valueOf(P));
											res.setText("Resultant "+name[1]+": "+String.valueOf(P)+""+units[1]);
											Log.e("Hello","null"+P);
											}
										}
										if(field[3].trim().equals("")){
							
	                                         double B=Double.parseDouble(field[1]);
											
											
											double P=Double.parseDouble(field[2]);
							
											double Vc=Double.parseDouble(field[4]);
											if(P==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double Vi=B*Vc/P;
												e[3].setText(String.valueOf(Vi));
												res.setText("Resultant "+name[2]+": "+String.valueOf(Vi)+""+units[2]);
												Log.e("Hello","null"+Vi);
											}
										}
										if(field[4].trim().equals("")){
											
	                                        double B=Double.parseDouble(field[1]);
											
											
											double P=Double.parseDouble(field[2]);
							
											double Vi=Double.parseDouble(field[3]);
											if(B==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double Vc=P*Vi/B;
												e[4].setText(String.valueOf(Vc));
												res.setText("Resultant "+name[2]+": "+String.valueOf(Vc)+""+units[2]);
												Log.e("Hello","null"+Vc);
											}
										}
									break;
					case "TC": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										
										
										double Kt=Double.parseDouble(field[2]);
						
										double T=Double.parseDouble(field[3]);
										double x=Double.parseDouble(field[4]);
										if(x==0){
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
										}
										else{
											   
										double qx=Kt*(T/x);
										
										e[1].setText(String.valueOf(qx));
										res.setText("Resultant "+name[0]+": "+String.valueOf(qx)+""+units[0]);
										Log.e("Hello","null"+ qx);
										}
										}
										if(field[2].trim().equals("")){
							
											double qx=Double.parseDouble(field[1]);
												
											
											double T=Double.parseDouble(field[3]);
							
											double x=Double.parseDouble(field[4]);
											
											if(T==0) {
											Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double Kt=x*qx/T;
											       
											e[2].setText(String.valueOf(Kt));
											res.setText("Resultant "+name[1]+": "+String.valueOf(Kt)+""+units[1]);
											Log.e("Hello","null"+Kt);
											}
										}
										if(field[3].trim().equals("")){
							
											double qx=Double.parseDouble(field[1]);
																						
											
											double Kt=Double.parseDouble(field[2]);
							
											double x=Double.parseDouble(field[4]);
											if(Kt==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else
											{
												double T=qx*x/Kt;
												e[3].setText(String.valueOf(T));
												res.setText("Resultant "+name[2]+": "+String.valueOf(T)+""+units[2]);
												Log.e("Hello","null"+T);
											}
										}
										if(field[4].trim().equals("")){
											
											double qx=Double.parseDouble(field[1]);
											
											
											double Kt=Double.parseDouble(field[2]);
							
											double T=Double.parseDouble(field[3]);
											if(qx==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
												double x=Kt*T/qx;
												
												e[3].setText(String.valueOf(x));
												res.setText("Resultant "+name[2]+": "+String.valueOf(x)+""+units[2]);
												Log.e("Hello","null"+x);
											}
										}
										break;
						case "RHE": 
						//EditText e1=((EditText)findViewById(1)).getText().;
							
										if(field[1].trim().equals("")){
							
										double T=Double.parseDouble(field[2]);
									
										
						
										double  E=5.67*Math.pow(10,-8)*Math.pow(T,4);
										e[1].setText(String.valueOf(E));
										res.setText("Resultant "+name[0]+": "+String.valueOf((E))+""+units[0]);
										Log.e("Hello","null"+ E);
							
										}
										if(field[2].trim().equals("")){
							
											double  E=Double.parseDouble(field[1]);
											
											double T=Math.sqrt(Math.sqrt(E/(5.67*Math.pow(10,-8))));
											e[2].setText(String.valueOf(T));
											res.setText("Resultant "+name[1]+": "+String.valueOf(T)+""+units[1]);
											Log.e("Hello","null"+T);
											
										}
								break;
						
						case "OLP": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
											if(field[1].trim().equals("")){
								
											double I=Double.parseDouble(field[2]);
										
											
											double R=Double.parseDouble(field[3]);
							
											double Power=(I*I)*R;
											e[1].setText(String.valueOf(Power));
											res.setText("Resultant "+name[0]+": "+String.valueOf( Power)+""+units[0]);
											Log.e("Hello","null"+ Power);
								
											}
											if(field[2].trim().equals("")){
								
												double  power=Double.parseDouble(field[1]);
												double R=Double.parseDouble(field[3]);
								
												if(R==0) {
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
												double I=Math.sqrt(power/R);
												e[2].setText(String.valueOf(I));
												res.setText("Resultant "+name[1]+": "+String.valueOf(I)+""+units[1]);
												Log.e("Hello","null"+I);
												}
											}
											if(field[3].trim().equals("")){
								
												double power=Double.parseDouble(field[1]);
												double I=Double.parseDouble(field[2]);
								
												if(I==0){
													Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
													double R=power/(I*I);
													e[3].setText(String.valueOf(R));
													res.setText("Resultant "+name[2]+": "+String.valueOf(R)+""+units[2]);
													Log.e("Hello","null"+R);
												}
											}
											break;
						case "OLV": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
											if(field[1].trim().equals("")){
								
											double I=Double.parseDouble(field[2]);
										
											
											double R=Double.parseDouble(field[3]);
							
											double V=I*R;
											e[1].setText(String.valueOf( V));
											res.setText("Resultant "+name[0]+": "+String.valueOf(V)+""+units[0]);
											Log.e("Hello","null"+ V);
								
											}
											if(field[2].trim().equals("")){
								
												double  V=Double.parseDouble(field[1]);
												double R=Double.parseDouble(field[3]);
								
												if(R==0) {
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
												double I=V/R;
												e[2].setText(String.valueOf(I));
												res.setText("Resultant "+name[1]+": "+String.valueOf(I)+""+units[1]);
												Log.e("Hello","null"+I);
												}
											}
											if(field[3].trim().equals("")){
								
												double V=Double.parseDouble(field[1]);
												double I=Double.parseDouble(field[2]);
								
												if(I==0){
													Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
													double R=V/I;
													e[3].setText(String.valueOf(R));
													res.setText("Resultant "+name[2]+": "+String.valueOf(R)+""+units[2]);
													Log.e("Hello","null"+R);
												}
											}
											break;
						case "Capacit": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
											if(field[1].trim().equals("")){
								
											double q=Double.parseDouble(field[2]);
										
											
											double v=Double.parseDouble(field[3]);
											if(v==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double C=q/v;
											e[1].setText(String.valueOf(C));
											res.setText("Resultant "+name[0]+": "+String.valueOf(C)+""+units[0]);
											Log.e("Hello","null"+ C);
											}
											}
											if(field[2].trim().equals("")){
								
												double  C=Double.parseDouble(field[1]);
												double  v=Double.parseDouble(field[3]);
								
												double q=C*v;
												e[2].setText(String.valueOf(q));
												res.setText("Resultant "+name[1]+": "+String.valueOf(q)+""+units[1]);
												Log.e("Hello","null"+q);
												
											}
											if(field[3].trim().equals("")){
								
												double C=Double.parseDouble(field[1]);
												double q=Double.parseDouble(field[2]);
								
												if(C==0){
													Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
													double v=q/C;
													e[3].setText(String.valueOf(v));
													res.setText("Resultant "+name[2]+": "+String.valueOf(v)+""+units[2]);
													Log.e("Hello","null"+v);
												}
											}
											break;

						case "Induct": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
											if(field[1].trim().equals("")){
								
											double L=Double.parseDouble(field[2]);
										
											
											double di=Double.parseDouble(field[3]);
							
											double dt=Double.parseDouble(field[4]);
											if(dt==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double v=L*(di/dt);
											e[1].setText(String.valueOf(v));
											res.setText("Resultant "+name[0]+": "+String.valueOf(v)+""+units[0]);
											Log.e("Hello","null"+ v);
											}
											}
											
											if(field[2].trim().equals("")){
								
												double v=Double.parseDouble(field[1]);
												
												
												double di=Double.parseDouble(field[3]);
								
												double dt=Double.parseDouble(field[4]);
												
												if(di==0) {
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
												double L=(v*dt)/di;
												e[2].setText(String.valueOf(L));
												res.setText("Resultant "+name[1]+": "+String.valueOf(L)+""+units[1]);
												Log.e("Hello","null"+L);
												}
											}
											
											if(field[3].trim().equals("")){
								
                                                 double v=Double.parseDouble(field[1]);
												
												
												double L=Double.parseDouble(field[2]);
								
												double dt=Double.parseDouble(field[4]);
												if(L==0){
													Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
													double di=((dt*v)/L);
													e[3].setText(String.valueOf(di));
													res.setText("Resultant "+name[2]+": "+String.valueOf(di)+""+units[2]);
													Log.e("Hello","null"+dt);
												}
											}
											
											if(field[4].trim().equals("")){
												
                                                double v=Double.parseDouble(field[1]);
												
												
												double L=Double.parseDouble(field[2]);
								
												double di=Double.parseDouble(field[3]);
												if(v==0){
													Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
													double dt=((di*L)/v);
													e[4].setText(String.valueOf(dt));
													res.setText("Resultant "+name[2]+": "+String.valueOf(dt)+""+units[2]);
													Log.e("Hello","null"+dt);
												}
											}
										break;

						case "ACDC": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
											if(field[1].trim().equals("")){
								
											double dc=Double.parseDouble(field[2]);
									
											
											double ac=dc/0.636;
											e[1].setText(String.valueOf(ac));
											res.setText("Resultant "+name[0]+": "+String.valueOf(ac)+""+units[0]);
											Log.e("Hello","null"+ ac);
											
											}
											
											if(field[2].trim().equals("")){
								
												double ac=Double.parseDouble(field[1]);
												double dc=0.636*ac;
												e[2].setText(String.valueOf(dc));
												res.setText("Resultant "+name[1]+": "+String.valueOf(dc)+""+units[1]);
												Log.e("Hello","null"+dc);
												
											}
											break;
						case "Osc": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
											if(field[1].trim().equals("")){
								
											double a=Double.parseDouble(field[2]);
										
											
											double T=Double.parseDouble(field[3]);
							
											if(T==0){
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
											}
											else{
											double OrbitSpeed=2*3.142*a/T;
											e[1].setText(String.valueOf(OrbitSpeed));
											res.setText("Resultant "+name[0]+": "+String.valueOf(OrbitSpeed)+""+units[0]);
											Log.e("Hello","null"+OrbitSpeed);
											}
											}
											
											if(field[2].trim().equals("")){
								
												double OrbitSpeed=Double.parseDouble(field[1]);
												double T=Double.parseDouble(field[3]);
								
											
												double a=(OrbitSpeed*T)/(2*3.142);
												e[2].setText(String.valueOf(a));
												res.setText("Resultant "+name[1]+": "+String.valueOf(a)+""+units[1]);
												Log.e("Hello","null"+a);
												
											}
											if(field[3].trim().equals("")){
								
												double OrbitSpeed=Double.parseDouble(field[1]);
												double a=Double.parseDouble(field[2]);
								
												if(OrbitSpeed==0){
													Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
													double T=(2*3.142*a)/OrbitSpeed;
													e[3].setText(String.valueOf(T));
													res.setText("Resultant "+name[2]+": "+String.valueOf(T)+""+units[2]);
													Log.e("Hello","null"+T);
												}
											}
											break;
									
						case "los": 
							
							if(field[1].trim().equals(""))
							{
								
											double d=Double.parseDouble(field[2]);
										
											
											double b=Double.parseDouble(field[3]);
							
											double LuminosityOfStar=4*3.142*(d*d)*b;
											e[1].setText(String.valueOf( LuminosityOfStar));
											res.setText("Resultant "+name[0]+": "+String.valueOf( LuminosityOfStar)+""+units[0]);
											Log.e("Hello","null"+ LuminosityOfStar);
								
											}
											if(field[2].trim().equals("")){
								
												double  L=Double.parseDouble(field[1]);
												double b=Double.parseDouble(field[3]);
								
												if(b==0) {
												Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
												double d=Math.sqrt(L/(4*3.142*b));
												e[2].setText(String.valueOf(d));
												res.setText("Resultant "+name[1]+": "+String.valueOf(d)+""+units[1]);
												Log.e("Hello","null"+d);
												}
											}
											if(field[3].trim().equals("")){
								
												double LuminosityOfStar=Double.parseDouble(field[1]);
												double d=Double.parseDouble(field[2]);
								
												if(d==0){
													Toast.makeText(getApplicationContext(), "Divisor Can't be Zero", Toast.LENGTH_SHORT).show();
												}
												else{
													double b=LuminosityOfStar/(4*3.142*(d*d));
													e[3].setText(String.valueOf(b));
													res.setText("Resultant "+name[2]+": "+String.valueOf(b)+""+units[2]);
													Log.e("Hello","null"+b);
												}
											}
											break;
						case "IGL": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
							if(field[1].trim().equals("")){
								
								double v=Double.parseDouble(field[2]);
								double n=Double.parseDouble(field[3]);
								double T=Double.parseDouble(field[4]);
								
								if(v==0){
								Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
								}
								else{
								double p=(n*8.314*T)/v;
								e[1].setText(String.valueOf(p));
								res.setText("Resultant "+name[0]+": "+String.valueOf(p)+""+units[0]);
								Log.e("Hello","null"+p);
								}
							}
							if(field[2].trim().equals("")){
								
								double p=Double.parseDouble(field[1]);
								double n=Double.parseDouble(field[3]);
								double T=Double.parseDouble(field[4]);
								
								
								if(p==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
									double v=(n*8.314*T)/p;
									e[2].setText(String.valueOf(v));
									res.setText("Resultant "+name[1]+": "+String.valueOf(v)+" "+units[1]);
									Log.e("Hello","null"+v);
								}
							}
							if(field[3].trim().equals("")){
								
								double p=Double.parseDouble(field[1]);
								double v=Double.parseDouble(field[2]);
								double T=Double.parseDouble(field[4]);
								
								
								if(T==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
									double n=(p*v)/(8.314*T);
									e[3].setText(String.valueOf(n));
									res.setText("Resultant "+name[2]+": "+String.valueOf(n)+" "+units[2]);
									Log.e("Hello","null"+n);
								}
							}
							if(field[4].trim().equals("")){
								
								double p=Double.parseDouble(field[1]);
								double v=Double.parseDouble(field[2]);
								double n=Double.parseDouble(field[3]);
						
								
								if(n==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double T=(p*v)/(n*8.314);
								e[4].setText(String.valueOf(T));
								res.setText("Resultant "+name[3]+": "+String.valueOf(T)+" "+units[3]);
								Log.e("Hello","null"+T);
								}
							}
								
							break;					
						case "BL": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
							if(field[1].trim().equals("")){
								
								double v1=Double.parseDouble(field[2]);
								double p2=Double.parseDouble(field[3]);
								double v2=Double.parseDouble(field[4]);
								if(v1==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double p1=(p2*v2)/v1;;
								e[1].setText(String.valueOf(p1));
								res.setText("Resultant "+name[0]+ ": "+String.valueOf(p1)+" "+units[0]);
								Log.e("Hello","null"+p1);
								}
							}
							if(field[2].trim().equals("")){
								
								double p1=Double.parseDouble(field[1]);
								double p2=Double.parseDouble(field[3]);
								double v2=Double.parseDouble(field[4]);
								if(p1==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double v1=(p2*v2)/p1;;
								e[2].setText(String.valueOf(v1));
								res.setText("Resultant "+name[1]+ ": "+String.valueOf(v1)+" "+units[1]);
								Log.e("Hello","null"+v1);
								}
							}
							
							if(field[3].trim().equals("")){
								
								double p1=Double.parseDouble(field[1]);
								double v1=Double.parseDouble(field[2]);
								double v2=Double.parseDouble(field[4]);
								if(v2==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double p2=(p1*v1)/v2;;
								e[3].setText(String.valueOf(p2));
								res.setText("Resultant "+name[2]+ ": "+String.valueOf(p2)+" "+units[2]);
								Log.e("Hello","null"+p2);
								}
							}
							if(field[4].trim().equals("")){
								
								double p1=Double.parseDouble(field[1]);
								double v1=Double.parseDouble(field[2]);
								double p2=Double.parseDouble(field[3]);
								if(p2==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double v2=(p1*v1)/p2;;
								e[4].setText(String.valueOf(v2));
								res.setText("Resultant "+name[3]+ ": "+String.valueOf(v2)+" "+units[3]);
								Log.e("Hello","null"+v2);
								}
							}
							break;
							
						case "CL": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
							if(field[1].trim().equals("")){
								
								double T1=Double.parseDouble(field[2]);
								double v2=Double.parseDouble(field[3]);
								double T2=Double.parseDouble(field[4]);
								if(T2==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double v1=(v2*T1)/T2;
								e[1].setText(String.valueOf(v1));
								res.setText("Resultant "+name[0]+": "+String.valueOf(v1)+" "+units[0]);
								Log.e("Hello","null"+v1);
								}
							}
							if(field[2].trim().equals("")){
								
								double v1=Double.parseDouble(field[1]);
								double v2=Double.parseDouble(field[3]);
								double T2=Double.parseDouble(field[4]);
								if(v2==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double T1=(v1*T2)/v2;
								e[2].setText(String.valueOf(T1));
								res.setText("Resultant "+name[1]+": "+String.valueOf(T1)+" "+units[1]);
								Log.e("Hello","null"+T1);
								}
							}
							if(field[3].trim().equals("")){
								
								double v1=Double.parseDouble(field[1]);
								double T1=Double.parseDouble(field[2]);
								double T2=Double.parseDouble(field[4]);
								if(T1==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double v2=(v1*T2)/T1;
								e[3].setText(String.valueOf(v2));
								res.setText("Resultant "+name[2]+": "+String.valueOf(v2)+" "+units[2]);
								Log.e("Hello","null"+v2);
								}
							}
							if(field[4].trim().equals("")){
								
								double v1=Double.parseDouble(field[1]);
								double T1=Double.parseDouble(field[2]);
								double v2=Double.parseDouble(field[3]);
								if(v1==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double T2=(v2*T1)/v1;
								e[4].setText(String.valueOf(T2));
								res.setText("Resultant "+name[3]+": "+String.valueOf(T2)+" "+units[3]);
								Log.e("Hello","null"+T2);
								}
							}
							
							break;

						case "CGLaw": 
							//EditText e1=((EditText)findViewById(1)).getText().;
								
							if(field[1].trim().equals("")){
								
								double v1=Double.parseDouble(field[2]);
								double t1=Double.parseDouble(field[3]);
								double p2=Double.parseDouble(field[4]);
								double v2=Double.parseDouble(field[5]);
								double t2=Double.parseDouble(field[6]);
								if(v1==0||t2==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double p1=(p2*v2*t1)/(v1*t2);
								e[1].setText(String.valueOf(p1));
								res.setText("Resultant "+name[0]+": "+String.valueOf(p1)+" "+units[0]);
								Log.e("Hello","null"+p1);
								}
							}
							if(field[2].trim().equals("")){
								
								double p1=Double.parseDouble(field[1]);
								double t1=Double.parseDouble(field[3]);
								double p2=Double.parseDouble(field[4]);
								double v2=Double.parseDouble(field[5]);
								double t2=Double.parseDouble(field[6]);
								if(p1==0||t2==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double v1=(p2*v2*t1)/(p1*t2);
								e[2].setText(String.valueOf(v1));
								res.setText("Resultant "+name[1]+": "+String.valueOf(v1)+" "+units[1]);
								Log.e("Hello","null"+v1);
								}
							}
							if(field[3].trim().equals("")){
								
								double v1=Double.parseDouble(field[2]);
								double p1=Double.parseDouble(field[1]);
								double p2=Double.parseDouble(field[4]);
								double v2=Double.parseDouble(field[5]);
								double t2=Double.parseDouble(field[6]);
								if(v2==0||p2==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double t1=(p1*v1*t2)/(p2*v2);
								e[3].setText(String.valueOf(t1));
								res.setText("Resultant "+name[2]+": "+String.valueOf(t1)+" "+units[2]);
								Log.e("Hello","null"+t1);
								}
							}
							if(field[4].trim().equals("")){
								
								double v1=Double.parseDouble(field[2]);
								double t1=Double.parseDouble(field[3]);
								double p1=Double.parseDouble(field[1]);
								double v2=Double.parseDouble(field[5]);
								double t2=Double.parseDouble(field[6]);
								if(v2==0||t1==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double p2=(p1*v1*t2)/(v2*t1);
								e[4].setText(String.valueOf(p2));
								res.setText("Resultant "+name[3]+": "+String.valueOf(p1)+" "+units[3]);
								Log.e("Hello","null"+p2);
								}
							}
							if(field[5].trim().equals("")){
								
								double v1=Double.parseDouble(field[2]);
								double t1=Double.parseDouble(field[3]);
								double p1=Double.parseDouble(field[1]);
								double p2=Double.parseDouble(field[4]);
								double t2=Double.parseDouble(field[6]);
								if(p2==0||t1==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double v2=(p1*v1*t2)/(p2*t1);
								e[5].setText(String.valueOf(v2));
								res.setText("Resultant "+name[4]+": "+String.valueOf(v2)+" "+units[4]);
								Log.e("Hello","null"+v2);
								}
							}
							if(field[6].trim().equals("")){
								
								double v1=Double.parseDouble(field[2]);
								double t1=Double.parseDouble(field[3]);
								double p2=Double.parseDouble(field[4]);
								double v2=Double.parseDouble(field[5]);
								double p1=Double.parseDouble(field[1]);
								if(v1==0||p1==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double t2=(p2*v2*t1)/(v1*p1);
								e[6].setText(String.valueOf(t2));
								res.setText("Resultant "+name[5]+": "+String.valueOf(t2)+" "+units[5]);
								Log.e("Hello","null"+t2);
								}
							}
							
					
							break;
						case "VDG": 
							//EditText e1=((EditText)findViewById(1)).getText().;

							
								if(field[1].trim().equals(""))
								{
								double dg=Double.parseDouble(field[2]);
								double dh=Double.parseDouble(field[3]);
								if(dh==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double vd=dg/dh;				
								e[1].setText(String.valueOf(vd));
								res.setText("Resultant "+name[0]+": "+String.valueOf(vd)+" "+units[0]);
								Log.e("Hello","null"+vd);
								}						
								}
								if(field[2].trim().equals(""))
								{
								double vd=Double.parseDouble(field[1]);
								double dh=Double.parseDouble(field[3]);
								
								double dg=vd*dh;				
								e[2].setText(String.valueOf(dg));
								res.setText("Resultant "+name[1]+": "+String.valueOf(dg)+" "+units[1]);
								Log.e("Hello","null"+dg);
														
								}
								if(field[3].trim().equals(""))
								{
								double dg=Double.parseDouble(field[2]);
								double vd=Double.parseDouble(field[1]);
								if(vd==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double dh=dg/vd;				
								e[3].setText(String.valueOf(dh));
								res.setText("Resultant "+name[2]+": "+String.valueOf(dh)+" "+units[2]);
								Log.e("Hello","null"+dh);
								}						
								}

														
							break;
							
						case "AWt": 
							//EditText e1=((EditText)findViewById(1)).getText().;

							
								if(field[1].trim().equals(""))
								{
								double pm=Double.parseDouble(field[2]);
								double nm=Double.parseDouble(field[3]);
								double aw=pm+nm;				
								e[1].setText(String.valueOf(aw));
								res.setText("Resultant "+name[0]+": "+String.valueOf(aw)+" "+units[0]);
								Log.e("Hello","null"+aw);
														
								}
								if(field[2].trim().equals(""))
								{
								double aw=Double.parseDouble(field[1]);
								double nm=Double.parseDouble(field[3]);
								
								double pm=aw-nm;				
								e[2].setText(String.valueOf(pm));
								res.setText("Resultant "+name[1]+": "+String.valueOf(pm)+" "+units[1]);
								Log.e("Hello","null"+pm);
														
								}
								if(field[3].trim().equals(""))
								{
								double pm=Double.parseDouble(field[2]);
								double aw=Double.parseDouble(field[1]);
								
								double nm=aw-pm;				
								e[3].setText(String.valueOf(nm));
								res.setText("Resultant "+name[2]+": "+String.valueOf(nm)+" "+units[2]);
								Log.e("Hello","null"+nm);
														
								}														
							break;
		
						case "EOP": 
							//EditText e1=((EditText)findViewById(1)).getText().;

							
								if(field[1].trim().equals(""))
								{
								double n=Double.parseDouble(field[2]);
								double f=Double.parseDouble(field[3]);
								double eng=n*f*(6.6261*Math.pow(10,-34));				
								e[1].setText(String.valueOf(eng));
								res.setText("Resultant "+name[0]+": "+String.valueOf(eng)+" "+units[0]);
								Log.e("Hello","null"+eng);
								}						
								
								if(field[2].trim().equals(""))
								{
								double eng=Double.parseDouble(field[1]);
								double f=Double.parseDouble(field[3]);
								if(f==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double n=eng/(f*(6.6261*Math.pow(10,-34)));				
								e[2].setText(String.valueOf(n));
								res.setText("Resultant "+name[1]+": "+String.valueOf(n)+" "+units[1]);
								Log.e("Hello","null"+n);
								}						
								}
								if(field[3].trim().equals(""))
								{
								double n=Double.parseDouble(field[2]);
								double en=Double.parseDouble(field[1]);
								if(n==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
									double fe=en/(n*(6.6261*Math.pow(10,-34)));				
								e[3].setText(String.valueOf(fe));
								res.setText("Resultant "+name[2]+": "+String.valueOf(fe)+" "+units[2]);
								Log.e("Hello","null"+fe);
								}						
								}

														
							break;
						case "ATM": 
							//EditText e1=((EditText)findViewById(1)).getText().;

							
								if(field[1].trim().equals(""))
								{
								double a=Double.parseDouble(field[2]);
								
								double m=a*(6.0221415*Math.pow(10,23));				
								e[1].setText(String.valueOf(m));
								res.setText("Resultant "+name[0]+": "+String.valueOf(m)+" "+units[0]);
								Log.e("Hello","null"+m);
								}						
								
								if(field[2].trim().equals(""))
								{
								double m=Double.parseDouble(field[1]);
								
								double a=m/(6.0221415*Math.pow(10,23));				
								e[2].setText(String.valueOf(a));
								res.setText("Resultant "+name[1]+": "+String.valueOf(a)+" "+units[1]);
								Log.e("Hello","null"+a);
														
								}														
							break;
						case "MMU": 
							//EditText e1=((EditText)findViewById(1)).getText().;

							
								if(field[1].trim().equals(""))
								{
								double a=Double.parseDouble(field[2]);
								
								double m=a*2;				
								e[1].setText(String.valueOf(m));
								res.setText("Resultant "+name[0]+": "+String.valueOf(m)+" "+units[0]);
								Log.e("Hello","null"+m);
								}						
								
								if(field[2].trim().equals(""))
								{
								double m=Double.parseDouble(field[1]);
								
								double a=m/2;				
								e[2].setText(String.valueOf(a));
								res.setText("Resultant "+name[1]+": "+String.valueOf(a)+" "+units[1]);
								Log.e("Hello","null"+a);
														
								}														
							break;

						case "AcidWT": 
							//EditText e1=((EditText)findViewById(1)).getText().;

							
								if(field[1].trim().equals(""))
								{
								double em=Double.parseDouble(field[2]);
								double b=Double.parseDouble(field[3]);
								if(b==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
								double aw=em/b;				
								e[1].setText(String.valueOf(aw));
								res.setText("Resultant "+name[0]+": "+String.valueOf(aw)+" "+units[0]);
								Log.e("Hello","null"+aw);
								}						
								}
								if(field[2].trim().equals(""))
								{
								double eng=Double.parseDouble(field[1]);
								double f=Double.parseDouble(field[3]);
								
								double n=eng*f;				
								e[2].setText(String.valueOf(n));
								res.setText("Resultant "+name[1]+": "+String.valueOf(n)+" "+units[1]);
								Log.e("Hello","null"+n);
														
								}
								if(field[3].trim().equals(""))
								{
								double n=Double.parseDouble(field[2]);
								double en=Double.parseDouble(field[1]);
								if(n==0){
									Toast.makeText(getApplicationContext(), "Can't be Zero", Toast.LENGTH_SHORT).show();
									}
								else{
									double fe=n/en;				
								e[3].setText(String.valueOf(fe));
								res.setText("Resultant "+name[2]+": "+String.valueOf(fe)+" "+units[2]);
								Log.e("Hello","null"+fe);
								}						
								}

														
							break;


					
					
							
							
							
							
											
										
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
