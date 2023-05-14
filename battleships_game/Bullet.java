import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Bullet extends SmoothMover
{
    protected  int damage;
    protected  int life = 30;
    public void act()
    {
        // Add your action code here.
    }
    
    public Bullet(Vector speed, int rotation,int d)
    {
        super(speed);
        this.damage = d;
        setRotation(rotation);
        addForce(new Vector(rotation, 15));
    }
    
    /*public void checkIfGoOutOfWorld()
    {
        if(atWorldEdge())
        {
            getWorld().removeObject(this);
        }
    }*/
    
    public boolean atWorldEdge()
    {
        int edgeDistance = 10;
        if(getX() < edgeDistance || getX() >= getWorld().getWidth() || getY() < edgeDistance || getY() >= getWorld().getHeight()) {
           return true;
        }
        return false;

    }
    
}
