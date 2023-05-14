import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Ship extends SmoothMover
{
   protected int gunReloadTime;
   protected int reloadDelayCount;               
   protected int initial_life;
   protected int life;
   protected GreenfootImage destroyed_ship; 
   protected GreenfootImage explosion =new GreenfootImage("explosion-big.png");;
   protected boolean lock = false;
   
    public Ship(int _gunReloadTime,int _reloadDelayCount,int _life,GreenfootImage _destroyed_ship)
    {
        this.gunReloadTime = _gunReloadTime;
        this.reloadDelayCount = _reloadDelayCount;
        this.destroyed_ship = _destroyed_ship;
        this.life = _life;
        this.initial_life = life;
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public int getLife(int l) 
    {
       return this.life;
    }
    
    public void setLife(int l) 
    {
       this.life = l;
    }
    
    
    protected void fire(Bullet bullet) 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Greenfoot.playSound("EnergyGun.wav");
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
    
    
    
}
