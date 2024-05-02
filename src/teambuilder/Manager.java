package teambuilder;

import teambuilder.util.EmployeeDBTools;
import teambuilder.util.EmployeeDB;

public class Manager extends Person {

    public Manager(){super();}
    public Manager(String s){super(s);}
    public Manager(String s, int id){super(s,id);}

    public void changeRatings(int employeeID, int ratingCategory, int rating, EmployeeDBTools s) throws Exception {
        Employee emp = s.searchEmployeeByID(employeeID);
        switch (ratingCategory){
            case 1:
                emp.setLeadershipRating(rating);
            case 2:
                emp.setCollaborationRating(rating);
            case 3:
                emp.setCodingSpeed(rating);
            case 4:
                emp.setCodingDesign(rating);
        }
    }
    public void changePreferredRole(int employeeID, String role, EmployeeDBTools s) throws Exception {
        Employee emp = s.searchEmployeeByID(employeeID);
        emp.setPreferredRole(role);
    }
}
