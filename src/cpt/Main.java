package cpt;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Data playerData = new Data();
        playerData.filler();

        int x = 1340;
        try{
            System.out.println(playerData.getName(x));
            System.out.println(playerData.getTeam(x));
            System.out.println(playerData.getYear(x));
            System.out.println(playerData.getPosition(x));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
