import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class roadLine here.
 * 
 * @author Nicholas Ciobanu 
 * @version (a version number or a date)
 */
public class roadLine extends Actor
{
    /**
     * Act - do whatever the roadLine wants to do. This method is called whenever
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
