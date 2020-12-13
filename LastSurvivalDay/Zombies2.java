import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the zombie for level 2
 * 
 * @author Alvin Algos (Adapted to level 2 by Nicholas Ciobanu)
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
    Level2 LastSurvivalDay2;
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
    //interactions when zombie touches bullets
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
            LastSurvivalDay2.score++;
            if(Greenfoot.getRandomNumber(4)==1){
                //chance of spawning an ammo crate
                getWorld().addObject(new Ammo2(),getX(),getY());
            
            
            }
            //plays a death sound and removes the zombie from the world
            GreenfootSound sound = new GreenfootSound("Grunt1.mp3");
            sound.setVolume(20);
            sound.play();
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
        move(Greenfoot.getRandomNumber(4));
        turnTowards(player.getX(), player.getY());
    }  
}
