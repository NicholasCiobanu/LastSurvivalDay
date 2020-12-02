import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the end game screen
 * 
 * @author Nicholas Ciobanu 
 * @version (a version number or a date)
 */
public class Death extends World
{

    /**
     * Tells the player they died
     * 
     */
    public Death()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        showText("YOU DIED", 300, 200);
        
    }
    //resets the ammo for next play session
    public void act(){
        Character.rifleAmmo=50;
        Character.shotgunAmmo=50;
        Greenfoot.stop();
    }
}
