package teambuilder;

public class suggestionAlgorithm{
    private final int attributeNum = 4;
    private final int maxScoreIndividual = attributeNum * 10;
    private int teamCountMax;
    private final int maxScore = maxScoreIndividual * teamCountMax;
    private int teamCount = 0; // The following operations of this class should not be performed if the teamCount is less than 1.
    private int teamScore;
    private int minScore;

    public void setTeamMax(int max){
        this.teamCountMax = max;
    } // may not need this, when creating constructor.


}