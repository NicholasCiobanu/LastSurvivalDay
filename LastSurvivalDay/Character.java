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
    public boolean shooting;
    public int shootTime;
    private int speed = 3;//base speed of character
    private GreenfootImage rifle = null; //initialising base image
    private GreenfootImage rifleShooting = null;//initialising second image 
    private GreenfootImage shotgun = null;
    private GreenfootImage shotgunShooting = null;
    private int checkWeapon;
    public static int rifleAmmo=50;
    public static int shotgunAmmo=30;
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
        shootRifle();
        shootShotgun();
        checkGun();
        showGun();
        hitEnnemies();
        getPositionX();
        getPositionY();
        shootTime++;
        Munitions();
        
        
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
    /**
     * This method makes the actor die when it touches an ennemy
     */
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
     * Checks which weapon is equipped and changes image in consequence
     */
    private void switchImage()
    {
        
            {if(checkWeapon%2==0){
                    setImage(rifle);
                }
                else {
                    setImage(shotgun);
                }
        }
    }
    
    
    /**
     * Shoots the gun when left click is pressed or hold down, changes image when shooting
     */
    public void shootRifle(){
        if(rifleAmmo!=0){
        if(checkWeapon%2==0){
        if(shooting && (Greenfoot.mouseDragEnded(null) || Greenfoot.mouseClicked(null))){
            shooting=false;
        
         }
        if (!shooting && Greenfoot.mousePressed(null)) shooting = true;
        if(shootTime%7==0&&shooting==true) {
            setImage(rifleShooting);
            getWorld().addObject(new Rifle(getRotation()), getX(), getY());
            rifleAmmo--;
         }
        
        }
    }
    }
    /**
     * Keeps track of the ammo and increases it when the character touches an ammo pack
     */
    public void Munitions(){
        if(rifleAmmo<=0) rifleAmmo=0;
        if(shotgunAmmo<=0) shotgunAmmo=0;
        if (isTouching(Ammo.class)||isTouching(Ammo2.class)){
           rifleAmmo=rifleAmmo+Greenfoot.getRandomNumber(10)+10;
           shotgunAmmo=shotgunAmmo+Greenfoot.getRandomNumber(5)+5;
        }
    
    }
    /**
     * Spwans 3 shotgun bullets that go in the 3 different directions, changes image of character when shooting
     */
    public void shootShotgun(){
        if(shotgunAmmo!=0){
        if(checkWeapon%2!=0){
        int button = 0;
        MouseInfo mouse =  Greenfoot.getMouseInfo(); 
         if(mouse!=null){ 
           button = mouse.getButton();   
            if(button == 1 && Greenfoot.mouseClicked(null))  
            { 
                getWorld().addObject(new Shotgun(getRotation()), getX(), getY());
                getWorld().addObject(new Shotgun(getRotation()+5), getX(), getY());
                getWorld().addObject(new Shotgun(getRotation()-5), getX(), getY());
                setImage(shotgunShooting);
                shotgunAmmo--;
                }
        }
        }
    }
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
     * Displays the gun currently being used and ammo in the top left corner
     */
    private void showGun(){
        if(checkWeapon%2==0){
            getWorld().showText("Rifle",70,50);
            getWorld().showText("Ammo: "+rifleAmmo,70,65);
            
           
        
           }
        else {
            getWorld().showText("Shotgun",70,50);   
            getWorld().showText("Ammo: "+shotgunAmmo,70,65);
        }
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

