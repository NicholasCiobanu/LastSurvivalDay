import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition3 extends World
{
    int score;
    /**
     * Constructor for objects of class Transition2.
     * 
     */
    public Transition3(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 394, 1); 
        this.score = score;
        showText("You fought off the zombies at the entrance of the hospital",350,100);
        showText("You got enough medical supplies and start leaving the hospital",350,150);
        showText("You find out there is a base at the edge of the city and you go there",350,200);
        showText("PRESS SPACE TO PROCEED TO NEXT LEVEL", 350, 250);
        showText("To interact with objects press F", 350, 300);
        showText("YOUR SCORE IS:"+score,350,350);
    }
    public void act(){
        
        checkSpace();
        
        
      
    }
    //moves to level 3 after the user presses space
    public void checkSpace(){
        
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new FinalLevel(score));
        }
        
    }
}
