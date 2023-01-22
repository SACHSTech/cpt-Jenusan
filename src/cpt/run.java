package cpt;
import java.io.IOException;
import java.io.*; 
import java.util.ArrayList;


public class run {
    static BarData barData;

    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();

        str.add("LeBron James");
        str.add("Giannis Antetokounmpo");

        barData = new BarData(str);

        barData.print();
        

    }
}
