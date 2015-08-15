package com.example.arnav.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    boolean[] price={true,false,false,false,false};
    ImageButton first;
    ImageButton second;
    ImageButton third;
    ImageButton fourth;
    ImageButton fifth;
    double distance_info = 0.5;
    public final static String PRICE_INFO="com.mycompany.travelapp.PRICE_INFO";
    public final static String DISTANCE_INFO="com.mycompany.travelapp.DISTANCE_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (ImageButton) findViewById(R.id.price0);
        second = (ImageButton) findViewById(R.id.price1);
        third = (ImageButton) findViewById(R.id.price2);
        fourth = (ImageButton) findViewById(R.id.price3);
        fifth= (ImageButton) findViewById(R.id.price4);
        Spinner spinner = (Spinner) findViewById(R.id.radius_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.radius_array, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String distance = parent.getItemAtPosition(position).toString();
                distance_info = Double.parseDouble(distance);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void setPriceRange0(View view){
        price= new boolean[]{true, false, false, false, false};
        second.setImageResource(R.drawable.dollarsign);
        third.setImageResource(R.drawable.dollarsign);
        fourth.setImageResource(R.drawable.dollarsign);
        fifth.setImageResource(R.drawable.dollarsign);
    }
    public void setPriceRange1(View view){
        second.setImageResource(R.drawable.dollarsigntrue);
        third.setImageResource(R.drawable.dollarsign);
        fourth.setImageResource(R.drawable.dollarsign);
        fifth.setImageResource(R.drawable.dollarsign);
        price= new boolean[]{true, true, false, false, false};
    }
    public void setPriceRange2(View view){
        price= new boolean[]{true, true, true, false, false};
        second.setImageResource(R.drawable.dollarsigntrue);
        third.setImageResource(R.drawable.dollarsigntrue);
        fourth.setImageResource(R.drawable.dollarsign);
        fifth.setImageResource(R.drawable.dollarsign);
    }
    public void setPriceRange3(View view){
        price= new boolean[]{true, true, true, true, false};
        second.setImageResource(R.drawable.dollarsigntrue);
        third.setImageResource(R.drawable.dollarsigntrue);
        fourth.setImageResource(R.drawable.dollarsigntrue);
        fifth.setImageResource(R.drawable.dollarsign);
    }
    public void setPriceRange4(View view){
        price= new boolean[]{true, false, false, false, false};
        second.setImageResource(R.drawable.dollarsigntrue);
        third.setImageResource(R.drawable.dollarsigntrue);
        fourth.setImageResource(R.drawable.dollarsigntrue);
        fifth.setImageResource(R.drawable.dollarsigntrue);
    }

    public void FindARestaurant(View view){
        int price_count=0;
        for (int i = 0; i<5;i++){
            if (price[i]==true){
                price_count = price_count+1;
            }
        }
        Intent sendInfo = new Intent(this,DisplayRestaurant.class);
        sendInfo.putExtra(PRICE_INFO, price_count);
        sendInfo.putExtra(DISTANCE_INFO, distance_info);
        startActivity(sendInfo);
    }

    public void changeLocation(View view){
        // Should link to map where location can be changed (i.e. pin can be moved around, or address)
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        TextView myText = (TextView) view;
        Toast.makeText(this,"You selected "+myText.getText(),Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
