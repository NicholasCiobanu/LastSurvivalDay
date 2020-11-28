import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        showText("Controls:",50,30);
        showText("'W' to move up",79,55);
        showText("'S' to move down",92,75);
        showText("'A' to move left",80,95);
        showText("'D' to move right",87,115);
        showText("'Mouse cursor' to aim weapon towards cursor",222,135);
        showText("'Left click' to shoot weapon",138,155);
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
