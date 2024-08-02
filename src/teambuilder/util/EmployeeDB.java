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
import java.nio.file.StandardOpenOption;
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
     * @param dataFile the file for reading and writing information
     */
    public EmployeeDB (File dataFile) throws IOException {
        this.dataFile = dataFile;
        readJSON();
    }
    public void writeJson() throws IOException {
        writer.writeValue(dataFile, "");
        mapper.writeValue(dataFile, employeesList);
    }

    /**
     * Reads employee data from a JSON string.
     *
     * @throws IOException If an I/O error occurs while reading the JSON string.
     */
    public void readJSON() throws IOException {
        String json = new String(Files.readAllBytes(dataFile.toPath()));
        employeesList = mapper.readValue(
                json, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Employee.class));
    }

    /**
     * Returns the database, in its current state.
     * The returned database, is not used at all for additions to the database.
     * @return
     */
    public final ArrayList<Employee> getDB(){
        return employeesList;
    }
}