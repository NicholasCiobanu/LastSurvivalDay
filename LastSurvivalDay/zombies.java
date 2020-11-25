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
    int health = 3;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Character player;
    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombies(Character main)
    {
        player = main;
        image1 = new GreenfootImage("zombie.png");
        image2 =  new  GreenfootImage("zombie2.png");
        setImage(image1);
        //setRotation(180);
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
        if(rifle != null){
            MyWorld forest = (MyWorld) getWorld();
            forest.removeObject(rifle);
            health--;
        }
        if(shotgun != null){
            MyWorld forest = (MyWorld) getWorld();
            forest.removeObject(shotgun);
            health--;
        }
        if(health == 0)
        {
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
        move(Greenfoot.getRandomNumber(5));
        turnTowards(player.getX(), player.getY());
    }  
}
