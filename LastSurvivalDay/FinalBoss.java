import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (Alvin Alagos Eli) 
 * @version (Final)
 */
public class FinalBoss extends SmoothMover
{
    Barrier wire;
    int health = 100;
    int count = 0;
    int score;
    FinalLevel LastSurvivalDay;
    private GreenfootImage image1=null;
    private GreenfootImage image2=null;
    public Barrier main = new Barrier();
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FinalBoss(Barrier main,int score)
    {
        this.score=score;
        wire = main;
        image1 = new GreenfootImage("Final_Throw.png");
        image2= new GreenfootImage("Final_Throw2.png");
        GreenfootImage myImage = getImage();
        GreenfootImage myImage1 = image1;
        int myNewHeight = (int)myImage.getHeight();
        int myNewWidth = (int)myImage.getWidth();
        myImage.scale(myNewWidth, myNewHeight);
        
    }
    /**
     * Allows me to call this class in other classes
     */
    public FinalBoss()
    {
        
    }
    /**
     * Calls the methods in this class
     */
    public void act() 
    {
        HealthBar();
        attack();
        faceTo();
        checkCollision();
        spawns();
        
    }    
    /**
     * This method allows the boss to dispense boulders and also animate his throws
     */
    public void attack()
    {
        int launch = 1 + Greenfoot.getRandomNumber(100);
        if (launch == 1)
        {
            if (getImage() == image1)
        {
            setImage(image2);
        }
        else
        {
            setImage(image1);
        }
            getWorld().addObject(new Boulder(), getX(), getY());
        }
        
    }
    /**
     * Set the direction
     */
    public void faceTo()
    {
        turnTowards(610, 605);
    }  
    /**
     * Gets the X location
     */
    public int getPositionX()
    {
        return getX();
    }
    /**
     * Gets the Y position
     */
    public int getPositionY()
    {
        return getY();
    }
    /**
     * Checks collision with bullets
     */
    public void checkCollision()
    {
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
        if(health == 50)
        {
            GreenfootSound sound = new GreenfootSound("Rage.mp3");
            sound.setVolume(100);
            sound.play();
        }
        if(health <= 0)
        {
            LastSurvivalDay.score++;
            getWorld().removeObject(this);
            Greenfoot.setWorld(new EndTransition(score));
        }
    }
    /**
     * This method is for spawning minions(zombies) when the boss is under 50% of its health
     */
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
    /**
     * This sets the right picture for the health amount
     */
    public void HealthBar()
    {
        Actor h100 = getOneIntersectingObject(Health100.class);
        Actor h90 = getOneIntersectingObject(Health90.class);
        Actor h80 = getOneIntersectingObject(Health80.class);
        Actor h70 = getOneIntersectingObject(Health70.class);
        Actor h60 = getOneIntersectingObject(Health60.class);
        Actor h50 = getOneIntersectingObject(Health50.class);
        Actor h40 = getOneIntersectingObject(Health40.class);
        Actor h30 = getOneIntersectingObject(Health30.class);
        Actor h20 = getOneIntersectingObject(Health20.class);
        Actor h10 = getOneIntersectingObject(Health10.class);
       if(health == 100)
       {
           getWorld().addObject(new Health100(), 640, 0);
       }
       if(health == 90){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h100);
           getWorld().addObject(new Health90(), 640, 0); 
       }
       if(health == 80){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h90);
           getWorld().addObject(new Health80(), 640, 0); 
       }
       if(health == 70){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h80);
           getWorld().addObject(new Health70(), 640, 0); 
       }
       if(health == 60){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h70);
           getWorld().addObject(new Health60(), 640, 0); 
       }
       if(health == 50){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h60);
           getWorld().addObject(new Health50(), 640, 0); 
       }
       if(health == 40){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h50);
           getWorld().addObject(new Health40(), 640, 0); 
       }
       if(health == 30){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h40);
           getWorld().addObject(new Health30(), 640, 0); 
       }
       if(health == 20){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h30);
           getWorld().addObject(new Health20(), 640, 0); 
       }
       if(health == 10){
           FinalLevel base = (FinalLevel) getWorld();
           base.removeObject(h20);
           getWorld().addObject(new Health10(), 640, 0); 
       }
    }
}
