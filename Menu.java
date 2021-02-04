import greenfoot.*;
import java.util.*;
import java.io.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private int Temp[][];
    Start b1=new Start();
    Exit b2=new Exit();
    Info b3 = new Info();
    lb lb = new lb();
    
    /**
     * Constructor for objects of class Menu.
     * This creates and array list that holds the values of our menu
     */
    public Menu()
    {    
        super(550, 600, 1); 
        addObject(b1,275,250);
        addObject(b2,275,380);
        addObject(b3,275,510);
        addObject(lb,480,70);
        
    }

    /**
     * This adds the custom images onto the set coordinates
     */

    public void act() {
        if (Greenfoot.mousePressed(b1))
        {
            Greenfoot.setWorld (new MyWorld(0));
        }
        if (Greenfoot.mousePressed(b2))
        {
            Greenfoot.setWorld (new MyWorld(1));
        }
        if (Greenfoot.mousePressed(b3))
        {
            Greenfoot.setWorld (new Customize());
        }
        if (Greenfoot.mousePressed(lb))
        {
            Greenfoot.setWorld (new MenuYt());
        } 
    }
    /**
     * This method determines which world you will be sent to based off of which option on the menu you choose
     */
}
