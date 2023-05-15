import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EmenyShipLarge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmenyShipLarge extends EmenyShip
{
    public EmenyShipLarge()
    {
        super(15,2,30,new GreenfootImage("shipL_destroyed.png"));
    } 
    public void act()
    {
        move(2);
        turnAtEdge();
        lookForShip(4);
        lookForOtherActor(EmenyShip.class);
        lookForOtherActor(Rock.class);
        checkIfShipIsToDamaged();
        int temp = Greenfoot.getRandomNumber(10);
        if(temp == 2)
        {
            if(!lock)
            {
                randomTurn();
            }
        }
        
        reloadDelayCount++;
    }
    
    public void breakUp() 
    {
        Greenfoot.playSound("Explosion.wav");
        Sea sea = (Sea) getWorld();
        sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipLarge());
        Counter counter = sea.getCounter();
        counter.addScore(4);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this);
        
        /*Greenfoot.playSound("Explosion.wav");
        Sea sea = (Sea) getWorld();
        if(sea.getClass() == SeaLevel1.class)
        {
        SeaLevel1 seaLevel1 = (SeaLevel1) sea;
        seaLevel1.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipLarge());
        Counter counter = seaLevel1.getCounter();
        counter.addScore(4);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this); 
        }
        else
        {
        SeaLevel2 seaLevel2 = (SeaLevel2) sea;
        seaLevel2.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipLarge());
        Counter counter = seaLevel2.getCounter();
        counter.addScore(4);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this); 
        }
        */
    }
}
