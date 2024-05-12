package teambuilder;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

import teambuilder.ui.TerminalUI;
import teambuilder.TeamBuilder;
import teambuilder.util.EmployeeDB;
import teambuilder.util.EmployeeDBTools;
import teambuilder.ui.TeamBuilderUI;

//TODO if a method uses a throws keyword the exception has to be caught and handled by the method call.
public class EmployeeProcessor {

    //private File dataFile;
    private boolean finished = false;
    private final Scanner lineReader = new Scanner(System.in);
    EmployeeDBTools data;
    //private TeamBuilder team = new TeamBuilder(data);
    public EmployeeProcessor(File dataFile) throws IOException {
       // this.dataFile = dataFile;
        data = new EmployeeDBTools(dataFile);
    }
    public boolean getFinishedStatus() {return finished;}
    public void processMenu() throws Exception {

        int choice = lineReader.nextInt();
        int exitChoice;
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
                data.writeJson();
                finished = true;
                break;
            default:
                finished = true;
                //throw new Exception("Invalid input detected: " + choice);
                break;
        }
        data.writeJson();
        TerminalUI.displayExitOption();
        lineReader.nextLine();
        exitChoice = lineReader.nextInt();
        if(exitChoice == 1)
            finished = true;

    }
    public void addUpdateEmployee() throws Exception {
        TerminalUI.displayAddUpdateMenu();
        int choice;
        choice = lineReader.nextInt();
        switch (choice){
            case 1:
                addEmployee();
                break;
            case 2:
                removeEmployee();
                break;
            default:
                System.out.println("Invalid Input: " + choice);
                break;
        }
    }
    public void addEmployee(){
        String name;
        String prefRole;
        int collab;
        int leadership;
        int codS;
        int codD;
        lineReader.nextLine();
        System.out.println("What is the new employee's name? ");
        name = lineReader.nextLine();
        System.out.println("What is the new employee's preferred role?");
        prefRole = lineReader.nextLine();
        System.out.println("What is the new employee's leadership skill out of 10?");
        leadership = lineReader.nextInt();
        System.out.println("What is the new employee's collaboration skill out of 10?");
        collab = lineReader.nextInt();
        System.out.println("What is the new employee's coding design skill out of 10?");
        codD = lineReader.nextInt();
        System.out.println("What is the new employee's coding speed out of 10?");
        codS = lineReader.nextInt();
        data.addEmployee(name, prefRole, leadership, collab, codS, codD);
    }
    public void removeEmployee() throws Exception {

        int removeID;
        int removeConfirmation;
        Employee removalEmployee;
        System.out.println("What is the ID of the employee you would like to remove?");
        removeID = lineReader.nextInt();
        removalEmployee = data.searchEmployeeByID(removeID);
        System.out.println("Are you sure you would like to remove this employee permanently?");
        System.out.println("1: yes/2: no");
        removeConfirmation = lineReader.nextInt();
        if(removeConfirmation == 1)
            data.removeEmployee(removalEmployee);
    }
    public void displayEmployeeList(){
        TerminalUI.displayListSorting();
        int choice = lineReader.nextInt();

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
            case 5:
                break;
        }
        data.printList();
    }
    public void searchEmployee() throws Exception {
        TerminalUI.displaySearchOption();
        Employee retEmployee = null;
        int choice = lineReader.nextInt();

        switch (choice){
            case 1:
                TerminalUI.displaySearchInput(choice);
                int id = lineReader.nextInt();
                retEmployee = data.searchEmployeeByID(id);
                break;
            case 2:
                lineReader.nextLine();
                TerminalUI.displaySearchInput(choice);
                String name = lineReader.nextLine();
                retEmployee = data.searchEmployeeByName(name);
                break;
        }
        assert retEmployee != null;
        retEmployee.printInfo();

    }


    /**
     * Combines TeamBuilderUI and TeamBuilder classes for user interaction.
     */
    public void buildTeam(){
        TeamBuilder team = new TeamBuilder(data);
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
                    break;
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
                    break;
                }
                catch(Exception except){
                    TeamBuilderUI.displayExceptionMessage(except);
                }
            case 3:
                TeamBuilderUI.memberView(); // displays option to view members
                team.viewMembers();
                break;
            case 4:
                try{
                    TeamBuilderUI.maxMemberSet(); // the default max is 8
                    max = lineRead.nextInt();
                    team.setMaxMembers(max);
                    break;
                }
                catch(IllegalArgumentException except){
                    TeamBuilderUI.displayExceptionMessage(except);
                }
        }
        lineRead.close();
    }
}
