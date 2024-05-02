package teambuilder.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import teambuilder.Employee;
import teambuilder.Manager;

import java.io.*;
import java.util.ArrayList;

/**
 * EmployeeDB handles reading and writing to an employees info file.
 */
public class EmployeeDB {

    private ObjectMapper mapper = new ObjectMapper();
    private ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
    protected ArrayList<Employee> employeesList = new ArrayList<Employee>();
    protected ArrayList<Manager> managersList = new ArrayList<Manager>();
    private String fileName;

    /**
     * Constructs an EmployeeDB object with the specified file name.
     *
     * @param s The name of the file containing employee data.
     */
    public EmployeeDB (String s){
        fileName = s;
        //readInfo(s);
    }

    /**
     * Converts an Employee object to JSON format.
     *
     * @param employee The Employee object to convert.
     * @return The JSON representation of the Employee object.
     */
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

    /**
     * Converts a JSON string to an Employee object.
     *
     * @param json The JSON string to convert.
     * @return The Employee object parsed from the JSON string.
     */
    public Employee fromJson(String json) {
        Employee employee = null;
        try {
            employee = mapper.readValue(json, Employee.class);
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employee;
    }

    /**
     * Reads employee data from a JSON string.
     *
     * @param json The JSON string containing employee data.
     * @throws IOException If an I/O error occurs while reading the JSON string.
     */
    public void readJSON(String json) throws IOException {
        employeesList = mapper.readValue(json, mapper.getTypeFactory().constructCo
