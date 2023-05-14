import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wave extends Actor
{
    private int x;
    private int y;
    private int speed;
    
    public Wave(int speed,int set_x,int set_y) {
        x = set_x;
        y = set_y;
        this.speed = speed;
    }
    
    public void act() {
        y += speed;
        if (y > getWorld().getHeight()) {
            y = 0;
        }
        setLocation(x, y);
    }
    
    public void draw() {
       GreenfootImage image = new GreenfootImage(getWorld().getWidth(), getWorld().getHeight());
       image.setColor(Color.WHITE);
        for (int i = 0; i < image.getWidth()/4; i++) {
            int x1 = i;
            int y1 = (int)(200 + 5 * Math.sin((double)i * 0.1));
            int x2 = (i + 1);
            int y2 = (int)(200 + 5 * Math.sin((double)(i + 1) * 0.1));
            image.drawLine(x1, y1, x2, y2);
        }
        for (int i = image.getWidth()/4; i < image.getWidth()/2; i++) {
            int x1 = i;
            int y1 = (int)(200 + 5 * Math.sin((double)(i - image.getWidth() / 2) * 0.1));
            int x2 = (i + 1);
            int y2 = (int)(200 + 5 * Math.sin((double)(i - image.getWidth() / 2 + 1) * 0.1));
            image.drawLine(x1, y1, x2, y2);
        }
        for (int i = image.getWidth()/2; i < image.getWidth(); i++) {
            int x1 = i;
            int y1 = (int)(200 + 5 * Math.sin((double)(i - image.getWidth() / 2) * 0.1));
            int x2 = (i + 1);
            int y2 = (int)(200 + 5* Math.sin((double)(i - image.getWidth() / 2 + 1) * 0.1));
            image.drawLine(x1, y1, x2, y2);
        }
        setImage(image);
    }
}
