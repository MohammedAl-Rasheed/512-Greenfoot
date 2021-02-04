import greenfoot.*;
import java.util.*;
import java.io.*;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int Temp[][] = new int[4][4];
    public Box B[][]= new Box[4][4];
    Counter count=new Counter();
    BMenu menu =new BMenu();
    public int Score;
    int y = 140;
    int x = 136;
    int coordinate = 77;
    private boolean gameOver;
    ArrayList<String> Scores;

    GreenfootSound swoosh = new GreenfootSound("swoosh.wav");
    GreenfootSound UWon = new GreenfootSound("won.wav");
    GreenfootSound ULost = new GreenfootSound("loose.mp3");

    public void randomVal()
    {
        int X[] = new int[16];
        int Y[] = new int[16];
        int ifMove = 0;
        for(int i=0;i<4;i++)
        {
            for(int k=0;k<4;k++)
            {
                if(Temp[i][k]==0)
                {
                    X[ifMove]=i;
                    Y[ifMove]=k;
                    ifMove = ifMove + 1;
                }
            }
        }
        if(ifMove==0) {
            return;
        }
        int rand=0;
        if(Greenfoot.getRandomNumber(10)>2) {
            rand = 2;
        }
        else {
            rand = 4;
        }
        int k = Greenfoot.getRandomNumber(ifMove);
        Temp[X[k]][Y[k]] = rand; 
        B[X[k]][Y[k]] = new Box(rand);
        int x1=(Y[k])*x+coordinate;
        int y1=(X[k])*x+coordinate; 
        addObject(B[X[k]][Y[k]],x1,y1);
        printArray();
    }

    public void save() {
        try {
            BufferedWriter writer = new BufferedWriter (new FileWriter(".\\save.txt"));
            for (int j=0; j<4;j++) {
                for(int i=0; i < 4;i++) {
                    writer.write(Temp[j][i] + ""); 
                    writer.newLine();
                }
            }

            writer.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedWriter writerS = new BufferedWriter (new FileWriter(".\\score.txt"));
            writerS.write(String.valueOf(Score));
            writerS.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        Scores = HighScores.read(".\\LeaderBoard.txt");
        Scores.add(String.valueOf(Score));
        try {
            BufferedWriter writerS = new BufferedWriter (new FileWriter(".\\LeaderBoard.txt"));
            for(int i=0;i < Scores.size(); i++) {
                writerS.write(Scores.get(i));
                writerS.newLine();
            }
            writerS.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void check() {
        try {
            BufferedReader reader = new BufferedReader (new FileReader(".\\save.txt"));
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    Temp[i][j] = Integer.parseInt(reader.readLine());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader readerS = new BufferedReader (new FileReader(".\\score.txt"));
            Score = Integer.parseInt(readerS.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyWorld(int vibe)
    {    
        super(550, 600, 1);
        addObject(count,119,575);
        addObject(menu,430,575);
        if (vibe != 1) {
            int rand1 = Greenfoot.getRandomNumber(4);
            int rand2 = Greenfoot.getRandomNumber(4);

            for(int r1 = 0; r1<4; r1++) 
            {
                for(int r2 = 0; r2<4;r2++) {
                    Temp[r1][r2] = 0;
                    B[r1][r2] = new Box(Temp[r1][r2]);
                }
            }

            int co1 =(rand2)*x + coordinate;
            int co11 =(rand1)*y + coordinate;
            int co2=(3-rand2)*x + coordinate;
            int co22=(3-rand1)*y + coordinate;

            B[rand1][rand2] = new Box(2);
            B[3-rand1][3-rand2] = new Box(2);

            addObject(B[rand1][rand2],co1,co11);
            addObject(B[3-rand1][3-rand2],co2,co22);
        }
        if(vibe == 1) {
            check();
            for(int j=0;j<4;j++) {
                for(int i=0;i < 4; i++) {
                    int co11 = (j) *x + coordinate;
                    int co1 = (i)*x + coordinate;

                    B[j][i] = new Box(Temp[j][i]);
                    addObject(B[j][i],co1,co11);

                }
            }
            count.add(Score);
        }

    }

    public int printArray()
    { 
        for(int i=0;i<4;i++) {
            System.out.println(Temp[i][0] + " " + Temp[i][1] + " " + Temp[i][2] + " " + Temp[i][3]);
        }
        System.out.println(" ");
        return(1);
    }

    public void didUWin() {
        for(int j=0; j < 4;j++) {
            for (int i=0; i < 4; i++) {
                if (Temp[j][i] == 512) {
                    System.out.println("You Won");
                    Greenfoot.setWorld (new GameWon());
                    UWon.play();
                }
            }
        }
    }

    public boolean didULose()
    {
        gameOver = true;
        for(int i=0; i < 4; i++) {
            for (int j=0; j < 4; j++) {
                if (i !=3) {
                    if (Temp[i][j] == Temp[i+1][j]) {
                        gameOver = false;
                    }
                }
                if (i !=0) {
                    if (Temp[i][j] == Temp[i-1][j]) {
                        gameOver = false;
                    }
                }
                if (j !=3) {
                    if (Temp[i][j] == Temp[i][j+1]) {
                        gameOver = false;
                    }
                }
                if (j !=0) {
                    if (Temp[i][j] == Temp[i][j-1]) {
                        gameOver = false;
                    }
                }
                if (Temp[i][j] == 0) {
                    gameOver = false;
                }
            }
        }
        return gameOver;
    }

    public void act() {
        String key = Greenfoot.getKey();
        didUWin();
        didULose();
        if (gameOver == true) {
            Greenfoot.setWorld (new GameOver());
            ULost.play();
        }

        if(key!=null)
        {

            if(key.equals("a"))
            {
                swoosh.play();
                left();
            }

            else if(key.equals("d"))
            {
                swoosh.play();
                right();
            }

            else if(key.equals("w"))
            {
                swoosh.play();
                up();
            }

            else if(key.equals("s"))
            {
                swoosh.play();
                down();
            }

            printArray(); 
            randomVal(); 

        }

        if (Greenfoot.mousePressed(menu))
        {
            save();
            Greenfoot.setWorld (new Menu());

        }
    }

    public void up() {
        for(int i=1;i<=3;i++)
        {
            for(int j=3;j>=0;j--)
            {
                if(Temp[i][j]!=0)
                {   int k=i; 
                    while(k>0)
                    { 
                        int xCo=(j)*x+coordinate;
                        int yCo=(k-1)*y+coordinate;
                        if(Temp[k-1][j]==0)
                        {   Temp[k-1][j]=Temp[k][j];
                            B[k-1][j].spawnBox(Temp[k-1][j]);
                            addObject(B[k-1][j],xCo,yCo);

                            Temp[k][j]=0;
                            removeObjects(getObjectsAt(xCo,yCo+x,Box.class));
                            if(Temp[i][k-1]==512) {

                                k--;
                            }
                        }

                        else if(Temp[k][j]==Temp[k-1][j])
                        {
                            Temp[k-1][j]*=2;
                            Score = Score + Temp[k-1][j];
                            count.add(Temp[k-1][j]);

                            B[k-1][j].spawnBox(Temp[k-1][j]);
                            addObject(B[k-1][j],xCo,yCo);

                            Temp[k][j]=0;

                            removeObjects(getObjectsAt(xCo,yCo+x,Box.class));

                            k--;
                        }
                        else {
                            k--;
                        }
                    }
                }

            }
        }
    }

    public void down() {
        for(int i=2;i>=0;i--)
        {
            for(int j=0;j<4;j++)
            {
                if(Temp[i][j]!=0)
                {   int k=i; 
                    while(k<3)
                    { 
                        int xCo=(j)*x+coordinate;
                        int yCo=(k+1)*y+coordinate;
                        if(Temp[k+1][j]==0)
                        {   Temp[k+1][j]=Temp[k][j];
                            B[k+1][j].spawnBox(Temp[k+1][j]);
                            addObject(B[k+1][j],xCo,yCo);

                            Temp[k][j]=0;
                            removeObjects(getObjectsAt(xCo,yCo-x,Box.class));
                            if(Temp[k+1][j]==512) {

                                k++;
                            }
                        }

                        else if(Temp[k][j]==Temp[k+1][j])
                        {
                            Temp[k+1][j]*=2;
                            Score = Score + Temp[k+1][j];
                            count.add(Temp[k+1][j]);
                            B[k+1][j].spawnBox(Temp[k+1][j]);
                            addObject(B[k+1][j],xCo,yCo);

                            Temp[k][j]=0;

                            removeObjects(getObjectsAt(xCo,yCo-x,Box.class));

                            k++;
                        }  
                        else {
                            k++;
                        }
                    }
                }
            }
        }
    }

    public void right(){
        for(int i=0;i<4;i++)
        {
            for(int j=2 ;j>=0;j--)
            {
                if(Temp[i][j]!=0)
                {   int k=j; 
                    while(k<3)
                    { 
                        int xCo=(k+1)*x+coordinate;
                        int yCo=(i)*y+coordinate;
                        if(Temp[i][k+1]==0)
                        {   Temp[i][k+1]=Temp[i][k];
                            B[i][k+1].spawnBox(Temp[i][k+1]);
                            addObject(B[i][k+1],xCo,yCo);

                            Temp[i][k]=0;
                            removeObjects(getObjectsAt(xCo-x,yCo,Box.class));
                            if(Temp[i][k+1]==512) {

                                k++;
                            }
                        }

                        else if(Temp[i][k]==Temp[i][k+1])
                        {
                            Temp[i][k+1]*=2;
                            B[i][k+1].spawnBox(Temp[i][k+1]);
                            addObject(B[i][k+1],xCo,yCo);
                            Score = Score + Temp[i][k+1];
                            count.add(Temp[i][k+1]);

                            Temp[i][k]=0;

                            removeObjects(getObjectsAt(xCo-x,yCo,Box.class));

                            k++;
                        }                        
                        else {
                            k++;
                        }
                    }
                }
            }
        }   
    }

    public void left (){
        for(int i=0;i<4;i++)
        {
            for(int j=1;j<=3;j++)
            {
                if(Temp[i][j]!=0)
                { int k=j; 
                    while(k>0)
                    {
                        int xCo=(k-1)*x+coordinate;
                        int yCo=(i)*y+coordinate;
                        if(Temp[i][k-1]==0)
                        {   Temp[i][k-1]=Temp[i][k];
                            B[i][k-1].spawnBox(Temp[i][k-1]);
                            addObject(B[i][k-1],xCo,yCo);

                            Temp[i][k]=0;
                            removeObjects(getObjectsAt(xCo+x,yCo,Box.class));
                            if(Temp[i][k-1]==512) {

                                k--;
                            }
                        }

                        else if(Temp[i][k]==Temp[i][k-1])
                        {
                            Temp[i][k-1]*=2;
                            Score = Score + Temp[i][k-1];
                            count.add(Temp[i][k-1]);
                            B[i][k-1].spawnBox(Temp[i][k-1]);
                            addObject(B[i][k-1],xCo,yCo);

                            Temp[i][k]=0;

                            removeObjects(getObjectsAt(xCo+x,yCo,Box.class));

                            k--;
                        }
                        else {
                            k--;
                        }
                    }
                }
            }
        }
    }
}
