package teambuilder.util;

import teambuilder.Employee;
import teambuilder.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;



//
 //* Handles reading and writing to an employees info file.

public class FileReaderWriter {
    protected ArrayList<Employee> employeesList = new ArrayList<Employee>();
    protected ArrayList<Manager> managersList = new ArrayList<Manager>();

    public ArrayList<Employee> getList() {
        return employeesList;
    }

    private String fileName;

    // write an update function, to refresh the search.

    /**
     * Reads info from specified file, upon creation of an object.
     * @param  f filename
     */
    public FileReaderWriter(String f){
        try{
            fileName = f;
            this.readInfo(f);
        }
        catch(FileNotFoundException except){
            System.out.println("Error opening " + fileName);
            throw new RuntimeException(except);
        }
        catch(RuntimeException except){

        }
    }

    /**
     * Reads info from a file, and parses said info.
     * Only meant to be used by methods in the class.
     * @param f fileName
     */
    private void readInfo(String f) throws FileNotFoundException{
        try {
            File employees = new File(fileName);
            Scanner read = new Scanner(employees);

            while (read.hasNext()) {
                Employee worker = new Employee(
                        read.next(),
                        read.nextInt(),
                        read.next(),
                        read.nextInt(),
                        read.nextInt(),
                        read.nextInt(),
                        read.nextInt());
                employeesList.add(worker);
            }
            read.close();
        }
        catch(FileNotFoundException except){
            System.out.println("Error opening " + fileName);
            throw new RuntimeException(except);
        }
        catch(RuntimeException except){

        }
        finally{

        }

    }

        //no need to put read.close() again, the only case where this line is used is if file can't open,
        //therefore there is no need to close the scanner.

    /**
     * Adds new employee info to employees file.
     *
     * @param worker   the worker
     * @param fileName the file name
     */
    public void newEntry(Employee worker, String fileName) {
        try (FileWriter newEmployee = new FileWriter(fileName)) {
            this.readInfo(fileName);
            newEmployee.write(worker.getName());
            newEmployee.write(worker.getID());
            newEmployee.write(worker.getPreferredRole());
            newEmployee.write(worker.getLeadershipRating());
            newEmployee.write(worker.getCollaborationRating());
            newEmployee.write(worker.getCodingSpeed());
            newEmployee.write(worker.getCodingDesign());
        } catch (FileNotFoundException except) {
            System.out.println("Error opening file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException except) {

        } finally {

        }
    }

    /**
     * updates the info of already existing employees.
     * @param worker     the worker
     * @param target the worker name
     * @param fileName   the file name
     */
    public void updateEntry(Employee worker, String target, String fileName){
        try (FileWriter newEmployeeInfo = new FileWriter(fileName)){
            File employees = new File(fileName);
            Scanner read = new Scanner(employees);

            String lineRead;
            String name;
            boolean found = false;

            while(!found){
                lineRead = read.nextLine();
                name = lineRead.substring(0, lineRead.indexOf(" ")); // txt.file should be space seperated
                if(name.equals(target)) {
                    newEmployeeInfo.write(worker.getName());
                    newEmployeeInfo.write(worker.getID());
                    newEmployeeInfo.write(worker.getPreferredRole());
                    newEmployeeInfo.write(worker.getLeadershipRating());
                    newEmployeeInfo.write(worker.getCollaborationRating());
                    newEmployeeInfo.write(worker.getCodingSpeed());
                    newEmployeeInfo.write(worker.getCodingDesign()); // this block is the same as the last, consider a way to reuse without typing again
                    found = true;
                }
            }
            read.close();
        }
        catch(FileNotFoundException except){
            System.out.println("Error opening file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch(RuntimeException except){

        }
        finally{

        }
    }

    /**
     * Refreshes the file search.
     * @param f file's name.
     */
    public void updateSearch(String f){
        try{
            this.readInfo(f);
        }
        catch(FileNotFoundException except){
            System.out.println("Error opening " + fileName);
            throw new RuntimeException(except);
        }
        catch(RuntimeException except){

        }

    }


    /*public void displayWorkers() {
        int len = employeesList.size();
        for (int i = 0; i < len; i++) {
            System.out.println(employeesList.get(i).getName());
            System.out.println(employeesList.get(i).getID());
            System.out.println(employeesList.get(i).getPreferredRole());
            System.out.println(employeesList.get(i).getLeadershipRating());
            System.out.println(employeesList.get(i).getCodingDesign());
            System.out.println(employeesList.get(i).getCodingSpeed());
            System.out.println(employeesList.get(i).getCollaborationRating());
        }

    }*/

}
