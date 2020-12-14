import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dog here.
 * 
 * @author (Alvin Alagos Eli) 
 * @version (Final)
 */
public class Dog extends SmoothMover
{
    private GreenfootImage image1 = null;
    private GreenfootImage image2 = null;
    FinalLevel LastSurvivalDay;
    /**
     * Act - do whatever the Dog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dog()
    {
        image1 = new GreenfootImage("Hound.png");
        image2 =  new  GreenfootImage("Hound2.png");
        setImage(image1);
    }
    /**
     * Calls the methods in this class
     */
    public void act() 
    {
        switchImage();
        moveRandomly();
        checkCollision();
    }   
    /**
     * Checks collision between this class and other classes.
     */
    public void checkCollision()
    {
        Actor z = getOneIntersectingObject(ZombiesFinal.class);
        if(z != null){
            FinalLevel base = (FinalLevel) getWorld();
            GreenfootSound sound = new GreenfootSound("Bite.mp3");
            LastSurvivalDay.score++;
            sound.setVolume(20);
            sound.play();
            base.removeObject(z);
            
        }
    }
    /**
     * Sets random movement for hound class and turns their direction once they it the border
     */
    public void moveRandomly()
    {
        int move = 2+Greenfoot.getRandomNumber(5);
        move(move);
        if(Greenfoot.getRandomNumber(100)<10)
        {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if(isAtEdge())
        {
            turn(180);
        }
        if(getY() == 605)
        {
            turn(180);
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
}
