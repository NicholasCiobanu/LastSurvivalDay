import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the zombies in Level 1. These zombies are coded to match the first level.
 * 
 * @author (Alvin Alagos Eli) 
 * @version (Final)
 */
public class Zombies extends SmoothMover
{
    int switchImage = 0;
    int count;
    int health = 3;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Character player;
    Level1 LastSurvivalDay;
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
    }
    /**
     * Calls the methods of this class
     */
    public void act() 
    {
       switchImage();
       moveAround();
       checkCollision();
    }    
    /**
     * Checks collision between actors and this class
     */
    private void checkCollision()
    {
        Actor rifle = getOneIntersectingObject(Rifle.class);
        Actor shotgun =getOneIntersectingObject(Shotgun.class);
        Actor c = getOneIntersectingObject(Character.class);
        if(rifle != null){
            Level1 forest = (Level1) getWorld();
            forest.removeObject(rifle);
            health--;
        }
        if(shotgun != null){
            Level1 forest = (Level1) getWorld();
            forest.removeObject(shotgun);
            health--;
        }
      
        if(health <= 0)
        {
            LastSurvivalDay.score++;
            if(Greenfoot.getRandomNumber(4)==1){
                
                getWorld().addObject(new Ammo(),getX(),getY());
            
            
            }
            GreenfootSound sound = new GreenfootSound("Grunt1.mp3");
            sound.setVolume(20);
            sound.play();
            getWorld().removeObject(this);
            
        }
    }
    /**
     * Creates the illusion of animation
     */
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
    /**
     * Determines the speed of the zombies and sets their target
     */
    public void moveAround()
    {
        move(Greenfoot.getRandomNumber(4));
        turnTowards(player.getX(), player.getY());
    }  
}
