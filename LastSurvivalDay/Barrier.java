import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrier extends Actor
{
    int health = 5;
    FinalLevel LastSurvivalDay;
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
    public void setLocation()
    {
        setLocation(getX(), getY());
    }
}
