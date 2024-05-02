package teambuilder;

import teambuilder.util.EmployeeDBTools;
import java.util.ArrayList;

public class TeamBuilder{
    private ArrayList<Employee> teamList = new ArrayList<Employee>();
    private int memberCount;
    private int maxMembers;

    /**
     * Adds members to the team.
     * To add a member the the memberCount must be less than maxMembers.
     */
    public void addMember(Employee worker){
        try{
            if(memberCount < maxMembers){
                teamList.add(worker);
            }
        }
        catch(Exception except){

        }

    }


    /**
     * Remove member from the team.
     * The memeber must exist in th team, in order to be removed.
     */
    public void removeMember(Employee worker){

    }

    /**
     * Display members of the team.
     */
    public void viewMembers(){

    }

    public void setMaxMembers(int max){
        maxMembers = max;
    }
    }