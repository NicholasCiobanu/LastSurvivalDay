import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is character class but designed to match the mechanics needed for the final level
 * 
 * @author (Alvin Alagos Eli) 
 * @version (Final)
 */
public class FinalLevelCharacter extends SmoothMover
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
    public static int shotgunAmmo=20;
    private int button;
    private int uses = 0;
    FinalLevel LastSurvivalDay;
    /**
     * stores the image for the character and the character while he is shooting in variables
     */
    public FinalLevelCharacter()
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
        spawnDogs();
        
        
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
            GreenfootSound rifleSound = new GreenfootSound("RifleSound.wav");
            rifleSound.setVolume(50);
            rifleSound.play();
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
        if (isTouching(AmmoCrate.class)){
            if(Greenfoot.isKeyDown("f")){
           rifleAmmo=50;
           shotgunAmmo=20;
        }
    
    }
    }
    public void spawnDogs()
    {
        
        Actor butt = getOneIntersectingObject(Button.class);
        if(isTouching(Button.class)){
            if(Greenfoot.isKeyDown("f")){
                getWorld().addObject(new Dog(),0, 350);
                getWorld().addObject(new Dog(),1280, 350);
                uses++;
                if(uses == 1){
                    FinalLevel base = (FinalLevel) getWorld();
                    base.removeObject(butt);
                }
            }
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
                GreenfootSound shotgunSound = new GreenfootSound("ShotgunSound.wav");
                shotgunSound.setVolume(50);
                shotgunSound.play();
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
