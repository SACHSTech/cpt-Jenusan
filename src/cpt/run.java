package cpt;
import java.io.IOException;
import java.io.*; 
import java.util.ArrayList;


public class run {

    public static void main(String[] args) {
        TeamTotal test = new TeamTotal();

        test.shortenList(2020,2015);
        test.print();
        test.shortenList(2022,1977);
        test.print();

    }
}
