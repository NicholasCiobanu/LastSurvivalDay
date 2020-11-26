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
    int MBhealth = 50;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Character player;
    MyWorld LastSurvivalDay;
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
       checkCollision();
    }    
    private void checkCollision()
    {
        Actor rifle = getOneIntersectingObject(Rifle.class);
        Actor shotgun =getOneIntersectingObject(Shotgun.class);
        Actor c = getOneIntersectingObject(Character.class);
        if(rifle != null){
            MyWorld forest = (MyWorld) getWorld();
            forest.removeObject(rifle);
            MBhealth--;
        }
        if(shotgun != null){
            MyWorld forest = (MyWorld) getWorld();
            forest.removeObject(shotgun);
            MBhealth--;
        }
      
        if(MBhealth == 0)
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
        move(Greenfoot.getRandomNumber(5));
        turnTowards(player.getX(), player.getY());
    }  
}
