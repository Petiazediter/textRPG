package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GameLoad{
    public static PlayerDatas.Player loadSavedGame(){
        PlayerDatas.Player s = new PlayerDatas.Player();
        
        String csvFile = "gamesave.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] savedata = line.split(cvsSplitBy);
                s.level = Integer.parseInt(savedata[0]);
                s.name = savedata[1];
                s.health = Integer.parseInt(savedata[2]);
                s.cast = savedata[3];
            }

        } catch (FileNotFoundException e) {
            s = createNewSave();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return s;
    }

    public static PlayerDatas.Player createNewSave(){
        PlayerDatas.Player s = new PlayerDatas.Player();
        s.level = 1;
        s.health = 100;
        
        Scanner input = new Scanner(System.in);
        s.name = input.nextLine();

        s.cast = "Mage";
        input.close();

        saveGame(s);

        return s;
    }

    public static void saveGame(PlayerDatas.Player player){
        
    }
}