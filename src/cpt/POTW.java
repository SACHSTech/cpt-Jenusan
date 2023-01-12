package cpt;

public class POTW {

    private String name;
    private String team;
    private String year;
    private String position;
    
    public POTW(String name, String team, String year, String position){
        this.name = name;
        this.team = team;
        this.year = year;
        this.position = position;
    }

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
