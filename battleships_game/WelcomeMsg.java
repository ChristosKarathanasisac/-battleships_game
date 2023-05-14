import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.util.Calendar;

/**
 * The WelcomeMsg is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling
 * @version 1.0
 */
public class WelcomeMsg extends Actor
{
    public static final float FONT_SIZE = 40.0f;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    /**
     * Create a score board with dummy result for testing.
     */

    /**
     * Create a score board for the final result.
     */
    public WelcomeMsg()
    {
        makeImage("Welcome", "Score: ");
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("s"))
        {
            Greenfoot.setWorld(new SeaLevel1());
        }
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + "test", 60, 200);
        setImage(image);
    }
}
