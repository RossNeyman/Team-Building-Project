package teambuilder.util;

import teambuilder.Employee;
import teambuilder.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class buildTeam{
    private ArrayList<Employee> TeamList = new ArrayList<Employee>();
    private int memberCount;
    private int maxMembers;

    /**
     * Adds members to the team.
     * To add a member to the team, memberCount must be less than maxMembers.
     * @param worker Employee
     */
    public void addMember(Employee worker){
        try{
            if(memberCount < maxMembers){
                TeamList.add(worker);
                memberCount++;
            }
            else{
                throw new Exception("Cannot add member, team is full.");
            }
        }
        catch(Exception except){
            System.out.println(except.getMessage());
        }
        finally{

        }
    }


    /**
     * Remove member from the team.
     * The memeber must exist in th team, in order to be removed.
     */

    // Also consider remodeling the searchEmployeeeByID function to include an object as a parameter, to be re-used.
    public void removeMember(Employee worker){
        try{
            if(TeamList.contains(worker.getID())){
                TeamList.remove(TeamList.indexOf(worker.getID()));
                memberCount--;
            }
            else{
                throw new Exception("Is not a member of the team.");
            }
        }

        catch(Exception except){
            System.out.println(except.getMessage());
        }
        finally{

        }
    }

    /**
     * Display members of the team.
     */
    //TODO: learn javaGUI, then finish this.
    public void viewMembers(){

    }

    }