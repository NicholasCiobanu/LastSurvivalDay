import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed;
  
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
    public Bullet(int rotation){
        setRotation(rotation);
        speed = 15;
        
    }
    public void move(){
        move(speed);
        
    }
}
