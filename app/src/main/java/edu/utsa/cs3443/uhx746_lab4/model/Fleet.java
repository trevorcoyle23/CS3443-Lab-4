package edu.utsa.cs3443.uhx746_lab4.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fleet {
    private String name;
    private ArrayList<Starship> starships;
    public Fleet(String name) {
        this.name = name;
        this.starships = new ArrayList<>();
    }

    public void loadStarships(Context context) throws IOException {
        String file = "fleet.csv";
        AssetManager assetManager = context.getAssets();

        try {
            InputStream inputStream = assetManager.open(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                Starship starship = new Starship(tokens[0], tokens[1], tokens[2]);
                addStarship(starship);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStarship(Starship s) {
        starships.add(s);
    }

    public Starship findStarship(String registry, ArrayList<Starship> starships) {
        if (!starships.isEmpty()) {
            for (Starship s : starships) {
                if (s.getRegistry().equals(registry)) {
                    return s;
                }
            }
        }
        return null;
    }

    public ArrayList<Starship> getStarships() {
        return starships;
    }

    @Override
    public String toString() {
        return name;
    }
}
