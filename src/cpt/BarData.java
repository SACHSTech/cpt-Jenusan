package cpt;
import java.util.*;

public class BarData {
    BarPlayerData barPlayerData;
    Hashtable <String, Hashtable<String, Integer>> playerstats;
    ArrayList<BarPlayerData> individualStats;
    Data data;
    Hashtable<String, Integer> yearTotal;

    int lowestYear;
    int highestYear;


    public BarData(ArrayList<String> players){
        playerstats = new Hashtable<>();
        data = new Data();
        lowestYear = 2020;
        highestYear = 1979;

        for (int i = 0; i < players.size(); i++){
            yearTotal = new Hashtable<>();

            for (int x = 0; x < data.getLength(); x++){
            if (data.getName(x).equals(players.get(i))){
                try{
                    yearTotal.put(data.getYear(x), yearTotal.get(data.getYear(x)) + 1);
                }catch (Exception e){
                    if (Integer.valueOf(data.getYear(x)) >= highestYear){
                        highestYear = Integer.valueOf(data.getYear(x));
                    }
                    if (Integer.valueOf(data.getYear(x)) <= lowestYear){
                        lowestYear = Integer.valueOf(data.getYear(x));
                    }
                    yearTotal.put(data.getYear(x), 1);
                }
            }
            }
            
            playerstats.put(players.get(i), yearTotal);
        }
    }

    public String[] getYears(){
        int x = highestYear - lowestYear;
        int y = 0;
        String[] years = new String[x+1];
        for (int i = x; i >= 0; i--){
            years[i] = Integer.toString(highestYear - y);
            y++;
        }

        return years;
    }

    public void print(){
        System.out.println(playerstats);
        System.out.println(lowestYear);
        System.out.println(highestYear);
    }

}
