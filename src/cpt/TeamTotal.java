package cpt;
import java.util.*;

public class TeamTotal {

    Data longList;
    Hashtable<String, Integer> totals;
    int x;
    int y;


    public TeamTotal(int start, int end){
        longList = new Data();
        totals =  new Hashtable<String, Integer>();
        x=0;
        y=2020;

        for (int i = 0; i <= 30; i++){
            totals.put(longList.getTeam(i), 0);
        }

        while (y >= end){
            if (Integer.valueOf(longList.getYear(x)) <= start){
                totals.put(longList.getTeam(x), totals.get(longList.getTeam(x)) + 1);
            }
            x++;
            y--;
        }

    }

    public void print(){
        System.out.println(totals.get("Toronto Raptors"));
    }



}
