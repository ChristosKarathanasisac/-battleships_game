import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EmenyShipMedium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmenyShipMedium extends EmenyShip
{
    public EmenyShipMedium(int _gunReloadTime,int _reloadDelayCount,int _life,GreenfootImage _destroyed_ship)
    {
        super(_gunReloadTime,_reloadDelayCount,_life,_destroyed_ship);
    } 
    public void act()
    {
        move(3);
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
        sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(600),new EmenyShipMedium(15,1,15,new GreenfootImage("shipM_destroyed.png")));
        //sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(600));
        Counter counter = sea.getCounter();
        counter.addScore(1);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this);
    }
}
