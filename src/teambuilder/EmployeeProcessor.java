package teambuilder;
import java.util.Scanner;

import teambuilder.ui.TerminalUI;
import teambuilder.util.EmployeeDBTools;
import teambuilder.TeamBuilder;

public class EmployeeProcessor {
    private String fileName;
    private boolean finished = false;
    EmployeeDBTools data = new EmployeeDBTools(fileName);
    public EmployeeProcessor(String fileName){
        this.fileName = fileName;
    }
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
    }

    public void buildTeam(){
        TeamBuilder team = new TeamBuilder();
        Scanner lineRead = new Scanner(System.in);
        int choice = lineRead.nextInt();
        TeamBuilderUI.displayMenu();
        switch(choice){
            case 1:
                data.memberAdd();
            case 2:
                team.removeMember();
            case 3:
                team.viewMembers();
            case 4:
                team.setMaxMembers();
        }
    }
}
