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
        showText("Development team members:",500,30);
        showText("Nicholas Ciobanu: Level 1, Level 2, Main Character, Guns, Ammo, Brute",500,55);
        showText("Vlad Christian Dumitrescu: Level 4",500,80);
        showText("Alvin Alagos Eli: Level 1, Level 5, Zombies, Bosses",500,105);
        showText("Yiu Kai Wong: Menu, Level 3",500,130);
        showText("'Space' to start playing",500,195);
        showText("<- 'Backspace' to go back to menu",140,575);
        showText("Creative Commons Zero v1.0 Universal license",700,575);
    }
    /**
 * 
 * 
 */
 public void act ()
{
    if (Greenfoot.isKeyDown("space")) {
            Level1 m = new Level1();
            Greenfoot.setWorld(m);
        }
    if (Greenfoot.isKeyDown("backspace")) {
            MenuScreen a = new MenuScreen();
            Greenfoot.setWorld(a);
    }
}
}