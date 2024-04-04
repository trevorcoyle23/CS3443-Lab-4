package edu.utsa.cs3443.uhx746_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

import edu.utsa.cs3443.uhx746_lab4.model.CrewMember;
import edu.utsa.cs3443.uhx746_lab4.model.Fleet;
import edu.utsa.cs3443.uhx746_lab4.model.Starship;

public class StarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        // Find the intent and the extra(s) (Registry)
        Intent intent = getIntent();
        String registry = intent.getStringExtra("registry");

        // Create the Fleet
        Fleet fleet = new Fleet("United Federation of Planets");
        Log.d("FLEET CREATED", fleet.toString());

        // Load the Starships into the Fleet
        try {
            fleet.loadStarships(StarshipActivity.this);
            Log.d("FLEET LOADED", fleet.getStarships().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Starship s : fleet.getStarships()) {
            try {
                s.loadCrewMembers(StarshipActivity.this);
                Log.d("CREW MEMBER LOADED", "->" + s.getRegistry());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Starship starship = null;
        starship = fleet.findStarship(registry, fleet.getStarships());
        Log.d("STARSHIP FOUND", starship.toString());

        TextView starshipNameText = findViewById(R.id.starshipName);
        TextView starshipRegistryText = findViewById(R.id.starshipRegistry);

        starshipNameText.setText(starship.getName());
        starshipRegistryText.setText(starship.getRegistry());

        // display the CrewMembers in a Starship based on it's registry
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        LayoutInflater inflater = LayoutInflater.from(this);

        for (CrewMember crewMember : starship.getCrewMembers()) {
            View itemView = inflater.inflate(R.layout.item_layout, linearLayout, false);

            ImageView imageView = itemView.findViewById(R.id.image);
            imageView.setImageResource(crewMember.imageFileName());

            TextView textView = itemView.findViewById(R.id.crewMember);
            textView.setText(crewMember.toString());

            linearLayout.addView(itemView);
        }
    }
}