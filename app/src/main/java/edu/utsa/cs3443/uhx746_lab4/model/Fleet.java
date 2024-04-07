package edu.utsa.cs3443.uhx746_lab4.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Fleet:
 *  - Created by giving a `name` to the `Fleet`.
 *  - Represents a `Fleet` of starships.
 *  - Holds an ArrayList of `Starship` objects.
 */

public class Fleet {
    // Instance Variables
    private final String name;
    private final ArrayList<Starship> starships;

    /**
     * << Constructor >>
     * Fleet(String):
     *  - Sets Fleet's `name` to the instance variable `name`.
     *  - Creates a new ArrayList of type `Starship`.
     * @param name - the `name` of the `Fleet` object.
     */
    public Fleet(String name) {
        this.name = name;
        this.starships = new ArrayList<>();
    }

    /**
     * loadStarship(Context):
     *  - Tries to find a file "fleet.csv" in the assets folder for reading.
     *  - Throws `IOException` if file could not be found.
     *  - Uses `InputStream` object and `BufferedReader` object to read through the
     *    file line by line until EOF.
     *  - Each line within the file represents a `Starship` object.
     *  - Creates a `Starship` object and adds it to the `starships` ArrayList
     *    for every line.
     * @param context - Needed for referencing the assets folder.
     * @throws IOException - Thrown when file not found.
     */
    public void loadStarships(Context context) throws IOException {
        // File name
        String file = "fleet.csv";

        // Locate assets folder using the `Context` parameter
        AssetManager assetManager = context.getAssets();

        // Check if the file exists
        try {
            // Variables used to copy the file's content
            InputStream inputStream = assetManager.open(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            // Copying the file's content to a `Starship` object
            // Adds it to the ArrayList
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                Starship starship = new Starship(tokens[0], tokens[1], tokens[2]);
                addStarship(starship);
            }
        } catch (IOException e) {
            // File not found branch
            e.printStackTrace();
        }
    }

    /**
     * addStarship(Starship):
     *  - Adds a given `Starship` object to the `starships` ArrayList.
     * @param s - The `Starship` object we are trying to add.
     */
    public void addStarship(Starship s) {
        starships.add(s);
    }

    /**
     * findStarship(String, ArrayList<Starship>):
     *  - Checks if the given ArrayList is empty.
     *  - If so, we search through the ArrayList and check if the
     *    registry given in the method parameter is equal to one of
     *    the `Starship` objects in the ArrayList.
     *  - If a `Starship` object is found, we return it. If not, we
     *    return null.
     * @param registry - a String that represents the registry of a `Starship` that we are searching for.
     * @param starships - an ArrayList we are searching through.
     * @return - a `Starship` object that matches the registry parameter or null if no matches are found.
     */
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

    /**
     * getStarships():
     *  - getter method for the ArrayList.
     * @return - an ArrayList of `Starship` objects.
     */
    public ArrayList<Starship> getStarships() {
        return starships;
    }

    /**
     * toString():
     *  - String representation of a `Fleet` object.
     * @return - the `name` of the `Fleet` object.
     */
    @Override
    public String toString() {
        return name;
    }
}
