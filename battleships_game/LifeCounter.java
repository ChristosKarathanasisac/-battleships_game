import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

//import java.awt.Color;
import java.awt.Graphics;

/**
 * LifeCounter that displays a text and number.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class LifeCounter extends Actor
{
    int lifes = 2;
    
   public LifeCounter()
   {
       act();
       
   }
   public void act() {
       setImage(new GreenfootImage("Lifes: "+lifes, 32, Color.WHITE, new Color(18, 113, 222)));
    }

    public void reduceLife()
    {
        lifes--;
    }
}
