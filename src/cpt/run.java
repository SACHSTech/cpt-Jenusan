package cpt;
import java.io.IOException;
import java.io.*; 
import java.util.ArrayList;


public class run {
    private static TeamTotal test;

    public static void main(String[] args) {
        test = new TeamTotal(2020, 2005);
        test.print();
        test = new TeamTotal(2020, 2010);
        test.print();
        test = new TeamTotal(2018, 2016);
        test.print();
    }
}
