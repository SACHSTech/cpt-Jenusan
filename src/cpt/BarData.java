package cpt;
import java.util.*;

public class BarData{
    BarPlayerData barPlayerData;
    ArrayList<Hashtable> yearTotalCollection;
    Data data;
    Hashtable<String, Integer> yearTotal;
    ArrayList<String> yearList;
    ArrayList<String> nameList;

    int lowestYear;
    int highestYear;
    int max;

    String players;

    public BarData(){
        data = new Data();
        lowestYear = 2020;
        highestYear = 1979;
        max = 1;
    }

    public void filler(String players){
        yearTotalCollection = new ArrayList<>();
        yearList = new ArrayList<>();
        nameList = new ArrayList<>();

        this.players = players;
        
            yearTotal = new Hashtable<>();

            for (int x = 0; x < data.getLength(); x++){
            if (data.getName(x).equals(players)){
                try{
                    yearTotal.put(data.getYear(x), yearTotal.get(data.getYear(x)) + 1);
                    if (yearTotal.get(data.getYear(x)) > max){
                        max = yearTotal.get(data.getYear(x));
                    }
                }catch (Exception e){
                    if (Integer.valueOf(data.getYear(x)) >= highestYear){
                        highestYear = Integer.valueOf(data.getYear(x));
                    }
                    if (Integer.valueOf(data.getYear(x)) <= lowestYear){
                        lowestYear = Integer.valueOf(data.getYear(x));
                    }
                    yearTotal.put(data.getYear(x), 1);
                    yearList.add(data.getYear(x));
                }
            }
            }
            yearTotalCollection.add(yearTotal);
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

    public int getMax(){
        return max;
    }

    public String getPlayerList(){
        return this.players;
    }

    public void print(){
        System.out.println(yearTotal);
    }


}