public class Employee extends Person {
    private int leadershipRating;
    private int collaborationRating;
    private int codingSpeed;
    private int codingDesign;
    private String preferredRole;

    public Employee(){
        name = null;
        leadershipRating = 0;
        collaborationRating = 0;
        codingSpeed = 0;
        codingDesign = 0;
        preferredRole = null;
    }
    public Employee(String n, int l, int col, int codS, int codD, String p) {
        name = n;
        leadershipRating = l;
        collaborationRating = col;
        codingSpeed = codS;
        codingDesign = codD;
        preferredRole = p;
    }

    public int getLeadershipRating(){return leadershipRating;}
    public int getCollaborationRating() {return collaborationRating;}
    public int getCodingDesign() {return codingDesign;}
    public int getCodingSpeed() {return codingSpeed;}
}
