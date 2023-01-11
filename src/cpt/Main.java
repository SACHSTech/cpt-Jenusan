package cpt;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String file = "src\\cpt\\0 Data.csv";
        String line;
        String[] jkn;

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                jkn = line.split(",");
                System.out.println(jkn[0]);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
