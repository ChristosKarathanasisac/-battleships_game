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
        counter.addScore(6);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this);
    }
}
