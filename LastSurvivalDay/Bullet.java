import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed;
    private GreenfootImage rifle = null; //initialising base image
    private GreenfootImage shotgun = null;//initialising second image
    private boolean isRifle=false;
    private boolean isShotgun=false;
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        switchGun();
        changeGun();
    }    
  
    public Bullet(int rotation){
        setRotation(rotation);
        speed = 15;
        rifle =  new  GreenfootImage("bullet.png");
        shotgun =  new  GreenfootImage("shotgunShell.jpg");
    }
    public void move(){
        move(speed);
        
    }
    public void switchGun(){
        if(Greenfoot.isKeyDown("1")){
        
        isRifle=true;
        isShotgun=false;
        
        }
        if(Greenfoot.isKeyDown("2")){
            isShotgun=true;
            isRifle=false;
        }
        else {changeGun();}
    }
    public void changeGun(){
    if(isRifle==true){
    setImage(rifle);
    }
    if (isShotgun==true){
    setImage(shotgun);
    }
    }
}
