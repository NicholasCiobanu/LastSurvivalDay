import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The boulder class is meant to be thrown towards the barrier class by the final boss.
 * 
 * @author (Alvin Alagos Eli) 
 * @version (Final)
 */
public class Boulder extends SmoothMover
{
    int health = 5;
    FinalLevel LastSurvivalDay;
    /**
     * Scales the image to a bigger size.
     */
    public Boulder()
    {
          GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()*3;
        int myNewWidth = (int)myImage.getWidth()*3;
        myImage.scale(myNewWidth, myNewHeight);
    }
    /**
     * Calls the methods of this class
     */
    public void act() 
    {
        move();
        faceTo();
        health();
    }    
    /**
     * Sets the speed of the boulders to 1
     */
    public void move()
    {
        move(1);
    }
    /**
     * Sets the direction of the boulder
     */
    public void faceTo()
    {
        turnTowards(610, 605);
    }
    /**
     * Checks if bullets collides with the boulder and removes health until 0
     */
    public void health()
    {
      Actor rifle = getOneIntersectingObject(Rifle.class);
       Actor shotgun =getOneIntersectingObject(Shotgun.class);
       Actor c = getOneIntersectingObject(Character.class);
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
            getWorld().removeObject(this);
            
      }
    }
}
