package teambuilder;

import teambuilder.util.EmployeeDBTools;

/**
 * Manager class represents a manager in the team.
 */
public class Manager extends Person {

    /**
     * Constructs a Manager object with default attributes.
     */
    public Manager() {
        super();
    }

    /**
     * Constructs a Manager object with the specified name.
     *
     * @param s The name of the manager.
     */
    public Manager(String s) {
        super(s);
    }

    /**
     * Constructs a Manager object with the specified name and ID.
     *
     * @param s The name of the manager.
     * @param id The ID of the manager.
     */
    public Manager(String s, int id) {
        super(s, id);
    }

    /**
     * Changes the rating of a specific employee in a given rating category.
     *
     * @param employeeID The ID of the employee whose rating is to be changed.
     * @param ratingCategory The category of rating to be changed (1: Leadership, 2: Collaboration, 3: Coding Speed, 4: Coding Design).
     * @param rating The new rating value to be set.
     * @param s The employee database to search for the employee.
     * @throws Exception If an exception occurs during the rating change process.
     */
    public void changeRatings(int employeeID, int ratingCategory, int rating, EmployeeDBTools s) throws Exception {
        Employee emp = s.searchEmployeeByID(employeeID);
        switch (ratingCategory){
            case 1:
                emp.setLeadershipRating(rating);
                break;
            case 2:
                emp.setCollaborationRating(rating);
                break;
            case 3:
                emp.setCodingSpeed(rating);
                break;
            case 4:
                emp.setCodingDesign(rating);
                break;
        }
    }

    /**
     * Changes the preferred role of a specific employee.
     *
     * @param employeeID The ID of the employee whose preferred role is to be changed.
     * @param role The new preferred role to be set.
     * @param s The employee database to search for the employee.
     * @throws Exception If an exception occurs during the preferred role change process.
     */
    public void changePreferredRole(int employeeID, String role, EmployeeDBTools s) throws Exception {
        Employee emp = s.searchEmployeeByID(employeeID);
        emp.setPreferredRole(role);
    }
}
