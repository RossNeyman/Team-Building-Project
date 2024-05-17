package teambuilder;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import teambuilder.ui.TerminalUI;
import teambuilder.util.EmployeeDBTools;
import teambuilder.ui.TeamBuilderUI;
/**
 * The EmployeeProcessor class handles the main logic for processing employee data.
 * It interacts with the user through a terminal interface and performs various operations
 * such as adding, removing, and searching for employees, as well as building teams.
 */

public class EmployeeProcessor {


    private boolean finished = false;
    private final Scanner lineReader = new Scanner(System.in);
    EmployeeDBTools data;
    /**
     * Constructs an EmployeeProcessor with the specified data file.
     *
     * @param dataFile The file containing employee data.
     * @throws IOException if there is an error reading the data file.
     */
    public EmployeeProcessor(File dataFile) throws IOException {
        data = new EmployeeDBTools(dataFile);
    }
    /**
     * Returns the finished status of the EmployeeProcessor.
     *
     * @return true if the processing is finished, false otherwise.
     */
    public boolean getFinishedStatus() {return finished;}
    /**
     * Processes the menu options selected by the user and performs the corresponding actions.
     *
     * @throws Exception if there is an error processing the menu.
     */
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

    /**
     * Displays the menu for adding or updating an employee and processes the user's choice.
     *
     * @throws Exception if there is an error adding or updating the employee.
     */
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
    /**
     * Adds a new employee based on the user input.
     */
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
    /**
     * Removes an employee based on the user input.
     *
     * @throws Exception if there is an error removing the employee.
     */
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
    /**
     * Displays the list of employees, sorted based on the user's choice.
     */
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
    /**
     * Searches for an employee based on the user's input and displays their information.
     *
     * @throws Exception if there is an error searching for the employee.
     */
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
     * Handles the team-building process, allowing the user to add or remove members,
     * set the maximum number of members, and view the current team.
     */
    public void buildTeam(){
        TeamBuilder team = new TeamBuilder(data);
        int max;
        String name;
        int exitChoice = 0;

        while(exitChoice != 1) {
            TeamBuilderUI.displayMenu();
            int choice = lineReader.nextInt();
            lineReader.nextLine();
            switch (choice) {
                case 1:
                    try {
                        TeamBuilderUI.memberAdd();
                        name = lineReader.nextLine();
                        team.addMember(data.searchEmployeeByName(name));
                        break;
                    } catch (ArithmeticException except) {
                        TeamBuilderUI.displayExceptionMessage(except);
                    } catch (Exception except) {
                    }
                    break;
                case 2:
                    try {
                        TeamBuilderUI.memberRemove();
                        name = lineReader.nextLine();
                        team.removeMember(data.searchEmployeeByName(name));
                        break;
                    } catch (Exception except) {
                        TeamBuilderUI.displayExceptionMessage(except);
                    }
                    break;
                case 3:
                    TeamBuilderUI.memberView(); // displays option to view members
                    team.viewMembers();
                    break;
                case 4:
                    try {
                        TeamBuilderUI.maxMemberSet(); // the default max is 8
                        max = lineReader.nextInt();
                        team.setMaxMembers(max);
                        break;
                    } catch (IllegalArgumentException except) {
                        TeamBuilderUI.displayExceptionMessage(except);
                    }
                    break;
                case 5:
                    displayEmployeeList();
                    break;
            }

            TeamBuilderUI.displayExitMenu();
            exitChoice = lineReader.nextInt();
        }
    }
}
