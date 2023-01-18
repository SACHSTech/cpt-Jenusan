package cpt;

public class POTW {

    // initializing variables
    private String name;
    private String team;
    private String year;
    
    // constructor
    public POTW(String name, String team, String year){
        this.name = name;
        this.team = team;
        this.year = year;
    }

    // getter methods
    public String getName(){
        return this.name;
    }

    public String getTeam(){
        return this.team;
    }

    public String getYear(){
        return this.year;
    }

    

}
