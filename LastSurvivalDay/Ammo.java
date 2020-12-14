import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ammo class
 * 
 * @author Nicholas Ciobanu
 * @version (a version number or a date)
 */
public class Ammo extends SmoothMover
{
    /**
     * All this class does is remove itself once it touches the character
     */
    public void act() 
    {
        //removes itself when it touches the character
        if(isTouching(Character.class))
        {
            getWorld().removeObject(this);
        }
    }    
}
