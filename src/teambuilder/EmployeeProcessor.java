package teambuilder;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import teambuilder.ui.TerminalUI;
import teambuilder.util.EmployeeDBTools;
import teambuilder.ui.TeamBuilderUI;


/**
 * The type Employee processor.
 */
public class EmployeeProcessor {


    private boolean finished = false;
    private final Scanner lineReader = new Scanner(System.in);
    /**
     * The Data.
     */
    EmployeeDBTools data;

    /**
     * Instantiates a new Employee processor.
     *
     * @param dataFile the data file
     * @throws IOException the io exception
     */
    public EmployeeProcessor(File dataFile) throws IOException {
        data = new EmployeeDBTools(dataFile);
    }

    /**
     * Gets finished status.
     *
     * @return the finished status
     */
    public boolean getFinishedStatus() {return finished;}

    /**
     * Process menu.
     *
     * @throws Exception the exception
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
     * Add update employee.
     *
     * @throws Exception the exception
     */
    public void addUpdateEmployee() throws Exception {
        TerminalUI.displayAddUpdateMenu();
        int choice;
        choice = lineReader.nextInt();
        //TODO method is missing update feature.
        switch (choice){
            case 1:
                addEmployee();
                break;
            case 2:
                removeEmployee();
                break;
            case 3:
                updateInfo();
            default:
                System.out.println("Invalid Input: " + choice);
                break;
        }
    }

    /**
     * Updates an employee's information.
     * The information is updated via a call to a chnage function.
     */
    public void updateInfo(){// is working.
        int id;
        Employee curr;
        Employee diff;
        lineReader.nextLine();
        System.out.println("Enter the employees ID: ");
        id = lineReader.nextInt();// should consider adding try catch to handle missmatch values.

        // Now check if id is in the database.
        try{
            curr = data.searchEmployeeByID(id);
            if(curr.getID() == id){
                String n; // name
                int codS; // coding speed
                int codD; // coding design
                int collab;
                int leadership;
                String prefRole;
                // is missing position.
                lineReader.nextLine();//clear input stream.
                //TODO consider what happens if the value entered is less  than 0 or greater than 10.
                System.out.println("Enter the employees new name: ");
                n = lineReader.nextLine();
                System.out.println("Enter the employees new position: ");
                prefRole = lineReader.nextLine();
                System.out.println("Enter employees new coding speed rating: ");
                codS = lineReader.nextInt();
                System.out.println("Enter employees new coding design rating: ");
                codD = lineReader.nextInt();
                System.out.println("Enter employees new collobratiopn rating: ");
                collab = lineReader.nextInt();
                System.out.println("Enter employees new leadership rating: ");
                leadership = lineReader.nextInt();

                diff = new Employee(n, id, prefRole, leadership, collab, codS, codD);
                data.changeEmployeeInfo(curr, diff);

            }
        }
        catch(Exception excpt){
            System.out.println(excpt.getMessage());
        }
    }

    /**
     * Adds an employee to the database.
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
     * Remove an employee from the database.
     *
     * @throws Exception the exception
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
     * Display employee list.
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
     * Search employee.
     *
     * @throws Exception the exception
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
     * Combines TeamBuilderUI and TeamBuilder classes for user interaction.
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
                        //TODO add call to suggest algo set max member count here, if possible.
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
