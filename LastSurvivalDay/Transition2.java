import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Transition from level 2 to 3
 * 
 * @author Nicholas Ciobanu 
 * @version (a version number or a date)
 */
public class Transition2 extends World
{
    int score;
    /**
     * Constructor for objects of class Transition2.
     * 
     */
    public Transition2(int score)
    {    
        super(600, 394, 1); 
        this.score=score;
        showText("YOUR SCORE IS:"+score,350,350);
        showText("INSERT STORY HERE",350,100);
    }
    public void act(){
        
        checkSpace();
        
        
        
    }
    //moves to level 3 after the user presses space
    public void checkSpace(){
        
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Level4(score));
        }
        
    }
}
