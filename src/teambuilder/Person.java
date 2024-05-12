package teambuilder;

import java.util.Random;

public abstract class Person {
    protected String name;
    protected int id;


    public Person(){
        name = null;
        id = new Random().nextInt(900000) + 100000;
    }
    public Person(String n){
        name = n;
        id = new Random().nextInt(900000) + 100000;
    }
    public Person(String n, int id){
        name = n;
        this.id = id;
    }
    public void setName(String n) {name = n;}
    public String getName(){return name;}
    public int getID(){return id;}
    public boolean checkID(int n){
        return (n == id);
    }


}
