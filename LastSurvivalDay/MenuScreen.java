import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World
{

    /**
     * Constructor for objects of class MenuScreen.
     * 
     */
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        showText("L A S T   S U R V I V A L   D A Y",500,100);
        showText("PRESS 'I' FOR INSTRUCTIONS",500,300);
        showText("PRESS 'A' FOR ABOUT US",500,350);
        showText("PRESS 'SPACEBAR' TO PLAY",500,450);
}
/**
 * 
 * 
 */
public void act ()
{
    if (Greenfoot.isKeyDown("space")) {
            MyWorld m = new MyWorld();
            Greenfoot.setWorld(m);
        }
    if (Greenfoot.isKeyDown("i")) {
            Instructions b = new Instructions();
            Greenfoot.setWorld(b);
    }
    if (Greenfoot.isKeyDown("a")) {
            About c = new About();
            Greenfoot.setWorld(c);
    }
}
}