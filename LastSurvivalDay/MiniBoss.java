import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniBoss extends Actor
{
    int switchImage = 0;
    int count;
    int health = 3;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Character player;
    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MiniBoss(Character main)
    {
        player = main;
        image1 = new GreenfootImage("Mini-boss.png");
        image2 =  new  GreenfootImage("Mini-boss2.png");
        setImage(image1);
        setRotation(40);
    }
    public void act() 
    {
       switchImage();
       moveAround();
    }    
    
    public void switchImage()
    {   
        if(Greenfoot.getRandomNumber(10)== 1)
        {
        if (getImage() == image1)
        {
            setImage(image2);
        }
        else
        {
            setImage(image1);
        }
    }
    }
    public void moveAround()
    {
        move(Greenfoot.getRandomNumber(5));
        turnTowards(player.getX(), player.getY());
    }  
}
