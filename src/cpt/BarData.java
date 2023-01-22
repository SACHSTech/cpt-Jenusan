package cpt;
import java.util.*;

public class BarData {
    BarPlayerData barPlayerData;
    Hashtable <String, BarPlayerData> playerstats;
    public BarData(ArrayList<String> players){

        for (int i = 0; i < players.size(); i++){
            playerstats.put(players.get(i), new BarPlayerData("0", 0));
        }
    }
}
