import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Transition from level 2 to 3
 * 
 * @author Nicholas Ciobanu 
 * @version (a version number or a date)
 */
public class Transition2 extends World
{

    /**
     * Constructor for objects of class Transition2.
     * 
     */
    public Transition2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 394, 1); 
        
        showText("INSERT STORY HERE",350,100);
    }
    public void act(){
        
        checkSpace();
        
        
        
    }
    //moves to level 3 after the user presses space
    public void checkSpace(){
        
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new BaseOfOperation());
        }
        
    }
}
