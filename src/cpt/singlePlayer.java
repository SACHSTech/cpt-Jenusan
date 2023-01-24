package cpt;
import java.util.*;

public class singlePlayer {

    Hashtable<String, Integer> totals;
    ArrayList<String> names;
    Data data; 
    public singlePlayer(String str){
        totals = new Hashtable<>();
        names = new ArrayList<>();
        data = new Data();

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
