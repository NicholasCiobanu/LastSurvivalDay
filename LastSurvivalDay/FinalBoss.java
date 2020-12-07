import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Actor
{
    Barrier wire;
    int health = 100;
    int count = 0;
    FinalLevel LastSurvivalDay;
    public Barrier main = new Barrier();
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FinalBoss(Barrier main)
    {
        wire = main;
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()*2;
        int myNewWidth = (int)myImage.getWidth()*2;
        myImage.scale(myNewWidth, myNewHeight);
        
    }
    public FinalBoss()
    {
        
    }
    public void act() 
    {
        attack();
        faceTo();
        checkCollision();
        spawns();
   
    }    
    
    public void attack()
    {
        int launch = 1 + Greenfoot.getRandomNumber(100);
        if (launch == 1)
        {
            getWorld().addObject(new Boulder(), getX(), getY());
        }
        
    }
    
    public void faceTo()
    {
        turnTowards(610, 605);
    }  
    
    public int getPositionX()
    {
        return getX();
    }
    public int getPositionY()
    {
        return getY();
    }
    public void checkCollision()
    {
        getWorld().showText("Boss Health: " + health, 1200, 50);
        Actor rifle = getOneIntersectingObject(Rifle.class);
        Actor shotgun =getOneIntersectingObject(Shotgun.class);
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
            Greenfoot.setWorld(new EndTransition());
        }
    }
    public void spawns()
    {
        if (health < 50)
        {
                    int location = 1+ Greenfoot.getRandomNumber(4);
             if(Greenfoot.getRandomNumber(100)<3&&count<50){
                 switch(location){
                     case(1):
                     getWorld().addObject(new ZombiesFinal(main), 1000, 0);
                     break;
                     case(2):
                     getWorld().addObject(new ZombiesFinal(main), 0, 0);
                     break;
                     case(3):
                     getWorld().addObject(new ZombiesFinal(main), Greenfoot.getRandomNumber(1000), 0);
                     break;
                     case(4):
                     getWorld().addObject(new ZombiesFinal(main), 640, 0);
                     break;
        } 
           count++;
     }
        }
    }
}
