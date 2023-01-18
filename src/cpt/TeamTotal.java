package cpt;
import java.util.*;
import java.util.ArrayList;
import java.io.*; 
import java.io.IOException;

public class TeamTotal {

    Data longList;
    Hashtable<String, Integer> totals;
    ArrayList<POTW> shortList;
    String file = "src\\cpt\\0 Teamlist.txt";
    String line;



    public TeamTotal(){
        longList = new Data();
        totals =  new Hashtable<String, Integer>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                totals.put(line, 0);
            }
        }catch (Exception e){
            System.out.print(e);
        }
    }

    public void list(int start, int end){
        shortList = new ArrayList<>();
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

    public void print(){
        System.out.println(totals.get("Los Angeles Lakers"));
    }



}
