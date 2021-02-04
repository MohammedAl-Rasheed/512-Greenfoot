import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CounterYt extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value; 
    public CounterYt()
    {
        background = getImage();
        value = 0;
        updateImage();
    }

    public void act() 
    {
        updateImage();
    }

    /**
     * This basically just adds the score to what it was before
     */
    public void add(int score) 
    {
        value += score;
    }  

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("Score: " + value, 22, Color.WHITE, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
            (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
