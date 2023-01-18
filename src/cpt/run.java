package cpt;
import java.io.IOException;
import java.io.*; 
import java.util.ArrayList;


public class run {

    public static void main(String[] args) {
        TeamTotal test = new TeamTotal();

        test.list(2020,1979);
        test.print();
        test.list(2020,2015);
        test.print();

    }
}
