package teambuilder.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import teambuilder.Employee;
import teambuilder.Manager;

import java.io.*;
import java.nio.file.Files;
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
    private String jsonData;
    private File dataFile;

    /**
     * Constructs an EmployeeDB object with the specified file name.
     *
     * @param s The name of the file containing employee data.
     */
    public EmployeeDB (File dataFile) throws IOException {
        this.dataFile = dataFile;
        readJSON();
    }
    public void writeJson() throws IOException {
        mapper.writeValue(dataFile, employeesList);
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
     * @param //json The JSON string containing employee data.
     * @throws IOException If an I/O error occurs while reading the JSON string.
     */
    public void readJSON() throws IOException {
        String json = new String(Files.readAllBytes(dataFile.toPath()));
        employeesList = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Employee.class));
    }
}