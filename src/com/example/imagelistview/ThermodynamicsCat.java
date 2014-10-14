package com.example.imagelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class ThermodynamicsCat extends Activity{
	ListView lv;
    Context context;
 
    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.tc,R.drawable.ht,R.drawable.rhe};
    public static String [] prgmNameList={"Thermal Conductivity","Heat Transfer Rate",
    	"Radient Heat Energy"};
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

}
