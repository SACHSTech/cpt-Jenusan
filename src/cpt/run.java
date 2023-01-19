package cpt;
import java.io.IOException;
import java.io.*; 
import java.util.ArrayList;


public class run {

    public static void main(String[] args) {
        TeamTotal jj = new TeamTotal();
        jj.shortenList(2020, 2015);
        jj.print();
        jj.shortenList(2020, 2000);
        jj.print();
        jj.shortenList(2020, 2000);
        jj.print();

        PlayerTotal test = new PlayerTotal();
        test.print();
        

    }
}
