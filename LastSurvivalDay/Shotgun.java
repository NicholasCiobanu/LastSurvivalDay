import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the shotgun bullet
 * 
 * @author Nicholas Ciobanu
 * @version 11/25/20
 */
public class Shotgun extends SmoothMover
{
    //initializing the speed and bullet image
    private int speed=25;
    private GreenfootImage shotgun = null; 
    private int bulletTime;
    /**
     * Creates the bullet and gives it a direction received from the character
     */
    public Shotgun(int rotation){
        setRotation(rotation);
        shotgun =  new  GreenfootImage("shotgunShell.jpg");
        
    }
    /**
     * Act - do whatever the Shotgun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        removeConditions();
        bulletTime++;
    }    
    /**
     * Sets the speed of the bullet
     */
    public void move(){
        move(speed);
        
    }
    /**
     * Removes the bullet when it touches the edge of the screen or after a short time
     */
    public void removeConditions(){
        if(isAtEdge()||bulletTime==15){
            getWorld().removeObject(this);
        }
        
    }
}
