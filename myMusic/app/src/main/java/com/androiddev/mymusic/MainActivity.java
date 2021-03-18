package com.androiddev.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        Spinner language;
        ArrayAdapter<String> adapter;
        Button plus,minus,addToCart;
        TextView quantity,orderPrice;
        int price;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        language = (Spinner) findViewById(R.id.spinner);
        orderPrice = (TextView) findViewById(R.id.amount);
        quantity = (TextView) findViewById(R.id.quantaty2);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);
        addToCart = (Button) findViewById(R.id.addToCard);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        addToCart.setOnClickListener(this);

        ArrayList<String> lang = new ArrayList<>();
        lang.add("NONE");
        lang.add("Guitar");
        lang.add("Violin");
        lang.add("Piano");
        lang.add("Flute");

        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item,lang);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language.setAdapter(adapter);
        language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int temp;
                switch (position){
                    case 0:
                       price = 0;
                        quantity.setText("0");
                        temp = Integer.parseInt(quantity.getText().toString());
                        orderPrice.setText(String.valueOf(price*temp));
                        break;
                    case 1:
                        price = 100;
                        quantity.setText("1");
                        temp = Integer.parseInt(quantity.getText().toString());
                        orderPrice.setText(String.valueOf(price*temp));
                        break;
                    case 2:
                        price = 200;
                        quantity.setText("1");
                        temp = Integer.parseInt(quantity.getText().toString());
                        orderPrice.setText(String.valueOf(price*temp));
                        break;
                    case 3:
                        price = 1000;
                        quantity.setText("1");
                        temp = Integer.parseInt(quantity.getText().toString());
                        orderPrice.setText(String.valueOf(price*temp));
                        break;
                    case 4:
                        price = 50;
                        quantity.setText("1");
                        temp = Integer.parseInt(quantity.getText().toString());
                        orderPrice.setText(String.valueOf(price*temp));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               price = 0;
                quantity.setText("0");
                orderPrice.setText(String.valueOf(price));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.more:
                Toast.makeText(MainActivity.this,"Going to music cart ! ",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int temp;
        switch (v.getId()){
            case R.id.minus:
                temp = Integer.parseInt(quantity.getText().toString());
                if (temp>0){
                    quantity.setText(String.valueOf(temp-1));
                    temp = Integer.parseInt(quantity.getText().toString());
                    orderPrice.setText(String.valueOf(price*temp));
                }
                break;
            case R.id.plus:
                temp = Integer.parseInt(quantity.getText().toString());
                quantity.setText(String.valueOf(temp+1));
                temp = Integer.parseInt(quantity.getText().toString());
                orderPrice.setText(String.valueOf(price*temp));
                break;
            case R.id.addToCard:
                Toast.makeText(MainActivity.this,"Adding to a cart",Toast.LENGTH_SHORT).show();
        }
    }
}