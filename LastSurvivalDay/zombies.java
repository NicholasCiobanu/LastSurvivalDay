import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombies extends Actor
{
    int switchImage = 0;
    int count;
    private int health = 3;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Character player;
    MyWorld LastSurvivalDay;
    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombies()
    {
        
    }
    public Zombies(Character main)
    {
        player = main;
        image1 = new GreenfootImage("zombie.png");
        image2 =  new  GreenfootImage("zombie2.png");
        setImage(image1);
        
    }
    public void act() 
    {
       switchImage();
       moveAround();
       checkCollision();
    }    
 
    private void checkCollision()
    {
        Actor a = getOneIntersectingObject(Bullet.class);
        if(a != null){
            MyWorld forest = (MyWorld) getWorld();
            forest.removeObject(a);
            health--;
        }
        
        if(health == 0)
        {
            LastSurvivalDay.score++;
            getWorld().removeObject(this);
        }
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
        move(Greenfoot.getRandomNumber(3));
        turnTowards(player.getX(), player.getY());
    }  
}
