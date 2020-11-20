import lang.stride.*;
import greenfoot.*;

/**
 * Write a description of class Main here. @author (your name) @version (a version number or a date)
 */
public class Character extends Actor
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    
    private int speed = 3;//base speed of character
    private GreenfootImage image1 = null; //initialising base image
    private GreenfootImage image2 = null;//initialising second image 
    
    
    /**
     * stores the image for the character and the character while he is shooting in variables
     */
    public Character()
    {
        image1 =  new  GreenfootImage("main.png");
        image2 =  new  GreenfootImage("shooting.png");
        
        setImage(image1);
    }

    /**
     * Act - do whatever the Main wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        faceMouse();
        move();
        switchImage();
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
     * switches to shooting image when left click is pressed
     */
    private void switchImage()
    {
        int button = 0;
        MouseInfo mouse =  Greenfoot.getMouseInfo(); 
         if(mouse!=null){ 
           button = mouse.getButton();   
            if(button == 1 && Greenfoot.mouseClicked(null))  
            { 
                
             shootBullet();
             setImage(image2);
            
        }
        else {
            setImage(image1);
        }
    }
}
public void shootBullet(){
getWorld().addObject(new Bullet(getRotation()), getX(), getY());

}




}

