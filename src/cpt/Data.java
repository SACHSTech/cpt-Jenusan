package cpt;
import java.util.ArrayList;
import java.io.*;

public class Data{

    // initialize arraylist
    ArrayList<POTW> DataList;

    public Data(){
        DataList = new ArrayList<POTW>();
        filler();
    }

    // adds player objects to list
    public void DataFormatter(String[] PlayerInfo){
        POTW Player = new POTW(PlayerInfo[0], PlayerInfo[1], PlayerInfo[2], PlayerInfo[3]);
        DataList.add(Player);
    }

    // fills the data using dataformatter class
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

    // getter methods
    public String getName(int i){
        return (DataList.get(i)).getName();
    }
    public String getTeam(int i){
        return (DataList.get(i)).getTeam();
    }
    public String getYear(int i){
        return (DataList.get(i)).getYear();
    }
    public String getPosition(int i){
        return (DataList.get(i)).getPosition();
    }


}
