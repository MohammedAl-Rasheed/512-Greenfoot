import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverYt extends World
{
    PlayAgainYt b1=new PlayAgainYt();
    ExitAgainYt b2=new ExitAgainYt();
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOverYt()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 600, 1);  
        addObject(b1,275,250);
        addObject(b2,275,380);
    }
    /**
     * This method simply adds the custom images to the set coordinates
     */

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
    /**
     * With this method after the game is over, it will clear the world, and give you the option to go back to the menu
     */
}
