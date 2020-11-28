import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class About here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class About extends World
{

    /**
     * Constructor for objects of class About.
     * 
     */
    public About()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        showText("Development team members:",140,30);
        showText("Nicholas Ciobanu",140,55);
        showText("Vlad Christian Dumitrescu",140,80);
        showText("Alvin Alagos Eli",140,105);
        showText("Yiu Kai Wong",140,130);
        showText("'Space' to start playing",118,195);
        showText("<- 'Backspace' to go back to menu",170,575);
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
    if (Greenfoot.isKeyDown("backspace")) {
            MenuScreen a = new MenuScreen();
            Greenfoot.setWorld(a);
    }
}
}