import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombies4 here.
 * 
 * @author Vlad Dumitrescu 
 * @version (a version number or a date)
 */
public class Zombies4 extends SmoothMover
{
    int switchImage = 0;
    int count;
    int health = 3;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Character player;
    Level4 LastSurvivalDay;
    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombies4(Character main)
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
        Actor rifle = getOneIntersectingObject(Rifle.class);
        Actor shotgun =getOneIntersectingObject(Shotgun.class);
        Actor c = getOneIntersectingObject(Character.class);
        if(rifle != null){
            Level4 Hospital = (Level4) getWorld();
            Hospital.removeObject(rifle);
            health--;
        }
        if(shotgun != null){
            Level4 Hospital = (Level4) getWorld();
            Hospital.removeObject(shotgun);
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
        move(Greenfoot.getRandomNumber(4));
        turnTowards(player.getX(), player.getY());
    }   
}
