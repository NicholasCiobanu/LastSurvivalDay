import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the rifle bullet
 * 
 * @author Nicholas Ciobanu
 * @version 11/25/20
 */
public class Rifle extends SmoothMover
{
    //initializing the speed and bullet image
    private int speed=15;
    private GreenfootImage rifle = null; //initialising base image
    /**
     * Creates the bullet and gives it a direction received from the character
     */
    public Rifle(int rotation){
        setRotation(rotation);
        rifle =  new  GreenfootImage("bullet.png");
    
    }
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
        {
        move();
        removeAtEdge();
        
    }    
    
    /**
     * Sets the speed of the bullet
     */
    public void move(){
        move(speed);
        
    }
    /**
     * Removes the bullet when it touches the edge of the screen
     */
    public void removeAtEdge(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
   
}
