package teambuilder;

import teambuilder.util.EmployeeDBTools;

//import java.io.IOException;
import java.util.ArrayList;

/**
 * Implements methods for operating on a team.
 */
public class TeamBuilder{
    private ArrayList<Employee> teamList = new ArrayList<Employee>();
    private EmployeeDBTools tool;
    private int memberCount = 0;
    private int maxMembers = 8; // 8 is the default max value.


    /**
     * Paramteried constructor sets file's name, for use of EmployeeDBTools.
     * @param dataFile object of EmployeeDBTools to enable use of its methods.
     */
    public TeamBuilder(EmployeeDBTools dataFile){
        try{
            tool = dataFile; // I know, not a descriptive name.
        }
        catch(Exception except){
        }
    }
    /**
     * Adds new member to the team.
     * To add an employee the memberCount must be less than maxMembers.
     * The employee to be added must also exist in the employee database.
     * @param worker info of employee to be added to the team.
     */
    public void addMember(Employee worker) throws ArithmeticException{

        if(memberCount <= maxMembers){
            try{
                    teamList.add(worker);
                    memberCount++;

            }
            catch(Exception except){
                System.out.println(except.getMessage()); // TODO consider writing a function to display all exception messages.
            }
        }
        else throw new ArithmeticException("Member count is equal to or exceeds max count.");
    }


    /**
     * Remove member from the team.
     * The memeber must exist in th team, in order to be removed.
     * @param worker object of Employee feeds method of employee to be removed.
     */
    public void removeMember(Employee worker) throws Exception{
        if(teamList.contains(worker)){
            teamList.remove(worker);
            memberCount--;
        }
        else throw new Exception("Employee is not on the team.");
    }

    /**
     * Display members of the team, to the console.
     */
    public void viewMembers(){
        if(memberCount == 0){
            System.out.println("No members in team");
        }
        else{
            for(Employee member : teamList){
               member.printNameID();
               System.out.println(member.getPreferredRole());
               System.out.println();
            }
        }

    }

    /**
     * Sets the max member for a team.
     * Changes the max number of members on a team from its default value.
     * @param max is the max number of member the team can have.
     */
    public void setMaxMembers(int max) throws IllegalArgumentException{
        if(max <= 0){
            throw new IllegalArgumentException("Incorrect value.");
        }
        else{
            maxMembers = max;
        }
    }

    /**
     * Returns the teams current member count.
     * @return
     */
    public int getMemberCount(){
        return memberCount;
    }

    }