package cpt;
import java.io.IOException;
import java.io.*; 
import java.util.ArrayList;


public class run {
    static BarData barData;
    static ArrayList<String> str;

    public static void main(String[] args) {
        str = new ArrayList<>();
        barData = new BarData();

        str.add("LeBron James");
        str.add("Kawhi Leonard");

        barData.filler(str);

        barData.print();
        

    }
}
