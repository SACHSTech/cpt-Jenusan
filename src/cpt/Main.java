package cpt;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Data player = new Data();
        player.filler();
        
        System.out.println(player.playerinfo(0));
    }
}
