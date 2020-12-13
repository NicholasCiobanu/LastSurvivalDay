import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second level which is a side scroller type
 * 
 * @author Nicholas Ciobanu
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    //initializing variables
    static int score;
    protected int spawnSpeed = 3;
    protected int speedRate = 0;
    int regularInterval = 0;
    public Character main =  new  Character();
    int time=4000;

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 450, 1); 
        Greenfoot.setSpeed(50);
        this.score=score;
        setPaintOrder(Character.class,Zombies2.class,Brute.class,Rifle.class,Shotgun.class,Ammo2.class,Car.class,Van.class,Smoke.class,Lamp.class);
        prepare();
    }

    public void act(){
        spawnScrolling();
        spawnZombies();
        regularInterval++;
        resetCharPos();
        endLevel();
        showTime();
        showScore();
        
    }
    //spawns the scrolling elements of the decor
    public void spawnScrolling(){
        if (Greenfoot.getRandomNumber(400) < 1) {
            addObject( new  Cloud1(), 1000, Greenfoot.getRandomNumber(100));
        }
        if (Greenfoot.getRandomNumber(300) < 2) {
            addObject( new  Cloud2(), 1000, Greenfoot.getRandomNumber(150));
        }
        if (regularInterval%300==0) {
            addObject( new  Lamp(), 1000, 150);
        }
        if (regularInterval%200==0) {
            addObject( new  roadLine(), 1000, 337);
        }
        if (Greenfoot.getRandomNumber(400) < 1) {
            int y=  Greenfoot.getRandomNumber(150)+250;
            addObject( new  Car(), 1000,y);
            addObject( new  Smoke(), 1000,y-37);
        }
        if (Greenfoot.getRandomNumber(550) < 1) {
            int y=  Greenfoot.getRandomNumber(150)+250;
            addObject( new  Van(), 1000,y);
            addObject( new  Smoke(), 1000,y-37);
        }
    }
    //spawns the zombies
    public void spawnZombies(){
        if(Greenfoot.getRandomNumber(50)<1){
            addObject( new  Zombies2( main), 1000, Greenfoot.getRandomNumber(200)+200);
        }
        if(Greenfoot.getRandomNumber(100)<1){
            addObject( new  Zombies2( main), Greenfoot.getRandomNumber(500)+500,450 );
        }
        if(Greenfoot.getRandomNumber(150)<1){
            addObject( new  Brute( main),1000, Greenfoot.getRandomNumber(200)+200);
        }
    }
    //blocks the character from going too far up (needs to stay on ground)
    public void resetCharPos(){

        if(main.getPositionY()<200){
            main.setLocation(main.getPositionX(), 200);
        }

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cloud1 cloud1 = new Cloud1();
        addObject(cloud1,915,68);
        Cloud1 cloud12 = new Cloud1();
        addObject(cloud12,705,60);
        Cloud1 cloud13 = new Cloud1();
        addObject(cloud13,532,110);
        Cloud1 cloud14 = new Cloud1();
        addObject(cloud14,233,63);
        Cloud2 cloud2 = new Cloud2();
        addObject(cloud2,849,143);
        Cloud2 cloud22 = new Cloud2();
        addObject(cloud22,935,160);
        Cloud2 cloud23 = new Cloud2();
        addObject(cloud23,703,147);
        Cloud2 cloud24 = new Cloud2();
        addObject(cloud24,279,152);
        Cloud2 cloud25 = new Cloud2();
        addObject(cloud25,96,35);
        addObject(main, 50, 300);
        int i =0;
        while (i<10){ 
            addObject (new roadLine(),i*300+200,337);
            addObject (new Lamp(),i*300+100,150);
            i++;
        }
        
    }
    //when the timer reaches 0 the level ends
    private void endLevel(){
        time--;
        if(time==0){
            
            Greenfoot.setWorld(new Transition2(score));
            
        }
        
    }
    //shows the timer
    private void showTime(){
        showText("Distance left: "+time+" meters", 875, 15);
        
    }
    //shows the score
    private void showScore(){
        showText("Kills: " + score, 35, 420);
    }
}
