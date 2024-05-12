package teambuilder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Employee class represents an employee in a team.
 */
public class Employee extends Person {
    // Attributes specific to an employee
    private int leadershipRating; // Rating of leadership skills (out of 10)
    private int collaborationRating; // Rating of collaboration skills (out of 10)
    private int codingSpeed; // Rating of coding speed (out of 10)
    private int codingDesign; // Rating of coding design (out of 10)
    private String preferredRole; // Preferred role in the team

    /**
     * Default constructor initializes attributes to default values.
     */
    public Employee(){
        super(); // Call the constructor of the superclass
        leadershipRating = 0;
        collaborationRating = 0;
        codingSpeed = 0;
        codingDesign = 0;
        preferredRole = null;
    }

    /**
     * Parameterized constructor initializes attributes with provided values.
     *
     * @param n Name of the employee.
     * @param id ID of the employee.
     * @param p Preferred role of the employee.
     * @param l Leadership rating of the employee.
     * @param col Collaboration rating of the employee.
     * @param codS Coding speed rating of the employee.
     * @param codD Coding design rating of the employee.
     */
    public Employee(String n, int id, String p, int l, int col, int codS, int codD) {
        // Call the constructor of the superclass to initialize inherited attributes
        name = n;
        this.id = id;
        leadershipRating = l;
        collaborationRating = col;
        codingSpeed = codS;
        codingDesign = codD;
        preferredRole = p;
    }

    // Getter and setter methods

    /**
     * Get the leadership rating of the employee.
     *
     * @return The leadership rating (out of 10).
     */
    public int getLeadershipRating(){return leadershipRating;}

    /**
     * Get the collaboration rating of the employee.
     *
     * @return The collaboration rating (out of 10).
     */
    public int getCollaborationRating() {return collaborationRating;}

    /**
     * Get the coding design rating of the employee.
     *
     * @return The coding design rating (out of 10).
     */
    public int getCodingDesign() {return codingDesign;}

    /**
     * Get the coding speed rating of the employee.
     *
     * @return The coding speed rating (out of 10).
     */
    public int getCodingSpeed() {return codingSpeed;}

    /**
     * Get the preferred role of the employee.
     *
     * @return The preferred role.
     */
    public String getPreferredRole() {return preferredRole;}

    /**
     * Set the leadership rating of the employee.
     *
     * @param n The new leadership rating to set.
     */
    public void setLeadershipRating(int n){leadershipRating = n;}

    /**
     * Set the collaboration rating of the employee.
     *
     * @param n The new collaboration rating to set.
     */
    public void setCollaborationRating(int n) {collaborationRating = n;}

    /**
     * Set the coding design rating of the employee.
     *
     * @param n The new coding design rating to set.
     */
    public void setCodingDesign(int n) {codingDesign = n;}

    /**
     * Set the coding speed rating of the employee.
     *
     * @param n The new coding speed rating to set.
     */
    public void setCodingSpeed(int n) {codingSpeed = n;}

    /**
     * Set the preferred role of the employee.
     *
     * @param s The new preferred role to set.
     */
    public void setPreferredRole(String s) {preferredRole = s;}

    /**
     * Print detailed information about the employee.
     */
    public void printInfo(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Preferred Role: " + preferredRole);
        System.out.println("Leadership Rating: " + leadershipRating + "/10");
        System.out.println("Collaboration Rating: " + collaborationRating + "/10");
        System.out.println("Coding Speed Rating: " + codingSpeed + "/10");
        System.out.println("Code Design Rating: " + codingDesign + "/10");
    }

    /**
     * Print only the name and ID of the employee.
     */
    public void printNameID(){
        System.out.println(name + " - " + id);

    }
}
