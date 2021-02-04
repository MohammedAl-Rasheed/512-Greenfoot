import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWonYt extends World
{

    PlayAgainYt b1=new PlayAgainYt();
    ExitAgainYt b2=new ExitAgainYt();
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameWonYt()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 600, 1);  
        addObject(b1,275,250);
        addObject(b2,275,380);
    }

    public void act() {
        if (Greenfoot.mousePressed(b1))
        {
            Greenfoot.setWorld (new MyWorldYt(0));
        }
        if (Greenfoot.mousePressed(b2))
        {
            Greenfoot.setWorld (new MenuYt());
        }
    }
}
