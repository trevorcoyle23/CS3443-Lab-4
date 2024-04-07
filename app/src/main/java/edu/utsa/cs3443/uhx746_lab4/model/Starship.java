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
    // Instance Variables
    private final String name;
    private final String registry;
    private final String shipClass;
    private final ArrayList<CrewMember> crewMembers;

    /**
     * << Constructor >>
     * Starship(String, String, String):
     *  - Sets the object's variables to the parameter variables.
     *  - Creates an ArrayList of `CrewMember` objects.
     * @param name - `name` of the `Starship`.
     * @param registry - `registry` of the `Starship`.
     * @param shipClass - class of the `Starship`.
     */
    public Starship(String name, String registry, String shipClass) {
        this.name = name;
        this.registry = registry;
        this.shipClass = shipClass;
        this.crewMembers = new ArrayList<>();
    }

    /**
     * loadCrewMembers(Context):
     *  - Finds a file "personnel.csv" located in the assets folder for reading.
     *  - Throws IOException if file was not found.
     *  - Uses `InputStream` object and `BufferedReader` object to copy the file's
     *    contents to a new `CrewMember` object and adds it to the `crewMembers`
     *    ArrayList.
     * @param context - Used to find the assets folder.
     * @throws IOException - Thrown when file not found.
     */
    public void loadCrewMembers(Context context) throws IOException {
        // File name
        String file = "personnel.csv";

        // Find the assets folder using the `context` parameter
        AssetManager assetManager = context.getAssets();

        // Check if the file exists
        try {
            // Variables for reading the file's contents
            InputStream inputStream = assetManager.open(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            // Copying the file's contents to the ArrayList
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens[3].equals(registry)) {
                    CrewMember crewMember = new CrewMember(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                    addCrewMember(crewMember);
                }

            }
        } catch (IOException e) {
            // File not found branch
            e.printStackTrace();
        }
    }

    /**
     * addCrewMember(CrewMember):
     *  - Adds a given `CrewMember` object to the `crewMembers` ArrayList.
     * @param c - The `CrewMember` object we are trying to add.
     */
    public void addCrewMember(CrewMember c) {
        crewMembers.add(c);
    }

    /**
     * getCrewMembers():
     *  - Getter method for `crewMembers` ArrayList.
     * @return - `crewMembers` ArrayList.
     */
    public ArrayList<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    /**
     * getRegistry():
     *  - Getter method for `registry` instance variable.
     * @return - `registry` String.
     */
    public String getRegistry() {
        return registry;
    }

    /**
     * getName():
     *  - Getter method for `name` instance variable.
     * @return - `name` String.
     */
    public String getName() {
        return name;
    }

    /**
     * toString():
     *  - String representation for a `Starship`.
     * @return - `name` String.
     */
    @Override
    public String toString() {
        return name;
    }
}
