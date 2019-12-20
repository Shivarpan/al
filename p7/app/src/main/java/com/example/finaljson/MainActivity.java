package com.example.finaljson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    Button get;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get=findViewById(R.id.get);
        lv=findViewById(R.id.listview);
        requestQueue= Volley.newRequestQueue(MainActivity.this);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p();
            }
        });

    }
    public void p()
    {
        final ArrayList<String> arrayList=new ArrayList<>();
        String url="https://api.myjson.com/bins/1auz1w";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
            @Override

            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("Employees");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                      JSONObject jsonObject=jsonArray.getJSONObject(i);
                      String id=jsonObject.getString("userId");
                      String email=jsonObject.getString("emailAddress");
                      arrayList.add(id+"\n"+email);
                    }
                    ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.list,R.id.textView,arrayList);
                    lv=findViewById(R.id.listview);
                    lv.setAdapter(arrayAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
