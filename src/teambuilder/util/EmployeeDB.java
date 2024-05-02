package teambuilder.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import teambuilder.Employee;
import teambuilder.Manager;

import java.io.*;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




//
//* Handles reading and writing to an employees info file.

public class EmployeeDB {

    private ObjectMapper mapper = new ObjectMapper();
    private ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
    protected ArrayList<Employee> employeesList = new ArrayList<Employee>();
    protected ArrayList<Manager> managersList = new ArrayList<Manager>();
    private String fileName;
    public ArrayList<Employee> getList() {
        return employeesList;
    }
    public EmployeeDB (String s){
        fileName = s;
        //readInfo(s);
    }
    public String toJson(Employee employee) {
        String json = null;
        try {
            json = mapper.writeValueAsString(employee);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Employee fromJson(String json) {
        Employee employee = null;
        try {
            employee = mapper.readValue(json, Employee.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return employee;
    }

    public void readJSON(String json) throws IOException {
        employeesList = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Employee.class));
    }
    public void writeJSON() throws IOException {
        for(Employee employee : employeesList){
            writer.writeValue(new File(fileName),employee);
        }
    }
    public void addEmp(String name, int ID, String pr, int l, int col, int codD, int codS){
        employeesList.add(new Employee(name, ID, pr, l, col, codD, codS));
    }

    public void printList(){
        for(Employee employee : employeesList){
                employee.printNameID();
                System.out.println("--------------------");
        }
    }
}
