import greenfoot.*;
import java.util.*;
import java.io.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuYt extends World
{
    private int Temp[][];
    StartYt b1=new StartYt();
    ExitYt b2=new ExitYt();
    InfoYt b3 = new InfoYt();
    LBYt lb =new LBYt();
    trophyYt HighLB = new trophyYt();

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public MenuYt()
    {    
        super(550, 600, 1); 
        addObject(b1,275,250);
        addObject(b2,275,380);
        addObject(b3,275,510);
        addObject(lb,480,70);
        addObject(HighLB,70,80);
    }

    public void act() {
        if (Greenfoot.mousePressed(b1))
        {
            Greenfoot.setWorld (new MyWorldYt(0));
        }
        if (Greenfoot.mousePressed(b2))
        {
            Greenfoot.setWorld (new MyWorldYt(1));
        }
        if (Greenfoot.mousePressed(lb))
        {
            Greenfoot.setWorld (new Menu());
        } 
        if (Greenfoot.mousePressed(b3))
        {
            Greenfoot.setWorld (new CustomizeYt());
        }
        if (Greenfoot.mousePressed(HighLB))
        {
            Greenfoot.setWorld (new HighScoresYt());
        }
    }
}
