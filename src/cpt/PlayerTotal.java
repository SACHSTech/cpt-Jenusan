package cpt;
import java.util.*;
import java.util.ArrayList;


public class PlayerTotal extends TeamTotal{
    // intializing variables
    TeamTotal TeamTotal;
    Hashtable <String, Integer> playertotals;
    ArrayList<POTW> singleTeam;
    ArrayList <String> names;

    /**
     * playertotal constructor
     * @param str team name
     * @param Start start year 
     * @param End end year
     */
    public PlayerTotal(String str, int Start, int End){
        super(Start, End);
        TeamTotal = new TeamTotal(Start, End);
        playertotals = new Hashtable<>();
        singleTeam = new ArrayList<>();
        names = new ArrayList<>();
        // filling data with given perameters
        for (int i = 0; i < TeamTotal.getShortList().size(); i++){
            if ((TeamTotal.getShortList().get(i).getTeam()).equals(str)){
                singleTeam.add(TeamTotal.getShortList().get(i));
            }
        }
        // running hastable method with arraylist
        Hashtable();
    }

    /**
     * hashtable method to put data in hashtable
     */
    public void Hashtable(){
        for (int i = 0; i < singleTeam.size(); i++){
            try{
                playertotals.put(singleTeam.get(i).getName(), playertotals.get(singleTeam.get(i).getName()) + 1);
            }catch(Exception e){
                playertotals.put(singleTeam.get(i).getName(), 1);
                names.add(singleTeam.get(i).getName());
            }
        }
    }

    /**
     * returns number of players
     */
    public int getPlayerCount(){
        return playertotals.size();
    }
    /**
     * returns a hastable to be used in other classes
     */
    public Hashtable <String, Integer> getTable(){
        return playertotals;
    }
    /**
     * returns arraylist to be used in other classes
     * @return arraylist
     */
    public ArrayList<String> getNameList(){
        return names;
    }
}
