import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Transition from level 2 to 3
 * 
 * @author Nicholas Ciobanu 
 * @version (a version number or a date)
 */
public class Transition2 extends World
{
    //initialize variables
    int score;
    /**
     * Constructor for objects of class Transition2.
     * 
     */
    public Transition2(int score)
    {    
        super(700, 390, 1); 
        this.score=score;
        //display score and story
        showText("YOUR SCORE IS:"+score,350,350);
        showText("You got off the road and killed the zombies in your way",350,100);
        showText("You are now headed towards the hospital to get medical supplies", 350, 200);
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
