import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death here.
 * 
 * @author Nicholas Ciobanu 
 * @version (a version number or a date)
 */
public class Death extends World
{

    /**
     * Constructor for objects of class Death.
     * 
     */
    public Death()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        showText("YOU DIED", 300, 200);
        
    }
    public void act(){
        Character.rifleAmmo=50;
        Character.shotgunAmmo=50;
        Greenfoot.stop();
    }
}