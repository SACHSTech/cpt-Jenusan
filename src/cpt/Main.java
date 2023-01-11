package cpt;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String file = "src\\cpt\\0 Data.csv";
        String line;

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                System.out.println(line.split(","));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
