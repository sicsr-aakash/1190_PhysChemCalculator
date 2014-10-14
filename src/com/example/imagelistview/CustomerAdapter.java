package com.example.imagelistview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class CustomerAdapter extends BaseAdapter{
    String [] result;
    Context context;
 int [] imageId;
      private static LayoutInflater inflater=null;
    public CustomerAdapter(Context context, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        imageId=prgmImages;
        this.context=context;
         inflater = ( LayoutInflater )context.
                 getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }
 
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }
 
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
 
    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;       
             rowView = inflater.inflate(R.layout.program_list, null,false);
             holder.tv=(TextView) rowView.findViewById(R.id.textView1);
             holder.img=(ImageView) rowView.findViewById(R.id.imageView1);      
         holder.tv.setText(result[position]);
         holder.img.setImageResource(imageId[position]);        
         rowView.setOnClickListener(new OnClickListener() {        
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            	if(result[position].equals("Physics")){
            	    	Intent intent = new Intent(v.getContext(),PhysicsCategory.class);
            	    	//intent.putExtra("chartLink", "Physics");
            	        v.getContext().startActivity(intent);
    				
            	}
            	if(result[position].equals("Classical Physics")){
        	    	Intent intent = new Intent(v.getContext(),ClassicalPhysicsCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Fluid Mechanics")){
        	    	Intent intent = new Intent(v.getContext(),FluidMechCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Thermodynamics")){
        	    	Intent intent = new Intent(v.getContext(),ThermodynamicsCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Electromagnetism")){
        	    	Intent intent = new Intent(v.getContext(),ElectroMagnetCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Geophysics")){
        	    	Intent intent = new Intent(v.getContext(),GeophysicsCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Chemistry")){
        	    	Intent intent = new Intent(v.getContext(),ChemistryCategory.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Atomic Structure")){
        	    	Intent intent = new Intent(v.getContext(),AtomicStructCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Molecular Chemistry")){
        	    	Intent intent = new Intent(v.getContext(),MolecularChemCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Thermo Chemistry")){
        	    	Intent intent = new Intent(v.getContext(),ThermoChemCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Gas Liquid & Solution")){
        	    	Intent intent = new Intent(v.getContext(),GasLiquidCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Acid & Base")){
        	    	Intent intent = new Intent(v.getContext(),AcidBaseCat.class);
        	    	//intent.putExtra("chartLink", "Physics");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Force")){
        	    	Intent intent = new Intent(v.getContext(),Force.class);
        	    	intent.putExtra("rows", "3");
        	    	intent.putExtra("cols", "3");
        	        v.getContext().startActivity(intent);
				
            	}
            	
            	if(result[position].equals("Work")){
        	    	Intent intent = new Intent(v.getContext(),Work.class);
        	    	intent.putExtra("rows", "3");
        	    	intent.putExtra("cols", "3");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Power With Work")){
        	    	Intent intent = new Intent(v.getContext(),PowerWithWork.class);
        	    	intent.putExtra("rows", "3");
        	    	intent.putExtra("cols", "3");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Power With Displacement")){
        	    	Intent intent = new Intent(v.getContext(),PowerWithDis.class);
        	    	intent.putExtra("rows", "4");
        	    	intent.putExtra("cols", "3");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Power With Velocity")){
            		String label[]={"Power","Force","Velocity"};
            		String units[]={"Watt","Newton","m/sec^2"};
        	    	Intent intent = new Intent(v.getContext(),GeneralClass.class);
        	    	intent.putExtra("rows", "3");
        	    	intent.putExtra("cols", "3");
        	    	intent.putExtra("formula", "Power = Force X Velocity");
        	    	intent.putExtra("label", label);
        	    	intent.putExtra("units", units);
        	    	intent.putExtra("cal", "PWV");
        	        v.getContext().startActivity(intent);
				
            	}
            	if(result[position].equals("Potential Energy")){
            		String label[]={"PE","Mass","Acceleration","Height"};
            		String units[]={"Joule","Kg","m/sec^2","meter"};
        	    	Intent intent = new Intent(v.getContext(),GeneralClass.class);
        	    	intent.putExtra("rows", "4");
        	    	intent.putExtra("cols", "3");
        	    	intent.putExtra("formula", "PE = Mass X Acc X Height");
        	    	intent.putExtra("label", label);
        	    	intent.putExtra("units", units);
        	    	intent.putExtra("cal", "PE");
        	        v.getContext().startActivity(intent);
				
            	}
            	if (result[position].equals("Kinetic Energy")) {
					String label[] = { "KE", "Mass", "Velocity" };
					String units[] = { "Joule", "Kg", "m/sec^2"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "KE=1/2XMassX Velocity^2");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "KE");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Velocity")) {
					String label[] = { "Velocity", "Distance", "Time" };
					String units[] = { "m/sec^2", "Meter", "sec"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Velocity = Distance / Time");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "Vel");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Displacement")) {
					String label[] = { "Velocity", "Distance", "Time" };
					String units[] = { "m/sec^2", "Meter", "sec"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Velocity = Distance / Time");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "Vel");

					v.getContext().startActivity(intent);

				}

            	if (result[position].equals("Specific Gravity With Water Weight")) {
					String label[] = { "SG","OAW","EVW"};
					String units[] = { "kg/liter","kg","liter"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Specific gravity=Object in air weight/Equal volume of water weight");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "SGW");

					v.getContext().startActivity(intent);
				}
            	
            	if (result[position].equals("Rectangular Wier")) {
					String label[] = { "Flow Rate(q)","Wier Width(b)","Wier Head(h)","Dis Const"};
					String units[] = { "meter/sec^2", "meter", "meter","Const"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "q=2/3 *cd*b*(2*g)^1/2*(h)^3/2 where g=9.8m/sec^2");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "RWi");

					v.getContext().startActivity(intent);

            	}
            	if (result[position].equals("Flow Rate")) {
					String label[] = { "Flow Rate","Velocity","Area"};
					String units[] = { "meter^3/sec", "meter/sec", "meter^2" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Flow Rate= Velocity X Area");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "FR");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Fluid Pressure")) {
					String label[] = { "Pressure","Force","Area"};
					String units[] = { "Newton/meter^2", "Newton", "meter^2" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Pressure= Force / Area");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "FP");

					v.getContext().startActivity(intent);
            	}
            	if (result[position].equals("Absolute Pressure")) {
					String label[] = { "Abs Pressure", "Gauge Pressure","Atmos pressure"};
					String units[] = {"Newton/meter^2","Newton/meter^2","Newton/meter^2"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Absolute Pressure=Gauge Pressure + Atmostpheric pressure");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "AB");

					v.getContext().startActivity(intent);
				}
            	if (result[position].equals("Specific Volume")) {
					String label[] = {"Density","Specific Volume"};
					String units[] = {"Kg/meter^3","Meter^3/kg" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "2");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Specific Volume=1/Density");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "sv");

					v.getContext().startActivity(intent);
            	}
            	if (result[position].equals("Bulk Modulus")) {
					String label[] = {"Bulk-Modulus", "Pressure", "Initial-Vol","Change in Vol"};
					String units[] = {"Newton/meter^2","Newton/meter^2","Newton/meter^3","meter^3"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Bulk-Modulus=Pressure * (Initial-Vol/Change in Vol)");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "BM");

					v.getContext().startActivity(intent);
            	}
            	if (result[position].equals("Thermal Conductivity")) {
					String label[] = { "Flux(qx)" ,"Const(Kt)","Temp Diff(T)","Distance(x)"};
					String units[] = { "cal/cm^2-sec", "Const", "cal/deg-cm-sec","cm"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "qx= Kt * (T/x)");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "TC");

					v.getContext().startActivity(intent);
            	}
            	if (result[position].equals("Heat Transfer Rate")) {
					String label[] = { "Heat Rate(qx)" ,"Const(Kt)","Temp Diff(T)","Distance(x)"};
					String units[] = { "cal/cm^2-sec", "Const", "cal/deg-cm-sec","cm"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "qx= Kt * (T/x)");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "TC");

					v.getContext().startActivity(intent);
            	}
            	if (result[position].equals("Radient Heat Energy")) {
					String label[] = {"RadiantEg(E)", "AbsTemp(T)"};
					String units[] = { "Joule","Kelvin"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "2");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Radiant Energy(E) = SC * (T^4) where SC=Stefan Constant=5.67 X 10^-8, T in Kelvin");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "RHE");

					v.getContext().startActivity(intent);
            	}
            	if (result[position].equals("Ohm's Law Power")) {
					String label[] = { "Power", "Current","Resistance" };
					String units[] = { "Watt", "Ampere", "Ohm" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Power=(Current^2)*Resistance");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "OLP");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Ohm's Law Voltage")) {
					String label[] = { "Voltage(V)", "Current(I)","Resistance(R)" };
					String units[] = { "Volt", "Amp", "Ohm" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "V =I * R");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "OLV");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Ohm's Law Current")) {
					String label[] = { "Voltage(V)", "Current(I)","Resistance(R)" };
					String units[] = { "Volt", "Amp", "Ohm" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "V =I * R");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "OLV");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Ohm's Law Resistence")) {
					String label[] = { "Voltage(V)", "Current(I)","Resistance(R)" };
					String units[] = { "Volt", "Amp", "Ohm" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "V =I * R");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "OLV");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Capacitance")) {
					String label[] = {"Capacitence", "Charge", "Voltage"};
					String units[] = { "Farad", "Coulomb", "Volt" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Capacitence = Charge / Voltage");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "Capacit");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Inductance")) {
					String label[] = {"Voltage(v)","Inductance(L)", "Current(di)","Time(dt)"};
					String units[] = { "Volt", "Hendry", "Sec","Amp" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "v=L*(di/dt)");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "Induct");

					v.getContext().startActivity(intent);
				}
            	if (result[position].equals("AC To DC Convertion")) {
					String label[] = { "AC","DC"};
					String units[] = { "Amp", "Amp" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "2");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "AC= DC / 0.636");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "ACDC");

					v.getContext().startActivity(intent);
				}
            	if (result[position].equals("Orbit Speed Calculation")) {
					String label[] = { "Orbit Speed", "axis-length(a)","Time Period(T)" };
					String units[] = { "Km/hr","Km", "Hr" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Orbit Speed=2 X PI X a/T where PI=3.142");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "Osc");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Luminosity Of Star")) {
					String label[] = { "Luminosity(L)", "Distance(d)","Brightness(b)" };
					String units[] = { "Watt", "meter", "Watt/meter^2" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "L=4 X PI X(d*d) X b where PI=3.142");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "los");

					v.getContext().startActivity(intent);
				}
            	
            	if (result[position].equals("Ideal Gas Law")) {
					String label[] = { "Pressure(P)", "Volume(V)", "No of Mole(n)", "Temp{T}" };
					String units[] = { "Pascal", "Meter^3","mol", "Kelvin"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "PV=nRT where R=8.314 J K^-1 mol^-1");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "IGL");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Boyle's Law")) {
					String label[] = { "Init Press(P1)", "Int Vol(V1)","Final Press(P2)", "Final Vol(V2)"};
					String units[] = { "Pascal", "meter^3","Pascal", "meter^3"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "P1 X V1=P2 X V2");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "BL");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Charle's Law")) {
					String label[] = {"Int Vol(V1)", "Int Temp(T1)","Final Vol(V2)", "Final Temp(T2)"};
					String units[] = {"Meter^3", "Kelvin","Meter^3", "Kelvin" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "V1/T1=V2/T2");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "CL");

					v.getContext().startActivity(intent);

            	}
            	if (result[position].equals("Gay-Lussac's Law")) {
					String label[] = {"Int Pre(P1)", "Int Temp(T1)","Final Pre(P2)", "Final Temp(T2)"};
					String units[] = {"Pascal", "Kelvin","Pascal", "Kelvin" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "4");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "P1/T1=P2/T2");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "CL");

					v.getContext().startActivity(intent);

            	}
            	if (result[position].equals("Combined Gas Law")) {
					String label[] = {"Int Pre(P1)", "Int Vol(V1)","Int Temp(T1)","Final Pre(P2)","Final Vol(V2)", "Final Temp(T2)"};
					String units[] = {"Pascal","meter^3","Kelvin","Pascal","meter^3", "Kelvin" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "6");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "P1*V1/T1=P2*V2/T2");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "CGLaw");

					v.getContext().startActivity(intent);

            	}
            	if (result[position].equals("Vapour Density Of A Gas")) {
					String label[] = {"VD","DG", "DH",};
					String units[] = { "const","kg/m3","kg/m3" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula",
							"VapourOfDensity(VD)=Density of gas(DG) / Density of Hydrogen(DH)");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "VDG");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Atomic Weight")) {
					String label[] = {"Atomic Wt","Mass Of Pro", "Mass of Neu",};
					String units[] = { "kg","kg","kg" };

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula",
							"Atomic Weight=Mass of Proton + Mass of Neutron");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "AWt");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Speed")) {
					String label[] = { "Velocity", "Distance", "Time" };
					String units[] = { "m/sec^2", "Meter", "sec"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Speed = Distance / Time");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "Vel");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Energy Of Proton")) {
					String label[] = { "Energy of P", "No of Proton", "Frequency" };
					String units[] = { "Joule", " ", "Hertz"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Energy of Proton = No of Proton * Frequency * h where"
							+ "h=planck constant=6.62606957 × 10^-34 m^2 kg / s");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "EOP");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Atoms To Moles")) {
					String label[] = {"Mole","Atom"};
					String units[] = {" ", " "};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "2");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Mole = Atom * 6.0221415E+23");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "ATM");

					v.getContext().startActivity(intent);

				}
            	if (result[position].equals("Molecular Mass Using Gram-molecular Volume Law")) {
					String label[] = {"Molecular Mass","Vapour Density"};
					String units[] = {"g/mol", "g/cm3"};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "2");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Moleular Mass = 2 X Vapour Density");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "MMU");

					v.getContext().startActivity(intent);

				}
            	
            	if (result[position].equals("Acid Weight")) {
					String label[] = {"Acid Weight","Molecular Wt","Basicity"};
					String units[] = {"g/mol", "g/mol"," "};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Acid Weight = Molecular Weight / Basicity");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "AcidWT");

					v.getContext().startActivity(intent);

				}

            	if (result[position].equals("Equivalent Mass Of Acid")) {
					String label[] = {"Equi Mass","Mole Mass","No of H+"};
					String units[] = {"g/mol", "g/mol"," "};

					Intent intent = new Intent(v.getContext(),
							GeneralClass.class);
					intent.putExtra("rows", "3");
					intent.putExtra("cols", "3");
					intent.putExtra("formula", "Equivalent Mass = Molecular Mass / No of H+");
					intent.putExtra("label", label);
					intent.putExtra("units", units);
					intent.putExtra("cal", "AcidWT");

					v.getContext().startActivity(intent);

				}

            	
            	

            	
            	

            	
            }
        }); 
        return rowView;
    }
 
}
