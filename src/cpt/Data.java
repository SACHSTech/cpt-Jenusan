package cpt;
import java.util.ArrayList;
import java.io.*;

public class Data {
    ArrayList<PlayerData> DataList = new ArrayList<PlayerData>();

    public void DataFormatter(String[] POTW){
        PlayerData Player = new PlayerData(POTW[0], POTW[1], POTW[2], POTW[3]);
        DataList.add(Player);
    }

    public void filler(){
        String file = "src\\cpt\\0 Data.csv";
        String line;

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                DataFormatter(line.split(","));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public String playerinfo(int i){
        return (DataList.get(i)).getName();
    }


}
