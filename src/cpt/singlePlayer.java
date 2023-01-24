package cpt;
import java.util.*;

public class SinglePlayer {

    // initializing variables
    Hashtable<String, Integer> totals;
    ArrayList<String> names;
    Data data; 

    /**
     * singple player constructor, gets data for a singlek player
     * @param str player name
     */
    public SinglePlayer(String str){
        totals = new Hashtable<>();
        names = new ArrayList<>();
        data = new Data();

        //creates hash data for player
        try{
            for (int i = 0; i < data.DataList.size(); i++){
                if (data.DataList.get(i).getName().equals(str)){
                try{
                totals.put(str, totals.get(str) + 1);
                }catch(Exception e){
                    totals.put(str, 1);
                    names.add(str);
                }
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
