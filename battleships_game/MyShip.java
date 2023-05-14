import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyShip extends Ship
{
    public MyShip(int _gunReloadTime,int _reloadDelayCount,GreenfootImage _destroyed_ship)
    {
        super(_gunReloadTime,_reloadDelayCount,30,_destroyed_ship);
    } 
    public void act()
    {
        move();
        checkKeys();
        checkIfShipIsToDamaged();
        lookForEmenyShip(EmenyShip.class);
        reloadDelayCount++;
    }
    private void checkKeys() 
    {
        if(Greenfoot.isKeyDown("up"))
        {
            addForce (new Vector(getRotation(), 0.1));
        }
        if (Greenfoot.isKeyDown("left")) 
        {
            setRotation(getRotation() - 1);
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setRotation(getRotation() + 1);
        }
        if (Greenfoot.isKeyDown("down")) 
        {
              Vector currentVelocity = getMovement(); 
              currentVelocity.scale(0.9); // reduce speed by 10%
              setMovement(currentVelocity);
         
        }
        if (Greenfoot.isKeyDown("space")) 
        {
            fire(new ShipBullet (getMovement().copy(), getRotation(),1));
        }
    }
    
    private void checkIfShipIsToDamaged()
    {
        World myWorld = getWorld();
        Sea sea = (Sea)myWorld;
        HealthBar healthBar = sea.getHealthBar();
        if(healthBar.health<=0)
        {
            return;
        }
        if(healthBar.health < ((int) healthBar.initial_health/2))
        {
            setImage(destroyed_ship);
        }
    }
    
    public void hit(int damage) 
    {
        World myWorld = getWorld();
        Sea sea = (Sea)myWorld;
        HealthBar healthBar = sea.getHealthBar();
        healthBar.loseHealth(damage);
        if(healthBar.health <= 0)
        {
            breakUp();
            sea.gameOver();
        }
        
    }
    
    private void lookForEmenyShip(Class cls)
    {
        Actor actor = getOneObjectAtOffset(0,0,cls);
        EmenyShip emShip = (EmenyShip) actor;
        if(emShip != null)
        {
           emShip.breakUp();
           Sea sea = (Sea) getWorld();
           //sea.emenyShipGenerator(70,Greenfoot.getRandomNumber(600));
           hit(5);
        }
    }
    
    public void breakUp() 
    {
        Greenfoot.playSound("Explosion.wav");
        setImage(explosion);
        Greenfoot.delay(1);
        getWorld().removeObject(this);
        
        
    }
}
