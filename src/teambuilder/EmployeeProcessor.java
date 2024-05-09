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
                data.writeJson();
                finished = true;
                break;
            default:
                finished = true;
                throw new Exception("Invalid input detected: " + choice);
                //break;
        }
        data.writeJson();
        TerminalUI.displayExitOption();
        exitChoice = lineReader.nextInt();
        if(exitChoice == 1)
            finished = true;
    }
    public void addUpdateEmployee(){
        String name, prefRole;
        Scanner scnr = new Scanner(System.in);
        int ID, collab, leadership, codS, codD;
        System.out.println("What is the new employee's name? ");
        name = scnr.next();
        System.out.println("What is the new employee's ID? ");
        ID = scnr.nextInt();
        System.out.println("What is the new employee's preferred role?");
        prefRole = scnr.nextLine();
        System.out.println("What is the new employee's leadership skill out of 10?");
        leadership = scnr.nextInt();
        System.out.println("What is the new employee's collaboration skill out of 10?");
        collab = scnr.nextInt();
        System.out.println("What is the new employee's coding design skill out of 10?");
        codD = scnr.nextInt();
        System.out.println("What is the new employee's coding speed out of 10?");
        codS = scnr.nextInt();
        data.addEmployee(name, ID, prefRole, leadership, collab, codS, codD);
        scnr.close();
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
                data.printList();
                break;
        }
        data.printList();
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
