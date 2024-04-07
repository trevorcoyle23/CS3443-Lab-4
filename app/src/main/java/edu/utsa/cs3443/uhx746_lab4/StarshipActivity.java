package edu.utsa.cs3443.uhx746_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    /**
     * onCreate(Bundle):
     *  - Finds the `Intent` object passed by `MainActivity` (`registry`).
     *  - Creates/initializes a `Fleet` object.
     *  -
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        // Find the intent and the extra(s) (Registry)
        Intent intent = getIntent();
        String registry = intent.getStringExtra("registry");

        // Create the Fleet
        Fleet fleet = new Fleet("United Federation of Planets");

        // Load the Starships into the Fleet
        try {
            fleet.loadStarships(StarshipActivity.this);
        } catch (IOException e) {
            // File not found branch
            e.printStackTrace();
        }

        // For all `Starship` objects in `fleet`, load the `CrewMember` objects into the `Starship` object
        for (Starship s : fleet.getStarships()) {
            try {
                s.loadCrewMembers(StarshipActivity.this);
            } catch (IOException e) {
                // File not found branch
                e.printStackTrace();
            }
        }

        Starship starship;
        starship = fleet.findStarship(registry, fleet.getStarships());

        // TextViews
        TextView starshipNameText = findViewById(R.id.starshipName);
        TextView starshipRegistryText = findViewById(R.id.starshipRegistry);
        starshipNameText.setText(starship.getName());
        starshipRegistryText.setText(starship.getRegistry());

        // Display the CrewMembers in a Starship based on it's registry
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        // Inflater for the LinearLayout of a `CrewMember` object
        LayoutInflater inflater = LayoutInflater.from(this);

        // Add the `CrewMember` object to the ScrollView
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