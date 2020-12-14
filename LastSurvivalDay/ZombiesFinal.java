import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZombiesFinal here.
 * 
 * @author Alvin Alagos Eli
 * @version (Final)
 */
public class ZombiesFinal extends SmoothMover
{
    int switchImage = 0;
    int count;
    int health = 3;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Barrier wire;
    FinalLevel LastSurvivalDay;
    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ZombiesFinal(Barrier main)
    {
        wire = main;
        image1 = new GreenfootImage("zombie.png");
        image2 =  new  GreenfootImage("zombie2.png");
        setImage(image1);
    }
    /**
     * Calls methods for this class
     */
    public void act() 
    {
       switchImage();
       moveAround();
       checkCollision();
    }    
    /**
     * Checks for collision with other actors
     */
    private void checkCollision()
    {
        Actor rifle = getOneIntersectingObject(Rifle.class);
        Actor shotgun =getOneIntersectingObject(Shotgun.class);
        Actor d = getOneIntersectingObject(Dog.class);
        if(rifle != null){
            FinalLevel base = (FinalLevel) getWorld();
            base.removeObject(rifle);
            health--;
        }
        if(shotgun != null){
            FinalLevel base = (FinalLevel) getWorld();
            base.removeObject(shotgun);
            health--;
        }
        
        if(health <= 0)
        {
            LastSurvivalDay.score++;
            GreenfootSound sound = new GreenfootSound("Grunt1.mp3");
            sound.setVolume(20);
            sound.play();
            getWorld().removeObject(this);
            
        }
    }
    /**
     * Gives the illusion of animation for zombies
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
     * Determines the speed of the zombies and sets the target for the zombies.
     */
    public void moveAround()
    {
        move(Greenfoot.getRandomNumber(4));
        turnTowards(610, 605);
    }  
}
