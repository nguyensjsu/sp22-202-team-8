import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leaderboard here.
 * 
 * @author Yiyang Yin
 * @version 4.18
 */
public class Leaderboard extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private ArrayList scores;
    private Counter counter;
    
    public Leaderboard(Counter c)
    {
        background = getImage();  // get image from class
        scores = new ArrayList();
        counter = c;
    }
    
    /**
     * Add score to the list.
     */
    public int addScore()
    {
        scores.add(counter.getValue());
        updateImage();
    }
    
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage("Wall.jpg");
        GreenfootImage text = new GreenfootImage("Leaderboard", 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
