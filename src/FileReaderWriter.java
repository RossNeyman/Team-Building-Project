import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import Employee.java;


/**
 * Handles reading and writing to an employees info file.
 */
public class FileReaderWriter {
    protected ArrayList<Employee> employeesList = new ArrayList<Employee>();
    protected ArrayList<Manager> managersList = new ArrayList<Manager>();

    /**
    * Reads the given file, into list of employees.
    * The info read from the file is parsed and stored accordingly.
    *@param file's name.
    * */
    private void readInfo(String fileName) throws FileNotFoundException{
        Employee worker = new Employee();
        try{
            File employees = new File(fileName);
            Scanner read = new Scanner(employees);

            while(read.hasNext()){
                employeesList.add(worker(read.next(), read.next(), read.nextInt(), read.nextInt(), read.nextInt(), read.nextInt()));
                // input is {name, perferred role, leaderShip rating, collaboration rating, coding Speed, code design}
            }
            read.close();
        }
        catch(FileNotFoundException excpt){
            System.out.println("Error opening file");
        }
        finally{
            read.close();
        }
    }

    /**
     * Adds new employee info to employees file.
     *
     * @param worker   the worker
     * @param fileName the file name
     */
    public void newEntry(Employee worker, String fileName) throws FileNotFoundException{
        try{
            File employees = new File(fileName)
            Scanner read = new Scanner(employees);
            FileWriter newEmployeeInfo = new FileWriter(fileName);
            String lineRead;

            while(read.hasNext()){
                lineRead = read.line();
            }
            newEmployeeInfo.write(worker.name);
            newEmployeeInfo.write(worker.getPerferredRole);
            newEmployeeInfo.write(worker.leadershipRating);
            newEmployeeInfo.write(worker.getCollabortaionRating);
            newEmployeeInfo.write(worker.getCodingSpeed);
            newEmployeeInfo.write(worker.getCodeDesign);


        }
        catch(FileNotFoundException excpt){
            System.out.println("Error opening file");
        }
        finally{
            newEmployeeInfo.close();
            read.close();
        }
    }

    /**
     * updates the info of already existing employees.
     *
     * @param worker     the worker
     * @param workerName the worker name
     * @param fileName   the file name
     */
    public void updateEntry(Employee worker, String workerName, String fileName) throws FileNotFoundException{
        try{
            File employees = new File(fileName)
            Scanner read = new Scanner(employees);
            FileWriter newEmployeeInfo = new FileWriter(fileName);
            String lineRead;
            String name;
            boolean found = false;

            while(!found){
                lineRead = read.nextLine();
                name = lineRead.substring(0, lineRead.indexOf(" ")); // txt.file should be space seperated
                if(name.equals(target) {
                    newEmployeeInfo.write(worker.name);
                    newEmployeeInfo.write(worker.getPerferredRole);
                    newEmployeeInfo.write(worker.leadershipRating);
                    newEmployeeInfo.write(worker.getCollabortaionRating);
                    newEmployeeInfo.write(worker.getCodingSpeed);
                    newEmployeeInfo.write(worker.getCodeDesign); // this block is the same as the last, consider a way to reuse without typing again
                    found = true;
                }
            }
        }
        catch(FileNotFoundException excpt){
            System.out.println("Error opening file");
        }
        finally{
            newEmployeeInfo.close();
            read.close();
        }

    }

    /**
    * Returns an ArrayList of the companies employees.
    * */
    public ArrayList<Employee> getList(){
        return employeesList;
    }

    /**
    * Reads info from specified file, upon creation of an object.
    *
    * @param name of file to be read.
    * */
    public void FileReaderWriter(String fileName){
        this.readInfo(fileName);
    }

}
