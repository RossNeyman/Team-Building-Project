package teambuilder.ui;


// keep all system out in this file for TeamBuilder, same as terminalui.
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
    public static void memberAdd(){
        System.out.println("Enter name of the employee.");
    }

    public static void memberRemove(){
        System.out.println("Enter name of the employee.");
    }

    public static void memberView(){
        System.out.println("View current members.");
    }

    public static void maxMemberSet(){
        System.out.println("Enter max numbers of memebers.");
    }

}
