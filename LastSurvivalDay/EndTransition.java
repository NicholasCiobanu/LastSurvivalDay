import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Final Transition after final level.
 * 
 * @author (Alvin Alagos Eli) 
 * @version (Final)
 */
public class EndTransition extends World
{
    int score;
    /**
     * Sets the text on the screen.
     * 
     */
    public EndTransition(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        this.score = score;
        showText("Finally, our fierce character may rest from facing these undying waves of zombies.", 500, 100);
        showText("Unfortunately, this isn't the end. This is the world our character must live in.",500,150);
        showText("A dangerous path lies ahead of him as long as he is on this planet...", 500, 200);
        showText("Thanks for playing!",500,300);
        showText("Your score is: " + score,500,400);
        showText("Press Esc to return to the main menu",500,500);
    }
    /**
     * Calls the methods
     */
    public void act()
    {
        checkKey();
    }
    /**
     * Checks if esc key is pressed
     */
    public void checkKey(){
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new MenuScreen());
        }
    }
}
