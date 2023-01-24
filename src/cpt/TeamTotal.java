package cpt;
import java.util.*;
import java.io.*; 
import java.io.IOException;

public class TeamTotal {

    // initializing variables
    Data longList;
    Hashtable<String, Integer> totals;
    Hashtable<String, Integer> usable;
    ArrayList<POTW> shortList;
    ArrayList<String> Teams;
    String file = "src\\cpt\\0 Teamlist.txt";
    String line;


    /**
     * team total constructor
     * @param start start year
     * @param end end year
     */
    public TeamTotal(int start, int end){
        longList = new Data();
        totals =  new Hashtable<String, Integer>();
        Teams = new ArrayList<>();
        shortList = new ArrayList<>();
        shortList = new ArrayList<>();
        
        // file IOs data
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                totals.put(line, 0);
                Teams.add(line);
            }
        }catch (Exception e){
            System.out.print(e);
        }
        
        // fills in data with peramters as long as they fit into specified years
        for(int i = 0; i < longList.getLength(); i++){
            if (Integer.valueOf(longList.getYear(i)) <= start && Integer.valueOf(longList.getYear(i)) >= end){
                shortList.add(longList.getInstance(i));
            }
        }
        for (int i = 0; i < shortList.size(); i++){
            totals.put(shortList.get(i).getTeam(), totals.get(shortList.get(i).getTeam()) + 1);
        }
    }

    /**
     * returns length of arraylist
     */
    public int getLength(){
        return totals.size();
    }
    /**
     * returns arraylist to be used in other class
     * @return
     */
    public ArrayList<String> getTeamList(){
        return Teams;
    }
    /**
     * returns hashtable to be used in other class
     * @return
     */
    public Hashtable<String, Integer> getTable(){
        return totals;
    }
    /**
     * returns arraylist to be used in other class
     * @return
     */
    public ArrayList<POTW> getShortList(){
        return shortList;
    }


}
