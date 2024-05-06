package teambuilder;
import java.util.Scanner;
import java.io.File;

import teambuilder.ui.TerminalUI;
import teambuilder.TeamBuilder;
import teambuilder.util.EmployeeDBTools;
import teambuilder.ui.TeamBuilderUI;

public class EmployeeProcessor {
    private String fileName;
    private boolean finished = false;
    EmployeeDBTools data = new EmployeeDBTools(fileName);
    public EmployeeProcessor(String fileName){
        this.fileName = fileName;
    }
    public boolean getFinishedStatus() {return finished;}
    public void processMenu() throws Exception {
        Scanner lineReader = new Scanner(System.in);
        int choice = lineReader.nextInt();
        int exitChoice = 0;
        switch (choice){
            case 1:
                this.addUpdateEmployee();
                break;
            case 2:
                this.displayEmployeeList();
                break;
            case 3:
                this.searchEmployee();
                break;
            case 4:
                this.buildTeam();
                break;
            case 5:
                finished = true;
                break;
        }
        TerminalUI.displayExitOption();
        exitChoice = lineReader.nextInt();
        if(exitChoice == 1)
            finished = true;
        lineReader.close();
    }
    public void addUpdateEmployee(){

    }
    public void displayEmployeeList(){
        Scanner lineRead = new Scanner(System.in);
        int choice = lineRead.nextInt();
        TerminalUI.displayListSorting();
        switch(choice){
            case 1:
                data.sortByLeadership();
                break;
            case 2:
                data.sortByCollaboration();
                break;
            case 3:
                data.sortByCodingDesign();
                break;
            case 4:
                data.sortByCodingSpeed();
                break;
        }
        data.printList();
        lineRead.close();
    }
    public void searchEmployee() throws Exception {
        Scanner lineRead = new Scanner(System.in);
        int choice = lineRead.nextInt();
        TerminalUI.displaySearchOption();
        Employee retEmployee = null;
        switch (choice){
            case 1:
                TerminalUI.displaySearchInput(choice);
                int id = lineRead.nextInt();
                retEmployee = data.searchEmployeeByID(id);
            case 2:
                TerminalUI.displaySearchInput(choice);
                String name = lineRead.nextLine();
                retEmployee = data.searchEmployeeByName(name);
        }
        assert retEmployee != null;
        retEmployee.printInfo();
        lineRead.close();
    }

    //TODO finish the methods

    /**
     * Combines TeamBuilderUI and TeamBuilder classes for user interaction.
     */
    public void buildTeam(){
        TeamBuilder team = new TeamBuilder(fileName);
        Scanner lineRead = new Scanner(System.in);
        int max;
        String name;
        int choice = lineRead.nextInt();
        TeamBuilderUI.displayMenu();

        switch(choice){
            case 1:
                try{
                    TeamBuilderUI.memberAdd();
                    name = lineRead.next();
                    team.addMember(data.searchEmployeeByName(name));
                }
                catch(ArithmeticException except){
                    TeamBuilderUI.displayExceptionMessage(except);
                }
                catch(Exception except){}
            case 2:
                try{
                    TeamBuilderUI.memberRemove();
                    name = lineRead.next();
                    team.removeMember(data.searchEmployeeByName(name));
                }
                catch(Exception except){
                    TeamBuilderUI.displayExceptionMessage(except);
                }
            case 3:
                TeamBuilderUI.memberView(); // displays option to view members
                team.viewMembers();
            case 4:
                try{
                    TeamBuilderUI.maxMemberSet(); // the default max is 8
                    max = lineRead.nextInt();
                    team.setMaxMembers(max);
                }
                catch(IllegalArgumentException except){
                    TeamBuilderUI.displayExceptionMessage(except);
                }
        }
        lineRead.close();
    }
}
