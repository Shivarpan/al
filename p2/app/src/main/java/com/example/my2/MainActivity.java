package com.example.my2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    LinearLayout l;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.men,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"selected"+item.getTitle(),Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.men,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"selected"+item.getTitle(),Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button) findViewById(R.id.btn);
        l=(LinearLayout) findViewById(R.id.lin);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText("view");
                l.addView(tv);
                registerForContextMenu(b);
                String animals[]={"lion","tiger"};
                ListView listan =(ListView)findViewById(R.id.lst);
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.list,R.id.textView,animals);
                listan.setAdapter(arrayAdapter);

            }
        });
       Button pod= (Button) findViewById(R.id.btn2);
               pod.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       ProgressDialog  progressDialog = new ProgressDialog(MainActivity.this);
                       progressDialog.setTitle("progress");
                       progressDialog.setMessage("downloading..");
                       progressDialog.show();
                   }
               });
       Button alt=(Button) findViewById(R.id.btn3);
              alt.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      AlertDialog.Builder  alertDialog = new AlertDialog.Builder(MainActivity.this);
                      alertDialog.setTitle("alert");
                      alertDialog.show();
                      alertDialog.setMessage("back");
                  }
              });

    }
}
