import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombies2 extends Actor
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
    public Zombies2(Character main)
    {
        player = main;
        image1 = new GreenfootImage("zombiesmall.png");
        image2 =  new  GreenfootImage("zombiesmall2.png");
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
        Actor rifle = getOneIntersectingObject(Rifle.class);
        Actor shotgun =getOneIntersectingObject(Shotgun.class);
        Actor c = getOneIntersectingObject(Character.class);
        if(rifle != null){
            Level2 road = (Level2) getWorld();
            road.removeObject(rifle);
            health--;
        }
        if(shotgun != null){
            Level2 road = (Level2) getWorld();
            road.removeObject(shotgun);
            health--;
        }
      
        if(health == 0)
        {
            //Zombies.LastSurvivalDay.score++;
            getWorld().removeObject(this);
        }
    }
    
    public void switchImage()
    {   
        count++;
        if (getImage() == image1&&count%50==0)
        {
            setImage(image2);
        }
        else if (count%100==0)
        {
            setImage(image1);
        }
    }
    
    public void moveAround()
    {
        move(Greenfoot.getRandomNumber(4));
        turnTowards(player.getX(), player.getY());
    }  
}
