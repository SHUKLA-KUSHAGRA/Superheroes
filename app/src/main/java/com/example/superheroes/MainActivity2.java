package com.example.superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {
    ImageView image_card;
    TextView name_card;
    TextView gender_card;
    TextView height_card;
    TextView race_card;
    TextView weight_card;
    TextView hometown_card;
    TextView publisher_card;
    TextView intelligence_card;
    TextView speed_card;
    TextView power_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        image_card = findViewById(R.id.image_card);
        name_card = findViewById(R.id.name_card);
        gender_card = findViewById(R.id.gender_card);
        height_card = findViewById(R.id.height_card);
        weight_card = findViewById(R.id.weight_card);
        race_card = findViewById(R.id.race_card);
        hometown_card = findViewById(R.id.hometown_card);
        publisher_card = findViewById(R.id.publicher_card);
        intelligence_card = findViewById(R.id.intelligence_card);
        speed_card = findViewById(R.id.speed_card);
        power_card = findViewById(R.id.power_card);

        Character character=getIntent().getParcelableExtra("Characters");

        Picasso.get().load(character.getImage_url()).resize(400,350).centerCrop().into(image_card);
        name_card.setText(character.getName());
        gender_card.setText(character.getGender());
        height_card.setText(character.getHeight());
        weight_card.setText(character.getWeight());
        race_card.setText(character.getRace());
        hometown_card.setText(character.getHometown());
        publisher_card.setText(character.getPublisher());
        power_card.setText(character.getPower());
        speed_card.setText(character.getSpeed());
        intelligence_card.setText(character.getIntelligence());
    }
}