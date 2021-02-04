import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    public Box(int value)
    { 
        spawnBox(value);
    }

    public void act() 
    {

    }

    public void spawnBox(int value)
    {   
        if (value == 0) {
            setImage("blank.png");
        }
        if (value == 2)
        {
            setImage("2.png");
        }
        if (value == 4)
        {
            setImage("4.png");
        }
        if (value == 8)
        {
            setImage("8.png");
        }
        if (value == 16)
        {
            setImage("16.png");
        }
        if (value == 32)
        {
            setImage("32.png");
        }
        if (value == 64)
        {
            setImage("64.png");
        }
        if (value == 128)
        {
            setImage("128.png");
        }
        if (value == 256)
        {
            setImage("256.png");
        }
        if (value == 512)
        {
            setImage("512.png");
        }
    }
    /**
     * This method checks to see what value is under each individual slot of the array, and inserts the corresponding image/tile to the game board
     */
} 