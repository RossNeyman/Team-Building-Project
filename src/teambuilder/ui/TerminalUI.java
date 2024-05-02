package teambuilder.ui;

import teambuilder.Employee;

public class TerminalUI {
    public static void displayTitle(){System.out.println("Welcome to the Team Builder");}
    public static void displayMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add/update employee information");
        System.out.println("2. Display list of active employees");
        System.out.println("3. Search employees by ID or by name");
        System.out.println("4. Assemble a team of employees");
        System.out.println("5. Close program");
    }
    public static void displayListSorting(){
        System.out.println("What attribute would you like to sort by?");
        System.out.println("1. Leadership skill");
        System.out.println("2. Collaborative skill");
        System.out.println("3. Overall code design");
        System.out.println("4. Coding speed");
    }
    public static void displaySearchOption(){
        System.out.println("What attribute would you like to search by?");
        System.out.println("1. ID");
        System.out.println("2. Name");
    }
    public static void displaySearchInput(int choice){
        if (choice == 1)
            System.out.print("Please enter ID: ");
        else
            System.out.print("Please enter Name: ");
    }
    public static void displayExitOption(){
        System.out.println("Do you wish to exit? \n(1: yes/2: no)");
    }
    public static void addUpdateEmployeeChoice(){
        System.out.println("What would you like to do? ");
        System.out.println("Add an employee");
    }
}

