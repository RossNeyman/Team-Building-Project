import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Sorting {
    private ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
    //Uses ArrayList for speed in sorting algorithms being more of a priority than memory management

    public void readData(File f) throws FileNotFoundException {
        Scanner myReader = new Scanner(f);
        while (myReader.hasNextLine()) {
            employeeArrayList.add(new Employee(
                    myReader.nextLine(), //name
                    myReader.nextInt(),  //ID
                    myReader.nextInt(),  //leadershipRating
                    myReader.nextInt(),  //collaborationRating
                    myReader.nextInt(),  //codingSpeed
                    myReader.nextInt(),  //codingDesign
                    myReader.nextLine()  //preferredRole
            ));
        }
    }
    public void writeData(File f) throws FileNotFoundException {

    }

}
