package teambuilder.ui;

/**
 * The TerminalUI class provides methods for displaying user interface elements and options in a terminal-based interface.
 */
public class TerminalUI {
    /**
     * Displays the title of the application.
     */
    public static void displayTitle(){System.out.println("Welcome to the Team Builder");}

    /**
     * Displays the main menu options.
     */
    public static void displayMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add/update employee information");
        System.out.println("2. Display list of active employees");
        System.out.println("3. Search employees by ID or by name");
        System.out.println("4. Assemble a team of employees");
        System.out.println("5. Close program");
    }

    /**
     * Displays options for sorting employee lists.
     */
    public static void displayListSorting(){
        System.out.println("What attribute would you like to sort by?");
        System.out.println("1. Leadership skill");
        System.out.println("2. Collaborative skill");
        System.out.println("3. Overall code design");
        System.out.println("4. Coding speed");
        System.out.println("5. Employee Score");
    }

    /**
     * Displays options for searching employees.
     */
    public static void displaySearchOption(){
        System.out.println("What attribute would you like to search by?");
        System.out.println("1. ID");
        System.out.println("2. Name");
    }

    /**
     * Displays the input prompt for searching employees based on the given choice.
     *
     * @param choice An integer representing the choice for search attribute (1 for ID, 2 for Name).
     */
    public static void displaySearchInput(int choice){
        if (choice == 1)
            System.out.print("Please enter ID: ");
        else
            System.out.print("Please enter Name: ");
    }

    /**
     * Displays the option for exiting the program.
     */
    public static void displayExitOption(){
        System.out.println("Do you wish to exit? \n(1: yes/2: no)");
    }

    /**
     * Displays options for adding or removing employees.
     */
    public static void displayAddUpdateMenu(){
        System.out.println("Would you like to add or remove an employee?");
        System.out.println("1. Add an employee");
        System.out.println("2. Remove an employee by their ID number");
        System.out.println("3. Update employees info by ID number");
    }
}

