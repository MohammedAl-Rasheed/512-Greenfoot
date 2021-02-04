import greenfoot.*;
import java.util.*;
import java.io.*;

/**
 * Write a description of class HighScoresYt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScores extends World
{
    ReturnYt r = new ReturnYt();
    ArrayList<String> TempList = new ArrayList<String>();
    String[] Scores;
    public static int[] finalScores;
    int tempgg = 0;  

    /**
     * Constructor for objects of class HighScoresYt.
     * 
     */
    public HighScores()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 600, 1);
        addObject(r,130,530);

    }

    public void act() {
        arrange();
        show();
        if (Greenfoot.mousePressed(r))
        {
            Greenfoot.setWorld (new Menu());
        }
    }

    public static java.util.ArrayList<String> read(String filename) { 
        ArrayList<String> fileText = new ArrayList<String>();
        BufferedReader saveFile = null;
        try {
            saveFile = new BufferedReader(new FileReader(filename));
            String input;
            while ((input = saveFile.readLine()) != null) {
                fileText.add(input);
            }
        }
        catch (FileNotFoundException fnfe) {
            return null;
        }
        catch (IOException ioe) {
            return null;
        }
        finally {
            try {
                saveFile.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            catch (NullPointerException npe) {
            }
        }
        return fileText;
    }

    public static void arrange(){ 
        String[] Scores = new String[5];
        Scores = read(".\\LeaderBoard.txt").toArray(Scores);
        finalScores = new int[Scores.length];
        for (int i = 0; i < Scores.length; i++){
            finalScores[i] = Integer.parseInt(Scores[i]);
        }

        Arrays.sort(finalScores);
        for(int i = 0; i < finalScores.length / 2; i++)
        {
            int temp = finalScores[i];
            finalScores[i] = finalScores[finalScores.length - i - 1];
            finalScores[finalScores.length - i - 1] = temp;
        }

    }

    public void show() {
        for (int i=0;i < 5;i++) {
            int valueInShow = i + 1;
            int moveDown = i * 50;
            showText(String.valueOf(valueInShow) + ": " + String.valueOf(finalScores[i]), 70, 180 + moveDown);

        }

    }
}

