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
        /*Greenfoot.playSound("Explosion.wav");
        Sea sea = (Sea) getWorld();
        sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipMedium());
        Counter counter = sea.getCounter();
        counter.addScore(2);
        //--------------------------
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this);
        */
       
       Greenfoot.playSound("Explosion.wav");
        
        
        SeaLevel1 sea = (SeaLevel1) getWorld();
        if(sea != null)
        {
            sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipLarge());
            Counter counter = sea.getCounter();
            counter.addScore(6);
            //--------------------------
            setImage(explosion);
            Greenfoot.delay(1);
            getWorld().removeObject(this);
            if(counter.score > 10)
            {
                 Greenfoot.setWorld(new SeaLevel2(sea.getHealthBar(),sea.getCounter(),sea.getLifeCounter(),sea.getMyShip()));
            }

        }
        else
        {
            sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(400),new EmenyShipLarge());
            Counter counter = sea.getCounter();
            counter.addScore(6);
        }
    }
}
