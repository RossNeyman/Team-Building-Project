package teambuilder.ui;


// keep all system out in this file for TeamBuilder, same as terminalui.

/**
 * Handles all TeamBuilder class user interaction terminal outputs.
 */
public class TeamBuilderUI {

    /**
     * Displays the TeamBuilder api.
     */
    public static void displayMenu(){
        System.out.println("TeamBuilder");
        System.out.println("What would you like to do?");
        System.out.println("TeamBuilder");
        System.out.println("1. Add Member");
        System.out.println("2. Remove Member");
        System.out.println("3. View Members");
        System.out.println("4. Set Maximum Team Members");

    }

    /**
     * Promts user to enter name of employee, to be added to the team.
     */
    public static void memberAdd(){
        System.out.println("Enter name of the employee.");
    }

    /**
     * Prompts user to enter name of employee, to be removed from the team.
     */
    public static void memberRemove(){
        System.out.println("Enter name of the employee.");
    }

    /**
     * Displays option to view methods.
     */
    public static void memberView(){
        System.out.println("View current members.");
    }

    /**
     * Prompts user to enter max numbers of teams members.
     */
    public static void maxMemberSet(){
        System.out.println("Enter max numbers of memebers.");
    }

    /**
     * Prints exception messages of the Exception type to the console.
     * @param exc
     */
    public static void displayExceptionMessage(Exception exc){
        System.out.println(exc.getMessage());
    }

    /**
     * Prints any String type exceptions to the console.
     * @param exc
     */
    public static void displayExceptionMessage(String exc){
        System.out.println(exc); // this function may never be used, if not remove it.
    }

}
