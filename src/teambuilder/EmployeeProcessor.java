package teambuilder;

import java.util.Scanner;

import teambuilder.ui.TerminalUI;
import teambuilder.util.EmployeeDBTools;

/**
 * EmployeeProcessor class handles the processing of employee-related operations.
 */
public class EmployeeProcessor {
    private String fileName;
    private boolean finished = false;
    EmployeeDBTools data = new EmployeeDBTools(fileName);

    /**
     * Constructs an EmployeeProcessor object with the specified file name.
     *
     * @param fileName The name of the file to be processed.
     */
    public EmployeeProcessor(String fileName){
        this.fileName = fileName;
    }

    /**
     * Processes the menu options for employee-related operations.
     *
     * @throws Exception If an exception occurs during processing.
     */
    public void processMenu() throws Exception {
        Scanner lineReader = new Scanner(System.in);
        int choice = lineReader.nextInt();
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
    }

    /**
     * Method to add or update an employee's information.
     */
    public void addUpdateEmployee(){
        // Implementation goes here
    }

    /**
     * Displays the list of employees sorted according to user's choice.
     */
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
    }

    /**
     * Searches for an employee based on user's choice and displays the information.
     *
     * @throws Exception If an exception occurs during the search process.
     */
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
    }

    /**
     * Builds a team with selected employees.
     */
    public void buildTeam(){
        // Implementation goes here
    }
}
