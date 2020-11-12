import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        int count = 0;
        int spawnSpeed = 50;
        int randomSpawn;
    }
    public void act()
    {
      int count = 0;
      int spawnSpeed = 50;
      int randomSpawn;
      if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn){
                case (0): 
                addObject(new Zombies(), 0, 0);
                break;
                case(1):
                addObject(new Zombies(), getWidth()/2, 0);
                break;
                case(2):
                addObject(new Zombies(), 0, getHeight()/2);
                break;
                case(3):
                addObject(new Zombies(), 0, getHeight()/3);
                break;
                case(4):
                addObject(new Zombies(), getWidth()/4, getHeight());
                break;
                case(5):
                addObject(new Zombies(), getWidth(), getHeight()/5);
                break;
                case(6):
                addObject(new Zombies(), getWidth(), getHeight());
                break;
                case(7):
                addObject(new Zombies(), getWidth()/3, 0);
                break;
                case(8):
                addObject(new Zombies(), 0, getHeight()/2);
                break;
            }
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Character main = new Character();
        addObject(main,325,180);
    }
}
