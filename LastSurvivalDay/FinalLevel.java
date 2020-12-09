import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalLevel extends World
{
    public static int score = 0;
    protected int spawnSpeed = 3;
    protected int speedRate = 0;
    int count = 0;
    int timer = 4500;
    public Barrier main2 = new Barrier();
    public FinalLevelCharacter main =  new  FinalLevelCharacter();
    /**
     * Constructor for objects of class FinalLevel.
     * 
     */
    public FinalLevel(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 700, 1); 
        addObject(main, 640, 650);
        prepare();
        this.score= score;
    }
    public void act()
    {
        spawns();
        FinalBoss();
        time();
        showText("Kills: " + score, 35, 550);
    }
    
    public void spawns()
    {
            int location = 1+ Greenfoot.getRandomNumber(4);
             if(Greenfoot.getRandomNumber(100)<3&&timer>0){
                 switch(location){
                     case(1):
                     addObject(new ZombiesFinal(main2), 1000, 0);
                     break;
                     case(2):
                     addObject(new ZombiesFinal(main2), 0, 0);
                     break;
                     case(3):
                     addObject(new ZombiesFinal(main2), Greenfoot.getRandomNumber(1000), 0);
                     break;
                     case(4):
                     addObject(new ZombiesFinal(main2), 640, 0);
                     break;
        } 
          count++;
     }
    }
    public void FinalBoss()
    {
        while(timer == 1)
        {
        GreenfootSound sound = new GreenfootSound("Boss.mp3");
        sound.setVolume(100);
        sound.play();
        addObject(new FinalBoss(main2), 600, 100);
        score++;
        break;
    }
    }
    
    private void prepare()
    {
        score = 0;
        addObject(new Barrier(), 610, 605);
        addObject(new AmmoCrate(), 1000, 620);
        addObject(new AmmoCrate(), 250, 620);
        addObject(new Button(), 400, 625);
    }
    public void time(){
        if(timer > -1){
       timer--;
    }
     }
}
