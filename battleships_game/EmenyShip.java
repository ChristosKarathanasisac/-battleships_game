import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class EmenyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class EmenyShip extends Ship
{
    public EmenyShip(int _gunReloadTime,int _reloadDelayCount,int _life,GreenfootImage _destroyed_ship)
    {
        super(_gunReloadTime,_reloadDelayCount,_life,_destroyed_ship);
    } 
    public void act()
    {
        // Add your action code here.
    }
    public void lookForShip(int damage)
    {
        
        if(scanForShip())
        {
            this.lock = true;
            fire(new EmenyBullet (getMovement().copy(), getRotation(),damage));
        }else
        {
            this.lock = false;
        }
    }
   
    private boolean scanForShip()
    {
        List<MyShip> nearbyShips;
        nearbyShips = getObjectsInRange(500, MyShip.class);
        for (Actor object : nearbyShips) {
        int angle = getRotation();
        int halfFieldOfView = 30; 
        int dx = object.getX() - getX();
        int dy = object.getY() - getY();
        int objectAngle = (int) Math.toDegrees(Math.atan2(dy, dx)) - angle;
        objectAngle = (objectAngle + 360) % 360;
        if (objectAngle <= halfFieldOfView || objectAngle >= 360 - halfFieldOfView) {
            return true;
            }
        }
        return false;
        
    }
    protected void checkIfShipIsToDamaged()
    {
        if(life <= 0){return;}
        if(life < ((int) initial_life/2))
        {
            setImage(destroyed_ship);
        }
    }
    
    protected void lookForOtherActor(Class cls)
    {
        Actor actor = getOneObjectAtOffset(0,0,cls);
        if(actor != null)
        {
             turn(Greenfoot.getRandomNumber(10)*6);
        }
    }
    protected boolean atWorldEdge()
    {
        if(getX() < 40 || getX() > getWorld().getWidth() - 40)
            return true;
        if(getY() < 40 || getY() > getWorld().getHeight() - 40)
            return true;
        else
            return false;

    }
    protected void turnAtEdge()
    {  
        if (atWorldEdge())
        {
            turn(Greenfoot.getRandomNumber(180));
        }     
    } 
    
    protected void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90 )
            turn(Greenfoot.getRandomNumber(90) - 45);
    }
    public void hit() 
    {
        life = life - 1;
        if(life <= 0) 
        {
            breakUp(); 
        }            
    }
    public void breakUp() 
    {
        
    }
    
}
