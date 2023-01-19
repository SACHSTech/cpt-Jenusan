package cpt;
import java.util.*;
import java.io.*; 
import java.io.IOException;

public class TeamTotal {

    Data longList;
    Hashtable<String, Integer> totals;
    Hashtable<String, Integer> usable;
    ArrayList<POTW> shortList;
    ArrayList<String> Teams;
    String file = "src\\cpt\\0 Teamlist.txt";
    String line;



    public TeamTotal(){
        longList = new Data();
        totals =  new Hashtable<String, Integer>();
        Teams = new ArrayList<>();
    }

    public void shortenList(int start, int end){
        shortList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                totals.put(line, 0);
                Teams.add(line);
            }
        }catch (Exception e){
            System.out.print(e);
        }
        
        for(int i = 0; i < longList.getLength(); i++){
            if (Integer.valueOf(longList.getYear(i)) <= start && Integer.valueOf(longList.getYear(i)) >= end){
                shortList.add(longList.getInstance(i));
            }
        }
        fill();
    }

    public void fill(){
        for (int i = 0; i < shortList.size(); i++){
            totals.put(shortList.get(i).getTeam(), totals.get(shortList.get(i).getTeam()) + 1);
        }
    }

    public int getLength(){
        return totals.size();
    }
    public ArrayList<String> getTeamList(){
        return Teams;
    }
    public Hashtable<String, Integer> getTable(){
        return totals;
    }



}
