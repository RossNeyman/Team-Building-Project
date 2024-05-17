package teambuilder;
import teambuilder.ui.TerminalUI;

import java.io.IOException;
import java.io.File;

/**
 * The Main class serves as the entry point for the TeamBuilder application.
 * It initializes the EmployeeProcessor with a data file and controls the
 * user interface through the TerminalUI.
 */
public class Main {
    /**
     * The main method is the entry point of the application.
     * It initializes the necessary components and starts the main loop
     * for user interaction through the terminal.
     *
     * @param args Command line arguments. The first argument should be the path to the data file.
     * @throws Exception if there is an issue initializing the EmployeeProcessor or processing the menu.
     */
    public static void main(String[] args) throws Exception{
        File dataFile = new File(args[0]);
        EmployeeProcessor processor = new EmployeeProcessor(dataFile);

        TerminalUI.displayTitle();
        while(!processor.getFinishedStatus()){
            TerminalUI.displayMenu();
            processor.processMenu();
        }

    }
}