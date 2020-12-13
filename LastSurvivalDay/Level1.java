import lang.stride.*;
import greenfoot.*;

/**
 * This is the first level
 * @author Alvin Algos, Nicholas Ciobanu
 */
public class Level1 extends World
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    //initializing variables
    public static int score = 0;
    protected int spawnSpeed = 3;
    protected int speedRate = 0;
    private int timer = 3800;
    public Character main =  new  Character();

    /**
     * Constructor for objects of class MyWorld.
     */
    public Level1()
    {
        super(1000, 600, 1);
        /* Create a new world with 1000x600 cells with a cell size of 1x1 pixels.*/
        addObject(main, 325, 180);
        setPaintOrder(Contour.class,Character.class,Zombies2.class,Brute.class,Rifle.class,Shotgun.class,Ammo2.class,Car.class,Van.class,Smoke.class,Lamp.class);
        prepare();
    }

    /**
     * 
     */
    public void act()
    {
        spawns();
        MiniBoss();
        showScore();
        time();
        
    }
    //spawns the zombies until timer reaches 0
    public void spawns()
    {
             int location = 1+ Greenfoot.getRandomNumber(4);
             if(Greenfoot.getRandomNumber(100)<3&&timer>0){
                 switch(location){
                     case(1):
                     addObject(new Zombies(main), Greenfoot.getRandomNumber(100), 600);
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
        
     }
    }
    //spawns the mini boss
     public void MiniBoss()
    {
        while (timer==1)
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
        Contour contour = new Contour();
        addObject(contour,503,306);
    }
    //shows the timer
    private void time(){
        if(timer>0){
        showText("Timer: " + timer, 800, 10);
        timer--;
        }
    }
    //shows the score
    private void showScore(){
        showText("Kills: " + score, 35, 550);
    }
}
