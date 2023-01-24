package cpt;
import java.util.ArrayList;
import java.io.*;
import java.io.IOException;

public class Data{

    // initializing variables
    ArrayList<POTW> DataList;
    POTW Player;

    /**
     * Data constructor
     * creates arraylist and runs filler method
     */
    public Data(){
        DataList  = new ArrayList<POTW>();
        filler();
    }

    /**
     * DataFormatter method to take in a string of player info and format it to the POTW constructor
     * @param PlayerInfo: comma separated array of strings from fileIO
     */
    public void DataFormatter(String[] PlayerInfo){
        Player = new POTW(PlayerInfo[0], PlayerInfo[1], PlayerInfo[2]);
        DataList.add(Player);
    }

    /**
     * uses FileIO to read data from csv and stores it into an arraylist to be used by all other classes
     */
    public void filler(){
        // csv file
        String file = "src\\cpt\\0 Data.csv";
        String line;

        // FileIO from buffered reader to fill arraylist (try and catch OP)
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                DataFormatter(line.split(","));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * get the name of player from index
     * @param i index
     * @return players name
     */
    public String getName(int i){
        return (DataList.get(i)).getName();
    }
    /**
     * get the name of Team from index
     * @param i index
     * @return Team name
     */
    public String getTeam(int i){
        return (DataList.get(i)).getTeam();
    }
    /**
     * get the year from index
     * @param i index
     * @return year
     */
    public String getYear(int i){
        return (DataList.get(i)).getYear();
    }
    /**
     * get the length of the arraylist
     * @return int
     */
    public int getLength(){
        return DataList.size();
    }
    /**
     * get one certain instance of data
     * @param i
     * @return POTW element
     */
    public POTW getInstance(int i){
        return DataList.get(i);
    }

    
}
