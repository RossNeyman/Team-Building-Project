package teambuilder;
import teambuilder.util.EmployeeDBTools;

import java.util.ArrayList;
import java.util.Map;

public class suggestionAlgorithm{
    private final int attributeNum = 4;
    private final int maxScoreIndividual = attributeNum * 10;
    private final double minPercent = 0.7;
    private int teamCountMax; // has a default value;
    private final int maxScore = maxScoreIndividual * teamCountMax; // the calculation should be done in a constructor.
    private int memberCount = 0; // The following operations of this class should not be performed if the teamCount is less than 1.
    private int desiredTeamScore; // based on the entered desired team member count.
    private int currentTeamScore; // based on the current number of employees
    private int currentScore;
    private int minScore;
    private int priority = 'N'; // min value will be 0 and max 4.  Ranging from no priority to speed, design, collaboration, and leadership. // ignore
    private Map<Integer, Integer> mappedScores; // key is an employee score, and value is the count of employees with said score.

    private char additionPriority; // stores the suggesting priority, value should be entered in constructor.
    // selection is as follows: T for team, S for speed, D for design, C for collab, and L for leadership. Also default value will be N for none.
    private EmployeeDBTools dataB; // provides access to the database.

    /**
     * parameterized constructor supports database access, priority selection, and max member change.
     * @param db
     * @param aPriority
     * @param maxMembers
     */
    public suggestionAlgorithm(EmployeeDBTools db, char aPriority, int maxMembers){
        dataB = db;
        additionPriority = aPriority;
        teamCountMax = maxMembers;
        currentTeamScore = 0;
    }

    /**
     * parameterized constructor provides db support.
     * @param db
     */
    public suggestionAlgorithm(EmployeeDBTools db){
        dataB = db;
        teamCountMax = 4;
        currentTeamScore = 0;
    }

    /**
     * Sets the max value for the team.
     * @param max
     */
    public void setTeamMax(int max){
        teamCountMax = max;
    }

    /**
     * Calculates the minimum acceptable score for a team.
     * @return
     * @throws Exception
     */
    public double minReqScoreCalc() throws Exception{
        if(memberCount > 0){
            return (double)maxScore * minPercent;
        }
        else throw new Exception("Team is empty\n");
    }

    /**
     * Calculate the teams current score based on the current member count.
     */
    private void currentScoreCalc(){
        int potential = maxScoreIndividual * memberCount;
        currentTeamScore = currentScore / potential;
    }

    /**
     * Updates the teams current score.
     * @param value value passed should be an employees overall score.
     */
    public void updateScore(int value){
        currentScore += value; // maybe the realtime updates should be handled by the teamBuilder class.
        // Should check if count can be incremented before proceeding.
        memberCount++;
    }

    /**
     * The scores of each employee is mapped by their frequency in the employeeList database.
     * @param list the employeeList database stores in an arrayList.
     */
    private void mapScores(ArrayList<Employee> list){
        Employee temp;
        int employeeScore;
        for(int i = 0; i < list.size(); i++){
            temp = list.get(i);
            employeeScore = temp.getScore();
            if(mappedScores.containsKey(employeeScore)){
                int value = mappedScores.get(employeeScore);
                mappedScores.put((Integer)employeeScore, value++); // maybe the ints need to be wrapped.
            }
            else{
                mappedScores.put(employeeScore, 1);
            }
        }
    }
    //TODO need access to employee database for search and retrevial operations, also consider using this for mapping.

}