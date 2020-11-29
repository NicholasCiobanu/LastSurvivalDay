import lang.stride.*;
import greenfoot.*;

/**
 * This is the main character. He can move with keys, shoot with the mouse
 * and switch images when switching guns. It dies when it touches a 
 * zombie or a boss. 
 * @author Nicholas Ciobanu)
 * @version 11/25/20
 * 
 */
public class Character extends Actor
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    
    private int speed = 3;//base speed of character
    private GreenfootImage rifle = null; //initialising base image
    private GreenfootImage rifleShooting = null;//initialising second image 
    private GreenfootImage shotgun = null;
    private GreenfootImage shotgunShooting = null;
    private int checkWeapon;
    private int Munitions;
    private int button;
    /**
     * stores the image for the character and the character while he is shooting in variables
     */
    public Character()
    {
        rifle =  new  GreenfootImage("main.png");
        rifleShooting =  new  GreenfootImage("shooting.png");
        shotgun =  new  GreenfootImage("Shotgun.png");
        shotgunShooting = new GreenfootImage("ShotgunShooting.png");
        
    }

    /**
     * Act - do whatever the Main wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        faceMouse();
        move();
        switchImage();
        checkGun();
        showGun();
        hitEnnemies();
        
        getPositionX();
        getPositionY();
        
    }

    /**
     * This method makes the actor always face the direction of where the mouse is pointing.
     */
    private void faceMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            turnTowards(mouse.getX(), mouse.getY());
        }
    }
    
    public void hitEnnemies()
    {
        if(isTouching(Zombies.class)||isTouching(Zombies2.class)){
            Greenfoot.setWorld(new Death());
        }
        if(isTouching(MiniBoss.class)){
            Greenfoot.setWorld(new Death());
              
        }
        if(isTouching(Brute.class)){
            Greenfoot.setWorld(new Death());
              
        }
    }
    
    /**
     * controls the speed and the movement of the main character with the "w,a,s,d" keys
     */
    private void move(){
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed,getY());
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed,getY());
        }
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(),getY()- speed);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX() ,getY()+ speed);
        }
    }

    /**
     * switches to shooting image when left click is pressed and calls the shoot
     * methods
     */
    private void switchImage()
    {
        int button = 0;
        MouseInfo mouse =  Greenfoot.getMouseInfo(); 
         if(mouse!=null){ 
           button = mouse.getButton();   
            if(button == 1 && Greenfoot.mouseClicked(null))  
            { 
                
             
                if(checkWeapon%2==0){
                    shootRifle();
                    setImage(rifleShooting);
           
        
                }
                else {
                    shootShotgun();
                    setImage(shotgunShooting);
                }
        }
            else {if(checkWeapon%2==0){
                    setImage(rifle);
                }
                else {
                    setImage(shotgun);
                }
        }
    }
    }
    
    /**
     * Spwans a rifle bullet that goes in the direction where the mouse is pointing 
     * at the time
     */
    public void shootRifle(){
        getWorld().addObject(new Rifle(getRotation()), getX(), getY());

    }
    public void Munitions(){
        
        if (button == 1 && Greenfoot.mouseClicked(null)){
           Munitions--; 
    }
}
    /**
     * Spwans 3 shotgun bullets that go in the 3 different directions
     */
    public void shootShotgun(){
        getWorld().addObject(new Shotgun(getRotation()), getX(), getY());
        getWorld().addObject(new Shotgun(getRotation()+5), getX(), getY());
        getWorld().addObject(new Shotgun(getRotation()-5), getX(), getY());
    }
    /**
     * Checks which gun is being used and returns an int accordingly. 
     * Press e to change guns.
     */
    private int checkGun(){
        String key = Greenfoot.getKey();
        if("e".equals(key)){
        checkWeapon++;
        
        }
        return checkWeapon;
    }
    /**
     * Displays the gun currently being used in the top left corner
     */
    private void showGun(){
        if(checkWeapon%2==0){
            getWorld().showText("Rifle",70,50);
                    
           
        
           }
        else getWorld().showText("Shotgun",70,50);       
    }
    /**
     * Gets the position X of the player
     */
    public int getPositionX(){
    
        return getX();
    
    }
    /**
     * Gets the position Y of the player
     */
    public int getPositionY(){
    
        return getY();
    
    }
}

