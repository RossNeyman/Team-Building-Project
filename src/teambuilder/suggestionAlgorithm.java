package teambuilder;
import java.util.ArrayList;
import java.util.Map;

public class suggestionAlgorithm{
    private final int attributeNum = 4;
    private final int maxScoreIndividual = attributeNum * 10;
    private int teamCountMax; // value should be set in a constructor.
    private final int maxScore = maxScoreIndividual * teamCountMax; // the calculation should be done in a constructor.
    private int memberCount = 0; // The following operations of this class should not be performed if the teamCount is less than 1.
    private int desiredTeamScore; // based on the entered desired team member count.
    private int currentTeamScore; // based on the current number of employees
    private int currentScore;
    private int minScore;
    private int priority; // min value will be 0 and max 4.  Ranging from no priority to speed, design, collaboration, and leadership.
    private Map<Integer, Integer> mappedScores; // key is an employee score, and value is the count of employees with said score.

    private char additionPriority; // stores the suggesting priority, value should be entered in constructor.
    // selection is as follows: T for team, S for speed, D for design, C for collab, and L for leadership.

    public void setTeamMax(int max){
        this.teamCountMax = max;
    } // may not need this, when creating constructor.

    /**
     * Calculates the minimum acceptable score for a team.
     * @return
     * @throws Exception
     */
    public double minReqScoreCalc() throws Exception{
        if(memberCount > 0){
            return (double)maxScore * 0.7;
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
     * @param value
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

}