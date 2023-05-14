import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class EmenyBullet extends Bullet
{
    /**
     * Act - do whatever the EmenyBullet wants to do. This method is called whenever
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
        
        if(atWorldEdge())
        {
            getWorld().removeObject(this);
        }
        else
        {
            checkShipHit();
        }
            
        }
    }
    
    public EmenyBullet(Vector speed, int rotation,int d)
    {
        //super(speed);
        super(speed,rotation,d);
        
    }
    
    
    private boolean checkShipHit()
    {
        MyShip ship = (MyShip) getOneIntersectingObject(MyShip.class);
        if (ship != null){
            getWorld().removeObject(this);
            ship.hit(damage);
            return true;
        }
        return false;
    }
}
