package teambuilder;

import teambuilder.util.EmployeeDBTools;
import java.util.ArrayList;



/**
 * Implements methods for operating on a team.
 */
public class TeamBuilder{
    private ArrayList<Employee> teamList = new ArrayList<Employee>();
    private String fName;
    private int memberCount = 0;
    private int maxMembers = 8; // 8 is the default max value.

    /**
     * Creates a TeamBuilder object.
     * @param f
     */
    public TeamBuilder(String f){
        fName = f; // is nescessary for accessing the EMployeeDBTools.
    }

    /**
     * Adds new member to the team.
     * To add an employee the memberCount must be less than maxMembers.
     * The employee to be added must also exist in the employees data base.
     * @param worker
     */
    public void addMember(Employee worker) throws ArithmeticException{
        EmployeeDBTools tool = new EmployeeDBTools(fName);

        if(memberCount < maxMembers){
            try{
                if(worker.equals(tool.searchEmployeeByName(worker.getName()))){
                    teamList.add(worker);
                    memberCount++;
                }
            }
            catch(Exception except){
                System.out.println(except.getMessage()); // TODO consider writing a function to display all exception messages.
            }
        }
        else throw new ArithmeticException("Member count is equal to or exceeds max count.");
    }


    /**
     * Removes member from team.
     * Employee must already exist in the team to be removed.
     * @param worker
     */
    public void removeMember(Employee worker) throws Exception{
        if(teamList.contains(worker)){
            teamList.remove(worker);
            memberCount--;
        }
        else throw new Exception("Employee is not on the team.");
    }

    /**
     * Display members of the team.
     */
    public void viewMembers(){
        for(int count = 0; count < memberCount; count++){
            System.out.println(teamList.get(count));
        }

    }

    /**
     * Sets the maximum number of members a team can have.
     * The default max is 8.
     * @param max
     */
    public void setMaxMembers(int max) throws IllegalArgumentException{
        if(max <= 0){
            throw new IllegalArgumentException("Incorrect value.");
        }
        else{
            maxMembers = max;
        }
    }
    }