package edu.utsa.cs3443.uhx746_lab4.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Starship {
    private String name;
    private String registry;
    private String shipClass;
    private ArrayList<CrewMember> crewMembers;
    public Starship(String name, String registry, String shipClass) {
        this.name = name;
        this.registry = registry;
        this.shipClass = shipClass;
        this.crewMembers = new ArrayList<>();
    }

    public void loadCrewMembers(Context context) throws IOException {
        String file = "personnel.csv";
        AssetManager assetManager = context.getAssets();

        try {
            InputStream inputStream = assetManager.open(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens[3].equals(registry)) {
                    CrewMember crewMember = new CrewMember(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                    addCrewMember(crewMember);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCrewMember(CrewMember c) {
        crewMembers.add(c);
    }
    public ArrayList<CrewMember> getCrewMembers() {
        return crewMembers;
    }
    public String getRegistry() {
        return registry;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
