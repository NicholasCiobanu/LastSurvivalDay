import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boulder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boulder extends SmoothMover
{
    int health = 5;
    FinalLevel LastSurvivalDay;
    /**
     * Act - do whatever the Boulder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Boulder()
    {
          GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()*3;
        int myNewWidth = (int)myImage.getWidth()*3;
        myImage.scale(myNewWidth, myNewHeight);
    }
    public void act() 
    {
        move();
        faceTo();
        health();
    }    
    public void move()
    {
        move(1);
    }
    public void faceTo()
    {
        turnTowards(610, 605);
    }
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
