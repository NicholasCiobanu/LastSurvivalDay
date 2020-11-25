import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shotgun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shotgun extends Actor
{
    private int speed=25;
    private GreenfootImage shotgun = null; //initialising base image
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
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }    
    public void move(){
        move(speed);
        
    }
}
