import lang.stride.*;
import greenfoot.*;

/**
 * Write a description of class Zombies here.
 * @author (your name) @version (a version number or a date)
 */
public class Zombies extends Actor
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    protected int switchImage = 0;
    protected int count;
    private GreenfootImage image1 = null;
    private GreenfootImage image2 = null;
    protected Character player;

    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombies(Character main)
    {
        player = main;
        image1 =  new  GreenfootImage("zombie.png");
        image2 =  new  GreenfootImage("zombie2.png");
        setImage(image1);
        setRotation(180);
    }

    /**
     * 
     */
    public void act()
    {
        switchImage();
        moveAround();  
    }

    /**
     * 
     */
    public void switchImage()
    {
        if (Greenfoot.getRandomNumber(10) == 1) {
            if (getImage() == image1) {
                setImage(image2);
            }
            else {
                setImage(image1);
            }
        }
    }

    /**
     * 
     */
    public void moveAround()
    {
        move(Greenfoot.getRandomNumber(5));
        turnTowards(player.getX(), player.getY());
    }
    
        
    
}
