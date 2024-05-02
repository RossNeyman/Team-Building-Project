package teambuilder;
import teambuilder.ui.TerminalUI;

import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        String f = null;
        EmployeeProcessor processor = new EmployeeProcessor(f);

        TerminalUI.displayTitle();
        while(!processor.getFinishedStatus()){
            TerminalUI.displayMenu();
            processor.processMenu();
        }
    }
}