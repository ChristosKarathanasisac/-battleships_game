import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EmenyShipMedium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmenyShipMedium extends EmenyShip
{
    public EmenyShipMedium()
    {
        super(15,1,15,new GreenfootImage("shipM_destroyed.png"));
    } 
    public void act()
    {
        move(3);
        turnAtEdge();
        lookForShip(2);
        lookForOtherActor(EmenyShip.class);
        lookForOtherActor(Rock.class);
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
       sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipMedium());
       Counter counter = sea.getCounter();
       counter.addScore(2);
        //--------------------------
       setImage(explosion);
       Greenfoot.delay(1);
       getWorld().removeObject(this);
        /*Greenfoot.playSound("Explosion.wav");
        Sea sea = (Sea) getWorld();
        if(sea.getClass() == SeaLevel1.class)
        {
        SeaLevel1 seaLevel1 = (SeaLevel1) sea;
        seaLevel1.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipMedium());
        Counter counter = seaLevel1.getCounter();
        counter.addScore(2);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this); 
        }
        else
        {
        SeaLevel2 seaLevel2 = (SeaLevel2) sea;
        seaLevel2.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipMedium());
        Counter counter = seaLevel2.getCounter();
        counter.addScore(2);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this); 
        }
        */
        
       
       
    }
}
