package com.example.my1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondAcrivity extends AppCompatActivity {

    TextView d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acrivity);
        Intent i2= getIntent();
        Bundle b = i2.getExtras();
        String n = b.getString(MainActivity.msg).toString();
        d=(TextView) findViewById(R.id.textView);
        d.setText(n);

        Toast.makeText(this,"to second activity",Toast.LENGTH_SHORT).show();
    }
}
