import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition1 here.
 * 
 * @author Nicholas Ciobanu 
 * @version (a version number or a date)
 */
public class Transition1 extends World
{

    /**
     * Constructor for objects of class Transition1.
     * 
     */
    public Transition1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1);
        showText("You managed to escape the forest, but just barely. ",350,100);
        showText("Now, you start going towards the city in hope of finding others just like you...",350,150);
        showText("Survivors in a corrupted world",350,200);
        showText("PRESS SPACE TO PROCEED TO THE NEXT LEVEL",350,300);
    }
    public void act(){
        
        checkSpace();
        
        
        
    }
    public void checkSpace(){
        
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Level2());
        }
        
    }
}