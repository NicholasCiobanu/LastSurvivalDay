import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ammo class for 2nd level
 * 
 * @author Nicholas Ciobanu
 * @version (a version number or a date)
 */
public class Ammo2 extends Actor
{
    /**
     * Removes itself when it touches the character or reaches end of screen to the left
     * Moves left to simulate side scrolling effect
     */
    public void act() 
    {
        location();
        if (getX() == 0||isTouching(Character.class)) {
            getWorld().removeObject(this);
        }
        
    }    
    public void location(){
        setLocation(getX() - 1, getY());
    
    }
}
