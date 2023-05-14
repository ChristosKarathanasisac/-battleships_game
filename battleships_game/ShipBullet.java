import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShipBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShipBullet extends Bullet
{
    /**
     * Act - do whatever the ShipBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            if(!checkEmenyShipHit())
            {
                if(atWorldEdge())
                {
                    getWorld().removeObject(this);
                }
            }
        }
    }
    
   public ShipBullet(Vector speed, int rotation,int d)
    {
        //super(speed);
        super(speed,rotation,d);
        
    }
    
    private boolean checkEmenyShipHit()
    {
        EmenyShip ship = (EmenyShip) getOneIntersectingObject(EmenyShip.class);
        if (ship != null){
            getWorld().removeObject(this);
            ship.hit();
            return true;
        }
        return false;
    }
}
