import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Like a zombie but bigger and slower
 * 
 * @author Alvin Algos 
 * @version (a version number or a date)
 */
public class Brute extends SmoothMover
{
    //initializing variables
    int switchImage = 0;
    int count;
    int health = 5;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Character player;
    Level2 LastSurvivalDay;
    /**
     * Act - do whatever the Brute wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Brute(Character main)
    {
        player = main;
        image1 = new GreenfootImage("Brute.png");
        image2 =  new  GreenfootImage("Brute2.png");
        setImage(image1);
    }
    public void act() 
    {
       switchImage();
       moveAround();
       checkCollision();
    }    
    //interactions when brute touches bullets
    private void checkCollision()
    {
        Actor rifle = getOneIntersectingObject(Rifle.class);
        Actor shotgun =getOneIntersectingObject(Shotgun.class);
        
        //loses health when hit by a bullet and deletes bullet
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
        //actions when health reaches 0
        if(health <= 0)
        {
            //increment score
            LastSurvivalDay.score++;
            //chance of spawning an ammo crate
            if(Greenfoot.getRandomNumber(3)==1){
                
                getWorld().addObject(new Ammo2(),getX(),getY());
            
            
            }
            //removes the zombie from the world
            getWorld().removeObject(this);
            
        }
    }
    //makes the zombie look like it walks
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
    //always moves towards the player
    public void moveAround()
    {
        move(Greenfoot.getRandomNumber(3));
        turnTowards(player.getX(), player.getY());
    }  
}
