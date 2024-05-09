package teambuilder;
import teambuilder.ui.TerminalUI;

import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception{
        String f = null;
        File dataFile = new File(args[0]);

        EmployeeProcessor processor = new EmployeeProcessor(dataFile);

        try{
            TerminalUI.displayTitle();
            while(!processor.getFinishedStatus()){
                TerminalUI.displayMenu();
                processor.processMenu();
            }
        }
        catch(Exception except){
            System.out.println(except.getMessage());
        }

    }
}