import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxYt extends Actor
{
    public BoxYt(int value)
    {
        spawnBoxYt(value);
    }

    public void act() 
    {

    }

    public void spawnBoxYt(int value)
    {   
        if (value == 0) {
            setImage("blankYt.png");
        }
        if (value == 2)
        {
            setImage("2Yt.png");
        }
        if (value == 4)
        {
            setImage("4Yt.png");
        }
        if (value == 8)
        {
            setImage("8Yt.png");
        }
        if (value == 16)
        {
            setImage("16Yt.png");
        }
        if (value == 32)
        {
            setImage("32Yt.png");
        }
        if (value == 64)
        {
            setImage("64Yt.png");
        }
        if (value == 128)
        {
            setImage("128Yt.png");
        }
        if (value == 256)
        {
            setImage("256Yt.png");
        }
        if (value == 512)
        {
            setImage("512Yt.png");
        }
    }
    /**
     * This method checks to see what value is under each individual slot of the array, and inserts the corresponding image/tile to the game board
     * Same as Box.java except white icons
     */
} 