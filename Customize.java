import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Customize here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customize extends World
{
    BGC1 b1=new BGC1();
    BGC2 b2=new BGC2();
    /**
     * Constructor for objects of class Customize.
     * 
     */
    public Customize()
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
            Greenfoot.setWorld (new MyWorldGR(0));
        }
        if (Greenfoot.mousePressed(b2))
        {
            Greenfoot.setWorld (new MyWorld(0));
        }
    }
}
