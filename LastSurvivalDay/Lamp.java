import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Part of decor for level 2
 * 
 * @author Nicholas Ciobanu
 * @version (a version number or a date)
 */
public class Lamp extends Actor
{
    /**
     * Act - do whatever the Lamp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - 1, getY());
       
        if (getX() == 0) {
            getWorld().removeObject(this);
        }
    }    
}
