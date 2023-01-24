package cpt;

public class POTW {

    // initializing variables
    private String name;
    private String team;
    private String year;
    
    /**
     * constructor
     * @param name player name 
     * @param team team name
     * @param year year
     */
    public POTW(String name, String team, String year){
        this.name = name;
        this.team = team;
        this.year = year;
    }

    /**
     * get player anme
     * @return
     */
    public String getName(){
        return this.name;
    }
    /**
    * 
    * @return team name
    */
    public String getTeam(){
        return this.team;
    }

    /**
     * 
     * @return year
     */
    public String getYear(){
        return this.year;
    }

    

}
