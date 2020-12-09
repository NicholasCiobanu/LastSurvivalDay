import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends World
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    public static int score = 0;
    protected int spawnSpeed = 3;
    protected int speedRate = 0;
    int count = 0;
    private int timer = 1500;
    
    public Character main =  new  Character();

    /**
     * Constructor for objects of class MyWorld.
     */
    public Level4(int score)
    {
        super(1000, 600, 1);
        /* Create a new world with 1000x600 cells with a cell size of 1x1 pixels.*/
        addObject(main, 325, 180);
        showText("Level 4, Hospital",70,10);
        prepare();
        this.score = score;
        
    }

    /**
     * this class counts the number of kills
     */
    public void act()
    {
        spawns();
        showText("Kills: " + score, 35, 550);
        MiniBoss4();
        time();
        showText("Timer: " + timer, 800, 10);
        
        
    }
    //spawns the zombies
    public void spawns()
    {        int location = 1+ Greenfoot.getRandomNumber(4);
             if(Greenfoot.getRandomNumber(100)<3 && count<25){
                 switch(location){
                     case(1):
                     addObject(new Zombies4(main), Greenfoot.getRandomNumber(100), 600);
                     break;
                     case(2):
                     addObject(new Zombies4(main), 1000, Greenfoot.getRandomNumber(600));
                     break;
                     case(3):
                     addObject(new Zombies4(main), Greenfoot.getRandomNumber(1000), 0);
                     break;
                     case(4):
                     addObject(new Zombies4(main), 0, Greenfoot.getRandomNumber(600));
                     break;
        } 
        count++;
     }
     
    }
    
    
     /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
        {
        score = 0;
    }
    
    private void time()
    {
        if(timer>0){
        showText("Timer: " + timer, 800, 10);
        timer--;
    }
    }
    public void MiniBoss4(){
        while(timer==750){
            
           addObject(new MiniBoss4(main, score), 800, 600);
           score++;
           break;
            
        }
    }
    
}
