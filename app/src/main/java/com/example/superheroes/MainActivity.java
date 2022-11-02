package com.example.superheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private ArrayList<Character> characterArrayList;
    FloatingActionButton refresh_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refresh_button = findViewById(R.id.refresh_button);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        characterArrayList = new ArrayList<>();
        fetchData();
        refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                characterArrayList.clear();
                fetchData();
            }
        });
    }

    public void fetchData()
    {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url="https://superhero-search.p.rapidapi.com/api/heroes";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for(int i=0;i< response.length();i++)
                    {
                        JSONObject basics=response.getJSONObject(i);
                        JSONObject stats=basics.getJSONObject("powerstats");
                        JSONObject appearance=basics.getJSONObject("appearance");
                        JSONArray heightobj=appearance.getJSONArray("height");
                        JSONArray weightobj=appearance.getJSONArray("weight");
                        JSONObject bio=basics.getJSONObject("biography");
                        String name=basics.getString("name");
                        String gender=appearance.getString("gender");
                        String height= String.valueOf(heightobj.get(1));
                        String race=appearance.getString("race");
                        String weight= String.valueOf(weightobj.get(1));
                        String hometown=bio.getString("placeOfBirth");
                        String publisher=bio.getString("publisher");
                        String image_url=basics.getJSONObject("images").getString("lg");
                        String intelligence=stats.getString("intelligence");
                        String speed=stats.getString("speed");
                        String power=stats.getString("power");
                        Character character=new Character(name,gender,height,race,weight,hometown,publisher,image_url,intelligence,speed,power);
                        characterArrayList.add(character);
                    }
                    customAdapter = new CustomAdapter(MainActivity.this,characterArrayList);
                    recyclerView.setAdapter(customAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("kala", "Something went wrong");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("X-RapidAPI-Host", "superhero-search.p.rapidapi.com");
                params.put("X-RapidAPI-Key", "d2b52370c3msh581d2f0c63f20c5p1c5db7jsna4ccbd4f7b55");
                return params;
            }
        };
        requestQueue.add(jsonArrayRequest);
    }
}