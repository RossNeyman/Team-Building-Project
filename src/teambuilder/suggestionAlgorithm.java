package teambuilder;
import teambuilder.util.EmployeeDBTools;

import java.util.ArrayList;
import java.util.*;
import teambuilder.TeamBuilder;

public class suggestionAlgorithm{
    private final int attributeNum = 4;
    private final int maxScoreIndividual = attributeNum * 10;
    private final double minPercent = 0.7;
    private int teamCountMax; // has a default value;
    private int maxScore; // the calculation should be done in a constructor.
    private int memberCount = 0; // The following operations of this class should not be performed if the teamCount is less than 1.
    private int desiredTeamScore; // based on the entered desired team member count.
    private int currentTeamScore; // based on the current number of employees
    private int currentScore;
    private int minScore;
    private int priority = 'N'; // min value will be 0 and max 4.  Ranging from no priority to speed, design, collaboration, and leadership. // ignore

    private char additionPriority; // stores the suggesting priority, value should be entered in constructor.
    // selection is as follows: T for team, S for speed, D for design, C for collab, and L for leadership. Also default value will be N for none.
    private EmployeeDBTools dataB; // provides access to the database.
    private ArrayList<Employee> db; // there has to be a better way to get access to the database.

    /**
     * parameterized constructor supports database access, priority selection, and max member change.
     * @param db
     * @param aPriority
     * @param maxMembers
     */
    public suggestionAlgorithm(EmployeeDBTools db, char aPriority, int maxMembers){
        dataB = db;
        additionPriority = aPriority;
        setTeamMax(maxMembers);
        currentTeamScore = 0;
    }

    /**
     * Parameterized constructor set team max, without priority.
     * @param db
     * @param maxMembers
     */
    public suggestionAlgorithm(EmployeeDBTools db, int maxMembers){
        dataB = db;
        setTeamMax(maxMembers);
        currentTeamScore = 0;
    }

    /**
     * parameterized constructor provides db support.
     * The constructor sets default values.
     * @param db
     */
    public suggestionAlgorithm(EmployeeDBTools db){
        dataB = db;
        teamCountMax = 4;
        currentTeamScore = 0;
    }

    /**
     * Calcculates the maximum score the team can have.
     * Must have a value in teamCountMax stored first. For this method to be used.
     */
    public void maxScoreCalc(){
        maxScore = maxScoreIndividual * teamCountMax;
    }

    /**
     * Sets the max value for the team.
     * @param max
     */
    public void setTeamMax(int max){
        teamCountMax = max;
        maxScoreCalc();
    }

    /**
     * Calculates the minimum acceptable score for a team.
     * @return
     * @throws Exception
     */
    public double minReqScoreCalc(){
        if(memberCount > 0){
            return (double)maxScore * minPercent;
        }
        else return -1;
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

    //TODO alter suggest method to accomadate the mapping done in the dbtools file.
    //current score suggestion only makes sense for suggesting changes to current team.
    public Employee Suggest() throws Exception{
        HashMap<Integer, Integer> mappedScores = dataB.getScores();

        currentScoreCalc();
        double min = minReqScoreCalc();
        if(currentTeamScore < min){
            Integer target = -1;
            int count = 0;
            if(min == -1){
                // throw an exception.
                throw new Exception("Team currently has no members.");
            }
            else{
                double combo = min - currentTeamScore;
                do{
                    //there is more to consider here,
                    combo = combo / 2;
                    count++;
                }
                while(combo > maxScoreIndividual);

                //TODO while searching, look for the score that has the smallest difference with the calculated target.
                for(Map.Entry<Integer, Integer> sco: mappedScores.entrySet()){
                    if(sco.getKey() >= combo){
                        target = sco.getKey();
                    }
                }
            }
            if((int)target != -1){
                try{
                    return dataB.searchEmployeeByScore((int)target);
                    // maybe throwing an exception is not helpful.
                }
                catch(Exception excpt){
                    excpt.getMessage();
                }
            }

            //then find score combo that will allow team to sastify minReq
            //if score combo is greater than max individual score, divide until equal to max or less than,
            //also keep count how many times value is divided by.
            //find score or scores in map that match the divided combo score or are greater than combo
            //take highest score, then find employee with said score, and return.

        }
        throw new Exception("Suggestion could not be performed.");
    }

    /**
     * Suggests user with team additions, in the simplest form.
     * requires connection to team list, and employee db
     * return null if no potential employee can be found. Does not re-suggest employees already on team.
     * @param team
     * @return
     */
    public Employee simpleSuggest(TeamBuilder team){
        // Sort employeeDB by scores
        // start from the highest score, check if score is already on team
        // if not add employee to team.
        // entirely based on access to the employeeDB.
        Employee suggestedWorker = null;
        dataB.sortByScore();
        db = dataB.getDB();
        int n = db.size();

        for(int i = 0; i < n; i++){
            if(!(team.onTeam(db.get(i)))){
                suggestedWorker = db.get(i);
            }
        }

        return suggestedWorker;
    }
}