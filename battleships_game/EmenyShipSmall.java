import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EmenyShipSmall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmenyShipSmall extends EmenyShip
{
    public EmenyShipSmall()
    {
        super(10,1,10,new GreenfootImage("shipS_destroyed.png"));
    } 
    public void act()
    {
        move(5);
        turnAtEdge();
        lookForShip(1);
        lookForOtherActor(EmenyShip.class);
        checkIfShipIsToDamaged();
        int temp = Greenfoot.getRandomNumber(5);
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
        sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipSmall());
        //sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(600));
        Counter counter = sea.getCounter();
        counter.addScore(1);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this);
    }
}
