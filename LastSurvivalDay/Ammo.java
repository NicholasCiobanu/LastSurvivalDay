import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ammo here.
 * 
 * @author Nicholas Ciobanu
 * @version (a version number or a date)
 */
public class Ammo extends Actor
{
    /**
     * Act - do whatever the Ammo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Character.class))
        {
            getWorld().removeObject(this);
        }
    }    
}
