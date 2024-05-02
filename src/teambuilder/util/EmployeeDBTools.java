package teambuilder.util;

import teambuilder.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EmployeeDBTools extends EmployeeDB {

    public EmployeeDBTools(String fileName){super(fileName);}

    public Employee searchEmployeeByID(int id) throws Exception {
        for (Employee employee : employeesList) {
                if (employee.getID() == id)
                    return employee;
        }
        throw new Exception("Employee not found");
    }

    public Employee searchEmployeeByName(String nameSrc) throws Exception {
        for(Employee employee : employeesList){
            if(employee.getName().equals(nameSrc))
                return employee;
        }
        throw new Exception("Employee not found");
    }

    public void swapEmployees(int currentIndex, int swapIndex){
        Employee temp;
        temp = employeesList.get(currentIndex);
        employeesList.set(currentIndex, employeesList.get(swapIndex));
        employeesList.set(swapIndex, temp);
    }
    public void sortByCollaboration(){
        for(int i = 0;i<employeesList.size();i++){
            for(int j=0;j<employeesList.size()-i;i++) {
                if (employeesList.get(i).getCollaborationRating() <= employeesList.get(i + 1).getCollaborationRating())
                    swapEmployees(i,i+1);
            }
        }
    }
    public void sortByCodingDesign(){
        for(int i = 0;i<employeesList.size();i++){
            for(int j=0;j<employeesList.size()-i;i++) {
                if (employeesList.get(i).getCodingDesign() <= employeesList.get(i + 1).getCodingDesign())
                    swapEmployees(i,i+1);
            }
        }
    }
    public void sortByCodingSpeed(){
        for(int i = 0;i<employeesList.size();i++){
            for(int j=0;j<employeesList.size()-i;i++) {
                if (employeesList.get(i).getCodingSpeed() <= employeesList.get(i + 1).getCodingSpeed())
                    swapEmployees(i,i+1);
            }//
        }
    }
    public void sortByLeadership(){
        for(int i = 0;i<employeesList.size();i++){
            for(int j=0;j<employeesList.size()-i;i++) {
                if (employeesList.get(i).getLeadershipRating() <= employeesList.get(i + 1).getLeadershipRating())
                    swapEmployees(i,i+1);
            }
        }
    }
}
