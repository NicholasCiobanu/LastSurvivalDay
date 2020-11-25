import lang.stride.*;
import greenfoot.*;

/**
 * Write a description of class MyWorld here.
 * @author (your name) @version (a version number or a date)
 */
public class MyWorld extends World
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    protected int spawnSpeed = 3;
    protected int speedRate = 0;
    int count = 0;
    public Character main =  new  Character();

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        super(1000, 600, 1);
        /* Create a new world with 1000x600 cells with a cell size of 1x1 pixels.*/
        addObject(main, 325, 180);
        showText("Level 1, Forest",70,10);
        prepare();
        
    }

    /**
     * 
     */
    public void act()
    {
        spawns();
    }
    public void spawns()
    {
           if(Greenfoot.getRandomNumber(100)<5&&count<20){
            
            addObject(new Zombies(main), 1000,Greenfoot.getRandomNumber(600));
            count++;
            
    }
    }
     /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
}
