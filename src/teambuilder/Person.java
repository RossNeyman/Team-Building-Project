package teambuilder;

import java.util.Random;

/**
 * Person is an abstract class representing an individual in the team.
 */
public abstract class Person {
    protected String name; // Name of the person
    protected int id; // Unique ID of the person

    /**
     * Default constructor.
     * Initializes the name to null and generates a random ID.
     */
    public Person(){
        name = null;
        id = new Random().nextInt(900000) + 100000; // Generate a random 6-digit ID
    }

    /**
     * Constructor with name parameter.
     * Generates a random ID.
     *
     * @param n The name of the person.
     */
    public Person(String n){
        name = n;
        id = new Random().nextInt(900000) + 100000; // Generate a random 6-digit ID
    }

    /**
     * Constructor with name and ID parameters.
     *
     * @param n The name of the person.
     * @param id The ID of the person.
     */
    public Person(String n, int id){
        name = n;
        this.id = id;
    }

    /**
     * Sets the name of the person.
     *
     * @param n The name to set.
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the ID of the person.
     *
     * @return The ID of the person.
     */
    public int getID(){
        return id;
    }

    /**
     * Checks if a given ID matches the ID of the person.
     *
     * @param n The ID to check.
     * @return true if the given ID matches the person's ID, false otherwise.
     */
    public boolean checkID(int n){
        return (n == id);
    }
}
