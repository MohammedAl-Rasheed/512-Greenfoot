import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    PlayAgain b1=new PlayAgain();
    ExitAgain b2=new ExitAgain();
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 600, 1);  
        addObject(b1,275,250);
        addObject(b2,275,380);
    }

    public void act() {
        if (Greenfoot.mousePressed(b1))
        {
            Greenfoot.setWorld (new MyWorld(0));
        }
        if (Greenfoot.mousePressed(b2))
        {
            Greenfoot.setWorld (new Menu());
        }
    }
}
