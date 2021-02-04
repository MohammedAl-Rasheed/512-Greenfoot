import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Customize here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomizeYt extends World
{
    BGC1Yt b1=new BGC1Yt();
    BGC2Yt b2=new BGC2Yt();
    /**
     * Constructor for objects of class Customize.
     * 
     */
    public CustomizeYt()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 600, 1);
        addObject(b1,275,350);
        addObject(b2,275,550);
    }

    public void act() {
        int x = 0;
        int y = 0;
        if (Greenfoot.mousePressed(b1))
        {
            Greenfoot.setWorld (new MyWorldYtGR(0));
        }
        if (Greenfoot.mousePressed(b2))
        {
            Greenfoot.setWorld (new MyWorldYt(0));
        }
    }
}
