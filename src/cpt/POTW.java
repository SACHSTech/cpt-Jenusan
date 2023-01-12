package cpt;

public class POTW {

    // initializing variables
    private String name;
    private String team;
    private String year;
    private String position;
    
    // constructor
    public POTW(String name, String team, String year, String position){
        this.name = name;
        this.team = team;
        this.year = year;
        this.position = position;
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

    public String getPosition(){
        return this.position;
    }

    

}
