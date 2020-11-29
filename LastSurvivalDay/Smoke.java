import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smoke here.
 * 
 * @author Nicholas Ciobanu
 * @version (a version number or a date)
 */
public class Smoke extends Actor
{
    GifImage Smoke=new GifImage("Smoke.gif");
    /**
     * Act - do whatever the Smoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(Smoke.getCurrentImage());
        setLocation(getX() - 1, getY());
       
        if (getX() == 0) {
            getWorld().removeObject(this);
        }
    }    
}
