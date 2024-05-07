package teambuilder;

import java.util.ArrayList;

public class TeamBuilder{
    private ArrayList<Employee> teamList = new ArrayList<Employee>();
    private int memberCount;
    private int maxMembers;

    /**
     * Adds members to the team.
     * To add a member the the memberCount must be less than maxMembers.
     */

    public void setMaxMembers(int maxMembers){
        this.maxMembers = maxMembers;
    }
    public void addMember(Employee employee){
        teamList.add(employee);
    }


    /**
     * Remove member from the team.
     * The memeber must exist in th team, in order to be removed.
     */
    public void removeMember(Employee employee){
        teamList.remove(employee);
    }

    /**
     * Display members of the team.
     */
    public void viewMembers(){

    }

    }