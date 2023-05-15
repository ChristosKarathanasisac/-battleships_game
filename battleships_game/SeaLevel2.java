import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeaLevel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeaLevel2 extends Sea
{

    /**
     * Constructor for objects of class SeaLevel2.
     * 
     */
    public SeaLevel2(HealthBar hBar,Counter c, LifeCounter lCounter, MyShip mShip)
    {
        super.level  = 2;
        addWavesOnSea();
        addShips();
        addObject(mShip, getWidth()/2 + 100, getHeight()/2);
        addRocks();
        addHealthBar(hBar);
        addCounter(c);
        addLifeCounter(lCounter);
        
    }
    
    private void addWavesOnSea()
    {
        GreenfootImage background = getBackground();
        background.setColor(new Color(37, 102, 152));
        background.fill();
        addWaves();
        for (Wave wave : getObjects(Wave.class)) {
            wave.draw();
        }  
    }
    private void addShips()
    {
       
        int h = Greenfoot.getRandomNumber(200);
        
        emenyShipGenerator(90,h,new EmenyShipMedium());
        emenyShipGenerator(90,h+150,new EmenyShipSmall());
        emenyShipGenerator(90,h+450,new EmenyShipLarge());
        emenyShipGenerator(90,h+300,new EmenyShipSmall());
        
    }
    
    private void addRocks()
    {
        addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()-100), Greenfoot.getRandomNumber(getHeight()-100));
        addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()-100), Greenfoot.getRandomNumber(getHeight()-100));
        addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()-100), Greenfoot.getRandomNumber(getHeight()-100));
        addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()-100), Greenfoot.getRandomNumber(getHeight()-100));
        addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()-100), Greenfoot.getRandomNumber(getHeight()-100));
        addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()-100), Greenfoot.getRandomNumber(getHeight()-100));
    }
}
