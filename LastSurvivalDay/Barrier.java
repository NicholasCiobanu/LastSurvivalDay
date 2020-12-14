import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the barrier class. This actor determines if you win or not. If it gets destroyed you lose.
 * 
 * @author (Alvin Alagos Eli) 
 * @version (Final)
 */
public class Barrier extends SmoothMover
{
    int health = 5;
    FinalLevel LastSurvivalDay;
    /**
     * This method scales the image to a bigger size
     */
    public Barrier()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()*4;
        int myNewWidth = (int)myImage.getWidth()*7;
        myImage.scale(myNewWidth, myNewHeight);
    }
    /**
     * Act - do whatever the Barrier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation();
        checkCollision();
    }    
    /**
     * Checks if enemy classes collide with the barrier class
     */
    private void checkCollision()
    {
        Actor z = getOneIntersectingObject(ZombiesFinal.class);
        Actor b = getOneIntersectingObject(Boulder.class);
        if(z != null){
            FinalLevel base = (FinalLevel) getWorld();
            LastSurvivalDay.score++;
            base.removeObject(z);
            health--;
        }
        if(b != null){
            FinalLevel base = (FinalLevel) getWorld();
            base.removeObject(b);
            health--;
        }
        if(health <= 0)
        {
            LastSurvivalDay.score++;
            getWorld().removeObject(this);
            Greenfoot.setWorld(new Death());
        }
    }
    /**
     * Sets the location of the barrier
     */
    public void setLocation()
    {
        setLocation(getX(), getY());
    }
}
