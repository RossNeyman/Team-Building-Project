package teambuilder;

import java.util.Random;
/**
 * Abstract class representing a person in the system.
 */
public abstract class Person {
    /** The name of the person. */
    protected String name;
    /** The ID of the person. */
    protected int id;

    /**
     * Default constructor.
     * Initializes the person with a random ID.
     */
    public Person(){
        name = null;
        id = new Random().nextInt(900000) + 100000;
    }

    /**
     * Constructor with name parameter.
     * Initializes the person with the specified name and a random ID.
     *
     * @param n The name of the person.
     */
    public Person(String n){
        name = n;
        id = new Random().nextInt(900000) + 100000;
    }

    /**
     * Constructor with name and ID parameters.
     *
     * @param n  The name of the person.
     * @param id The ID of the person.
     */
    public Person(String n, int id){
        name = n;
        this.id = id;
    }

    /**
     * Sets the name of the person.
     *
     * @param n The new name of the person.
     */
    public void setName(String n) {name = n;}

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName(){return name;}

    /**
     * Gets the ID of the person.
     *
     * @return The ID of the person.
     */
    public int getID(){return id;}

    /**
     * Checks if the provided ID matches the ID of the person.
     *
     * @param n The ID to check.
     * @return True if the provided ID matches the person's ID, otherwise false.
     */
    public boolean checkID(int n){
        return (n == id);
    }


}
