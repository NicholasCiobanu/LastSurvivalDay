import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud1 here.
 * 
 * @author Nicholas Ciobanu 
 * @version (a version number or a date)
 */
public class Cloud1 extends Actor
{
    /**
     * Act - do whatever the Cloud1 wants to do. This method is called whenever
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
