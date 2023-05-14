import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeaLevel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeaLevel1 extends Sea
{

    private MyShip ship = new MyShip(5,5,new GreenfootImage("myShip_destroyed.png"));
    public SeaLevel1()
    {
        addWavesOnSea();
        addObject(ship, getWidth()/2 + 100, getHeight()/2);
        addShips();
        addBars();
    }
    
    private void addWavesOnSea()
    {
        GreenfootImage background = getBackground();
        background.setColor(new Color(18, 113, 222));
        background.fill();
        addWaves();
        for (Wave wave : getObjects(Wave.class)) {
            wave.draw();
        }  
    }
    private void addShips()
    {
        int h = Greenfoot.getRandomNumber(300);
        
        emenyShipGenerator(90,h,new EmenyShipMedium());
        emenyShipGenerator(90,h+150,new EmenyShipSmall());
        emenyShipGenerator(90,h+300,new EmenyShipMedium());
    }
    public MyShip getMyShip()
    {
        return ship;
    }
}
