package edu.utsa.cs3443.uhx746_lab4.model;

import edu.utsa.cs3443.uhx746_lab4.R;

public class CrewMember {
    // Instance Variables
    private String name;
    private String position;
    private String rank;
    private String species;
    private String assignment;

    /**
     * << Constructor >>
     * CrewMember(String, String, String, String, String):
     *  - Represents a `CrewMember` on a `Starship`.
     *  - Constructor when given an `assignment`.
     * @param name - `name` of the `CrewMember`.
     * @param position - `position` in the `Starship`.
     * @param rank - `rank` of the `CrewMember`.
     * @param assignment - the `Starship` the `CrewMember` is on.
     * @param species - `species` of the `CrewMember`.
     */
    public CrewMember(String name, String position, String rank, String assignment, String species) {
        this.name = name;
        this.position = position;
        this.rank = rank;
        this.assignment = assignment;
        this.species = species;
    }

    /**
     * << Constructor >>
     * CrewMember(String, String, String, String, String):
     *  - Represents a `CrewMember` on a `Starship`.
     *  - Constructor when NOT given an `assignment`.
     * @param name - `name` of the `CrewMember`.
     * @param position - `position` in the `Starship`.
     * @param rank - `rank` of the `CrewMember`.
     * @param species - `species` of the `CrewMember`.
     */
    public CrewMember(String name, String position, String rank, String species) {
        this.name = name;
        this.position = position;
        this.rank = rank;
        this.species = species;
        this.assignment = null;
    }

    /**
     * imageFileName():
     *  - Finds the image file of a `CrewMember` based on their `name`.
     * @return - the id of the drawable image file.
     */
    public int imageFileName() {
        // Find image file based on `CrewMember`'s `name`
        switch (name) {
            case "James T. Kirk":
                return R.drawable.kirk;
            case "Spock":
                return R.drawable.spock;
            case "Leonard McCoy":
                return R.drawable.mccoy;
            case "Montgomery Scott":
                return R.drawable.scott;
            case "Jean-Luc Picard":
                return R.drawable.picard;
            case "William T. Riker":
                return R.drawable.riker;
            case "Beverly Crusher":
                return R.drawable.crusher;
            case "Geordi La Forge":
                return R.drawable.forge;
            case "Deanna Troi":
                return R.drawable.troi;
            case "Worf":
                return R.drawable.worf;
            case "Data":
                return R.drawable.data;
            case "Tasha Yar":
                return R.drawable.yar;
            case "Christine Chapel":
                return R.drawable.chapel;
            case "B'Elanna Torres":
                return R.drawable.torres;
            case "Tom Paris":
                return R.drawable.paris;
            case "The Doctor":
                return R.drawable.doctor;
            case "Nyota Uhura":
                return R.drawable.uhura;
            case "Neelix":
                return R.drawable.neelix;
            case "Hikaru Sulu":
                return R.drawable.sulu;
            case "Kes":
                return R.drawable.kes;
            case "Pavel Chekov":
                return R.drawable.chekov;
            case "Kathryn Janeway":
                return R.drawable.janeway;
            case "Chakotay":
                return R.drawable.chakotay;
            case "Tuvok":
                return R.drawable.tuvok;
        }
        return R.drawable.ic_launcher_background;
    }

    /**
     * toString():
     *  - String representation of a `CrewMember`.
     * @return - `position`, `rank`, and `name`.
     */
    @Override
    public String toString() {
        return position + "\n" + rank + " " + name;
    }
}
