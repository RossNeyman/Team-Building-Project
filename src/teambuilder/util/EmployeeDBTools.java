package teambuilder.util;

import teambuilder.Employee;
import java.io.IOException;
import java.util.Comparator;
import java.util.Collections;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * Provides utility methods for managing the employee database.
 */

//TODO write edit employee method.
public class EmployeeDBTools extends EmployeeDB {
    /**
     * Constructs an EmployeeDBTools object with the specified data file.
     *
     * @param dataFile The data file containing employee information.
     * @throws IOException If an I/O error occurs.
     */
    public EmployeeDBTools(File dataFile) throws IOException {super(dataFile);}

    /**
     * Adds a new employee to the database with the provided information.
     *
     * @param name       The name of the employee.
     * @param prefRole   The preferred role of the employee.
     * @param leadRate   The leadership rating of the employee.
     * @param collabRate The collaboration rating of the employee.
     * @param codS       The coding speed rating of the employee.
     * @param codD       The coding design rating of the employee.
     */
    public void addEmployee(String name, String prefRole, int leadRate, int collabRate, int codS, int codD){
        int id = new Random().nextInt(900000) + 100000;
        while(checkIDExists(id)){
            id = new Random().nextInt(900000) + 100000;
        }
        employeesList.add(new Employee(name, id, prefRole, leadRate, collabRate, codS, codD));
    }

    /**
     * Removes the specified employee from the database.
     *
     * @param emp The employee to be removed.
     */
    public void removeEmployee(Employee emp){
        employeesList.remove(emp);
    }


    /**
     * Updates stored info in employeesList.
     * @param current
     * @param changed
     */
    public void changeEmployeeInfo(Employee current, Employee changed){
        int index = employeesList.indexOf(current);
        employeesList.set(index, changed);
    }

    /**
     * Checks if an employee with the given ID exists in the database.
     *
     * @param srcID The ID to be checked.
     * @return True if an employee with the given ID exists, otherwise false.
     */
    public boolean checkIDExists(int srcID){
        for(Employee employee : employeesList){
            if (employee.checkID(srcID))
                return true;
        }
        return false;
    }

    /**
     * Searches for an employee in the database by their ID.
     *
     * @param id The ID of the employee to search for.
     * @return The employee with the specified ID.
     * @throws Exception If the employee with the specified ID is not found.
     */
    public Employee searchEmployeeByID(int id) throws Exception {
        for (Employee employee : employeesList) {
                if (employee.getID() == id)
                    return employee;
        }
        throw new Exception("Employee not found");
    }

    /**
     * Searches for an employee in the database by their name.
     *
     * @param nameSrc The name of the employee to search for.
     * @return The employee with the specified name.
     * @throws Exception If the employee with the specified name is not found.
     */
    public Employee searchEmployeeByName(String nameSrc) throws Exception {
        for(Employee employee : employeesList){
            if(employee.getName().equals(nameSrc))
                return employee;
        }
        throw new Exception("Employee not found");
    }

    /**
     * Prints the list of employees in the database.
     */
    public void printList(){
        for(Employee employee : employeesList){
            employee.printNameID();
        }
    }

    /**
     * Sorts the list of employees in the database by collaboration rating.
     */
    public void sortByCollaboration(){
        employeesList.sort(Comparator.comparing(Employee::getCollaborationRating));
        Collections.reverse(employeesList);
    }

    /**
     * Sorts the list of employees in the database by coding design rating.
     */
    public void sortByCodingDesign(){
        employeesList.sort(Comparator.comparing(Employee::getCodingDesign));
        Collections.reverse(employeesList);
    }

    /**
     * Sorts the list of employees in the database by coding speed rating.
     */
    public void sortByCodingSpeed(){
        employeesList.sort(Comparator.comparing(Employee::getCodingSpeed));
        Collections.reverse(employeesList);
    }

    /**
     * Sorts the list of employees in the database by leadership rating.
     */
    public void sortByLeadership(){
        employeesList.sort(Comparator.comparing(Employee::getLeadershipRating));
        Collections.reverse(employeesList);
    }
}
