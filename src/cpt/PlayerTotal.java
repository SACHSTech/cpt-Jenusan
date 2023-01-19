package cpt;
import java.util.*;
import java.util.ArrayList;


public class PlayerTotal {
    TeamTotal TeamTotal;
    Hashtable <String, Integer> playertotals;
    ArrayList<POTW> singleTeam;

    public PlayerTotal(String str){
        TeamTotal = new TeamTotal(2020, 1900);
        playertotals = new Hashtable<>();
        singleTeam = new ArrayList<>();
        for (int i = 0; i < TeamTotal.getShortList().size(); i++){
            if ((TeamTotal.getShortList().get(i).getTeam()).equals(str)){
                singleTeam.add(TeamTotal.getShortList().get(i));
            }
        }
        Hashtable();
    }

    public void Hashtable(){
        for (int i = 0; i < singleTeam.size(); i++){
            try{
                playertotals.put(singleTeam.get(i).getName(), playertotals.get(singleTeam.get(i).getName()) + 1);
            }catch(Exception e){
                playertotals.put(singleTeam.get(i).getName(), 1);
            }
        }
    }

    public void print(){
        System.out.println(playertotals);
    }
}
