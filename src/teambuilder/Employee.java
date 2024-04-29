package teambuilder;

import java.util.ArrayList;

public class Employee extends Person {
    private int leadershipRating;
    private int collaborationRating;
    private int codingSpeed;
    private int codingDesign;
    private String preferredRole;


    public Employee(){
        super();
        leadershipRating = 0;
        collaborationRating = 0;
        codingSpeed = 0;
        codingDesign = 0;
        preferredRole = null;
    }
    public Employee(String n, int id, String p, int l, int col, int codS, int codD) {
        name = n;
        ID = id;
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
    public String getPreferredRole() {return preferredRole;}

    public void setLeadershipRating(int n){leadershipRating = n;}
    public void setCollaborationRating(int n) {collaborationRating = n;}
    public void setCodingDesign(int n) {codingDesign = n;}
    public void setCodingSpeed(int n) {codingSpeed = n;}
    public void setPreferredRole(String s) {preferredRole = s;}

}
