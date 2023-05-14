import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sea extends World
{
    private Counter healthCounter;
    private HealthBar healthBar = new HealthBar();
    private Counter counter  = new Counter();
    private LifeCounter lCounter = new LifeCounter();
    
    public Sea()
    {    
        super(1200, 800, 1);
        GreenfootImage background = getBackground();
        background.setColor(new Color(18, 113, 222));
        background.fill();
        addWaves();
        for (Wave wave : getObjects(Wave.class)) {
            wave.draw();
        }  
        MyShip ship = new MyShip(5,5,new GreenfootImage("myShip_destroyed.png"));
        //ship.setLife(10);
        addObject(ship, getWidth()/2 + 100, getHeight()/2);
        emenyShipGenerator(90,Greenfoot.getRandomNumber(600),new EmenyShipMedium(10,1,10,new GreenfootImage("shipM_destroyed.png")));
        emenyShipGenerator(90,Greenfoot.getRandomNumber(600),new EmenyShipMedium(15,1,10,new GreenfootImage("shipM_destroyed.png")));
        emenyShipGenerator(90,Greenfoot.getRandomNumber(600),new EmenyShipMedium(15,1,10,new GreenfootImage("shipM_destroyed.png")));
        
        addHealthBar(healthBar);
        addLifeCounter(lCounter);
        addCounter(counter);
        
    }
    
    public void addHealthBar(HealthBar hBar)
    {
        addObject(hBar,50, 20);
    }
    
    public void replaceHealthBar()
    {
        removeObject(healthBar);
        this.healthBar =  new HealthBar();
        addObject(healthBar,50, 20);
    }
    
    public void addCounter(Counter c)
    {
        addObject(c,310, 20);
    }
    public void addLifeCounter(LifeCounter lCounter)
    {
        addObject(lCounter,180, 20);
    }
    public void emenyShipGenerator(int w, int h,EmenyShip emenyShip)
    {
        addObject(emenyShip, w, h);
    }
    
    public Counter getCounter()
    {
        return counter;
    }
    
    public HealthBar getHealthBar()
    {
        return healthBar;
    }
    public LifeCounter getLifeCounter()
    {
        return lCounter;
    }
     private void addWaves()
    {
        addObject(new Wave(1,600,100), 0, 0);
        addObject(new Wave(1,600,200), 0, 0);
        addObject(new Wave(1,600,300), 0, 0);
        addObject(new Wave(1,600,400), 0, 0);
        addObject(new Wave(1,600,500), 0, 0);
        addObject(new Wave(1,600,600), 0, 0);
    }
    public void gameOver() 
    {
        addObject(new ScoreBoard(counter.score), getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
}
