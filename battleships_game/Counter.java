import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

//import java.awt.Color;
import java.awt.Graphics;

/**
 * Counter that displays a text and number.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Counter extends Actor
{
    int score = 0;
    
   public Counter()
   {
       act();
       
   }
   public void act() {
       setImage(new GreenfootImage("Score: "+score, 32, Color.GREEN, new Color(18, 113, 222)));
    }

    public void addScore(int add_score)
    {
        score += add_score;
    }
}
