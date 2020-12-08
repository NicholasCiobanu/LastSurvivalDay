import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Village here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseOfOperation extends World
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    public static int score = 0;
    protected int spawnSpeed = 3;
    protected int speedRate = 0;
    int count = 0;
    public Character main =  new  Character();

    /**
     * Constructor for objects of class MyWorld.
     */
    public BaseOfOperation()
    {
        super(1000, 600, 1);
        /* Create a new world with 1000x600 cells with a cell size of 1x1 pixels.*/
        addObject(main, 325, 180);
        showText("Level 3, Base of operation",128,10);
        prepare();
        
    }

    /**
     * 
     */
    public void act()
    {
        spawns();
        FinalBoss();
        showText("Kills: " + score, 35, 550);
        if (score == 30) {
            showText("Good job, you've passed all the levels",500,300);
            MenuScreen a = new MenuScreen();
            Greenfoot.setWorld(a);
            //we get 10 points from mini boss so 20+10=30 points.
    }
    }
    public void spawns()
    {
             int location = 1+ Greenfoot.getRandomNumber(4);
     if(Greenfoot.getRandomNumber(100)<5&&count<20){
       switch(location){
           case(1):
           addObject(new Zombies(main), Greenfoot.getRandomNumber(1000), 600);
           break;
           case(2):
           addObject(new Zombies(main), 1000, Greenfoot.getRandomNumber(600));
           break;
           case(3):
           addObject(new Zombies(main), Greenfoot.getRandomNumber(1000), 0);
           break;
           case(4):
           addObject(new Zombies(main), 0, Greenfoot.getRandomNumber(600));
           break;
        }
        count++;
     }
    }
     public void FinalBoss()
    {
        while (score== 20)
        {
            addObject(new MiniBoss(main,score), 500, 600);
            score++;
            break;
        }
        
    }
    
     /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        score = 0;
    }
}
