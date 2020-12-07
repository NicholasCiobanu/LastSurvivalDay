import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition3 extends World
{

    /**
     * Constructor for objects of class Transition2.
     * 
     */
    public Transition3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 394, 1); 
        
        showText("You barely made it out of your base" + "You need to go to the hospital and find some medical supplies",350,100);
    }
    public void act(){
        
        checkSpace();
        
        
       
    }
    //moves to level 3 after the user presses space
    public void checkSpace(){
        
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Level4());
        }
        
    }
}
