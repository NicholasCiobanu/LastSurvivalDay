import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniBoss4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniBoss4 extends Actor
{
    int switchImage = 0;
    int count;
    int MB4health = 75;
    int score;
    private GreenfootImage image1 = null; 
    private GreenfootImage image2 = null;
    Character player;
    Level1 LastSurvivalDay;
    /**
     * Act - do whatever the Zombies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MiniBoss4(Character main, int score)
    {
        player = main;
        this.score=score;
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
       checkEndLevel();
    }    
    private void checkCollision()
    {
        Actor rifle = getOneIntersectingObject(Rifle.class);
        Actor shotgun =getOneIntersectingObject(Shotgun.class);
        Actor c = getOneIntersectingObject(Character.class);
        if(rifle != null){
            Level4 Hospital = (Level4) getWorld();
            Hospital.removeObject(rifle);
            MB4health--;
        }
        if(shotgun != null){
            Level4 Hospital = (Level4) getWorld();
            Hospital.removeObject(shotgun);
            MB4health--;
        }
      
        if(MB4health <= 0)
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
    public void checkEndLevel(){
        if(MB4health==0){
            Greenfoot.setWorld(new Transition3(score));
            
        
        
        }
    
    }
}
