import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rifle extends Actor
{
    private int speed=15;
    private GreenfootImage rifle = null; //initialising base image
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
        {
        move();
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }    
  
    public Rifle(int rotation){
        setRotation(rotation);
        rifle =  new  GreenfootImage("bullet.png");
    
    }
    public void move(){
        move(speed);
        
    }
    
   
}
