package teambuilder.util;

import teambuilder.Employee;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * EmployeeDBTools provides utility methods to manage an employee database.
 */
public class EmployeeDBTools extends EmployeeDB {

    /**
     * Constructs an EmployeeDBTools object with the specified file name.
     *
     * @param fileName The name of the file containing employee data.
     */
    public EmployeeDBTools(String fileName){
        super(fileName);
    }

    /**
     * Searches for an employee in the database by ID.
     *
     * @param id The ID of the employee to search for.
     * @return The employee with the specified ID.
     * @throws Exception If the employee with the given ID is not found.
     */
    public Employee searchEmployeeByID(int id) throws Exception {
        for (Employee employee : employeesList) {
            if (employee.getID() == id)
                return employee;
        }
        throw new Exception("Employee not found");
    }

    /**
     * Searches for an employee in the database by name.
     *
     * @param nameSrc The name of the employee to search for.
     * @return The employee with the specified name.
     * @throws Exception If the employee with the given name is not found.
     */
    public Employee searchEmployeeByName(String nameSrc) throws Exception {
        for(Employee employee : employeesList){
            if(employee.getName().equals(nameSrc))
                return employee;
        }
        throw new Exception("Employee not found");
    }

    /**
     * Swaps two employees in the employees list.
     *
     * @param currentIndex The index of the first employee to swap.
     * @param swapIndex The index of the second employee to swap.
     */
    public void swapEmployees(int currentIndex, int swapIndex){
        Employee temp;
        temp = employeesList.get(currentIndex);
        employeesList.set(currentIndex, employeesList.get(swapIndex));
        employeesList.set(swapIndex, temp);
    }

    /**
     * Sorts the employees list by collaboration rating.
     */
    public void sortByCollaboration(){
        for(int i = 0;i<employeesList.size();i++){
            for(int j=0;j<employeesList.size()-i;i++) {
                if (employeesList.get(i).getCollaborationRating() <= employeesList.get(i + 1).getCollaborationRating())
                    swapEmployees(i,i+1);
            }
        }
    }

    /**
     * Sorts the employees list by coding design rating.
     */
    public void sortByCodingDesign(){
        for(int i = 0;i<employeesList.size();i++){
            for(int j=0;j<employeesList.size()-i;i++) {
                if (employeesList.get(i).getCodingDesign() <= employeesList.get(i + 1).getCodingDesign())
                    swapEmployees(i,i+1);
            }
        }
    }

    /**
     * Sorts the employees list by coding speed rating.
     */
    public void sortByCodingSpeed(){
        for(int i = 0;i<employeesList.size();i++){
            for(int j=0;j<employeesList.size()-i;i++) {
                if (employeesList.get(i).getCodingSpeed() <= employeesList.get(i + 1).getCodingSpeed())
                    swapEmployees(i,i+1);
            }
        }
    }

    /**
     * Sorts the employees list by leadership rating.
     */
    public void sortByLeadership(){
        for(int i = 0;i<employeesList.size();i++){
            for(int j=0;j<employeesList.size()-i;i++) {
                if (employeesList.get(i).getLeadershipRating() <= employeesList.get(i + 1).getLeadershipRating())
                    swapEmployees(i,i+1);
            }
        }
    }
}
