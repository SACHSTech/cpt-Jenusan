package cpt;
import java.util.*;
import java.util.ArrayList;


public class PlayerTotal {
    TeamTotal TeamTotal;
    Hashtable <String, Integer> playertotals;

    public PlayerTotal(){
        TeamTotal = new TeamTotal(2020, 1900);
        playertotals = new Hashtable<>();
        Hashtable();
    }

    public void Hashtable(){
        System.out.println(TeamTotal.getShortList().size());
        for (int i = 0; i < TeamTotal.getShortList().size(); i++){
            try{
                playertotals.put(TeamTotal.getShortList().get(i).getName(), playertotals.get(TeamTotal.getShortList().get(i).getName()) + 1);
            }catch(Exception e){
                playertotals.put(TeamTotal.getShortList().get(i).getName(), 1);
            }
        }
    }

    public void print(){
        System.out.println(playertotals);
    }
}
