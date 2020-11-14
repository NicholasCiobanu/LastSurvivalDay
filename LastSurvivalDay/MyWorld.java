import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   int spawnSpeed = 3;
    int speedRate = 0;
    public Character main = new Character();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        addObject(main,325,180);
        prepare();
        spawn();
    }
    public void act()
    {
        
    }
    public void spawn()
    {
        int count = 0;
      while(count <= 20)
      {
      if(Greenfoot.getRandomNumber(100)== 1)
    {
      addObject(new Zombies(main) , Greenfoot.getRandomNumber(1000), 400);
      count++;
    }
    }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
     
    }
}
