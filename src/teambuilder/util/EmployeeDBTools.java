package teambuilder.util;

import teambuilder.Employee;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EmployeeDBTools extends EmployeeDB {
    public EmployeeDBTools(File dataFile) throws IOException {super(dataFile);}
    public void addEmployee(String name, String prefRole, int leadRate, int collabRate, int codS, int codD){
        int id = new Random().nextInt(900000) + 100000;
        while(checkIDExists(id)){
            id = new Random().nextInt(900000) + 100000;
        }
        employeesList.add(new Employee(name, id, prefRole, leadRate, collabRate, codS, codD));
    }
    public void removeEmployee(Employee emp){
        employeesList.remove(emp);
    }
    public boolean checkIDExists(int srcID){
        for(Employee employee : employeesList){
            if (employee.checkID(srcID))
                return true;
        }
        return false;
    }
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
    public void printList(){
        for(Employee employee : employeesList){
            employee.printNameID();
        }
    }
    public void swapEmployees(int currentIndex, int swapIndex){
        Employee temp;
        temp = employeesList.get(currentIndex);
        employeesList.set(currentIndex, employeesList.get(swapIndex));
        employeesList.set(swapIndex, temp);
    }
    public void sortByCollaboration(){
        employeesList.sort(Comparator.comparing(Employee::getCollaborationRating));
    }
    public void sortByCodingDesign(){
        employeesList.sort(Comparator.comparing(Employee::getCodingDesign));
    }
    public void sortByCodingSpeed(){
        employeesList.sort(Comparator.comparing(Employee::getCodingSpeed));
    }
    public void sortByLeadership(){
        employeesList.sort(Comparator.comparing(Employee::getLeadershipRating));
    }
}
