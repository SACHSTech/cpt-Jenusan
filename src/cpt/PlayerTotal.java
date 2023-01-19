package cpt;
import java.util.*;
import java.util.ArrayList;


public class PlayerTotal extends TeamTotal{
    TeamTotal TeamTotal;
    Hashtable <String, Integer> playertotals;
    ArrayList<POTW> singleTeam;
    ArrayList <String> names;

    public PlayerTotal(String str, int Start, int End){
        super(Start, End);
        TeamTotal = new TeamTotal(Start, End);
        playertotals = new Hashtable<>();
        singleTeam = new ArrayList<>();
        names = new ArrayList<>();
        for (int i = 0; i < TeamTotal.getShortList().size(); i++){
            if ((TeamTotal.getShortList().get(i).getTeam()).equals(str)){
                singleTeam.add(TeamTotal.getShortList().get(i));
            }
        }
        Hashtable();
    }

    // only needs to iterate once
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

    public void print(){
        System.out.println(playertotals);
    }
    public int getPlayerCount(){
        return playertotals.size();
    }
    public Hashtable <String, Integer> getTable(){
        return playertotals;
    }
    public ArrayList<String> getNameList(){
        return names;
    }
}
