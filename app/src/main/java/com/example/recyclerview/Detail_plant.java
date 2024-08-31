package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail_plant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_plant);

        ImageView plantimage = findViewById(R.id.plantimage);
        TextView plantname = findViewById(R.id.plantname);
        TextView scientificname = findViewById(R.id.scientificname);
        TextView description = findViewById(R.id.description);
        TextView light = findViewById(R.id.light);
        TextView water = findViewById(R.id.water);
        TextView temperature = findViewById(R.id.temperature);
        TextView plantsize = findViewById(R.id.plantsize);
        TextView potsize = findViewById(R.id.potsize);
        TextView humidity = findViewById(R.id.humidity);
        TextView propagation = findViewById(R.id.propagation);
        TextView location = findViewById(R.id.location);
        TextView toxity = findViewById(R.id.toxity);
        TextView season = findViewById(R.id.season);
        TextView instructions = findViewById(R.id.instructions);
        TextView plantcolor = findViewById(R.id.plantcolor);
        TextView plantfragrance = findViewById(R.id.plantfragrance);
        TextView disease = findViewById(R.id.disease);
        TextView plantcare = findViewById(R.id.plantcare);
        TextView soiltype = findViewById(R.id.soiltype);
        TextView maintenancelevel = findViewById(R.id.maintenancelevel);
        TextView lifetime = findViewById(R.id.lifetime);
        TextView growthrate = findViewById(R.id.growthrate);


        Intent intent=getIntent();



        plantname.setText(intent.getStringExtra(""));



        scientificname.setText(intent.getStringExtra("scientificname"));
        description.setText(intent.getStringExtra("description"));
        light.setText(intent.getStringExtra("light"));
        water.setText(intent.getStringExtra("water"));
        temperature.setText(intent.getStringExtra("temperature"));
        plantsize.setText(intent.getStringExtra("plantsize"));
        potsize.setText(intent.getStringExtra("potsize"));
        humidity.setText(intent.getStringExtra("humidity"));
        propagation.setText(intent.getStringExtra("propagation"));
        location.setText(intent.getStringExtra("location"));
        toxity.setText(intent.getStringExtra("toxity"));
        season.setText(intent.getStringExtra("season"));
        instructions.setText(intent.getStringExtra("instructions"));
        plantcolor.setText(intent.getStringExtra("plantcolor"));
        plantfragrance.setText(intent.getStringExtra("plantfragrance"));
        disease.setText(intent.getStringExtra("disease"));
        plantcare.setText(intent.getStringExtra("plantcare"));
        soiltype.setText(intent.getStringExtra("soiltype"));
        maintenancelevel.setText(intent.getStringExtra("maintenancelevel"));
        lifetime.setText(intent.getStringExtra("lifetime"));
        growthrate.setText(intent.getStringExtra("growthrate"));







    }


}