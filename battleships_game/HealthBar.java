import greenfoot.*;

public class HealthBar extends Actor {
    int health = 20;
    int initial_health  =20;
    int healthBarWidth = 80;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint = (int)healthBarWidth/health;
    
    public HealthBar()
    {
        update();
    }
    
    public void act()
    {
        update();
    }
    
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth +1 ,healthBarHeight + 1));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(1, 1, healthBarWidth + 1, healthBarHeight+1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1,1, health * pixelsPerHealthPoint, healthBarHeight);
    }
    
    public void loseHealth(int damage)
    {
        health-=damage;
        if(health<=0)
        {
            health = 0;
        }
    }
}
