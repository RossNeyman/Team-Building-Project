package teambuilder.util;

import teambuilder.Employee;
import teambuilder.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;

//import Employee.java;


//
//* Handles reading and writing to an employees info file.

public class FileReaderWriter {
    protected ArrayList<Employee> employeesList = new ArrayList<Employee>();
    protected ArrayList<Manager> managersList = new ArrayList<Manager>();

    public ArrayList<Employee> getList() {
        return employeesList;
    }

    /**
     * Reads the given file, into list of employees.
     * The info read from the file is parsed and stored accordingly.
     */

    private void readInfo(String fileName) {
        try {
            File employees = new File(fileName);
            Scanner read = new Scanner(employees);

            while (read.hasNext()) {
                employeesList.add(
                        new Employee(
                                read.next(),
                                read.nextInt(),
                                read.next(),
                                read.nextInt(),
                                read.nextInt(),
                                read.nextInt(),
                                read.nextInt()));
                // input is {name, ID, preferred role, leaderShip rating, collaboration rating, coding Speed, code design}
            }
            read.close();
        } catch (FileNotFoundException except) {
            System.out.println("Error opening file");
            throw new RuntimeException(except);
        }
    }
        /**
         * Adds new employee info to employees file.
         *
         * @param worker   the worker
         * @param fileName the file name
         */

        public void newEntry(Employee worker, String fileName){
            try{
                File employees = new File(fileName);
                Scanner read = new Scanner(employees);
                FileWriter newEmployeeInfo = new FileWriter(fileName);
                String lineRead;

                while(read.hasNext()){
                    lineRead = read.nextLine();
                }
                newEmployeeInfo.write(worker.getName());
                newEmployeeInfo.write(worker.getID());
                newEmployeeInfo.write(worker.getPreferredRole());
                newEmployeeInfo.write(worker.getLeadershipRating());
                newEmployeeInfo.write(worker.getCollaborationRating());
                newEmployeeInfo.write(worker.getCodingSpeed());
                newEmployeeInfo.write(worker.getCodingDesign());


            }
            catch(FileNotFoundException except){
                System.out.println("Error opening file");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } //finally{
            //newEmployeeInfo.close();
            //read.close();
        }


        /**
         * updates the info of already existing employees.
         *
         * @param worker     the worker
         * @param workerName the worker name
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
            }
            catch(FileNotFoundException excpt){
                System.out.println("Error opening file");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//        } finally{
//            newEmployeeInfo.close();
//            read.close();
        }
}
