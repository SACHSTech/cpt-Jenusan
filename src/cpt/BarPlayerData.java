package cpt;

public class BarPlayerData {
    String year;
    int total;
    public BarPlayerData(String year, int total){
        this.year = year;
        this.total = total;
    }
    public String getYear(){
        return this.year;
    }
    public int getTotal(){
        return this.total;
    }
}
