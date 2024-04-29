package teambuilder;

import java.util.Random;

public abstract class Person {
    protected String name;
    protected int ID;


    public Person(){
        name = null;
        ID = new Random().nextInt(900000) + 100000;
    }
    public Person(String n){
        name = n;
        ID = new Random().nextInt(900000) + 100000;
    }
    public Person(String n, int id){
        name = n;
        ID = id;
    }
    public void setName(String n) {name = n;}
    public String getName(){return name;}
    public int getID(){return ID;}
    public boolean checkID(int n){
        return (n == ID);
    }

}
