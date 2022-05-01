import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class horizontalScrolling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HorizontalScrolling extends Actor implements IStopObserver
{
    protected static int scrollSpeed;
    private static boolean isStopped;
    
    public HorizontalScrolling()
    {
        this.isStopped = false;
        this.scrollSpeed = -4;
    }
    
    public static int getScrollSpeed() {
        return scrollSpeed;
    }
    
    public static void setScrollSpeed(int speed) {
        // maximun movind speed = -10
        scrollSpeed = Math.max(speed, -10);
    }
    
    /**
     * Act - do whatever the horizontalScrolling wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!isStopped) {
            scroll();
        }
    }
    
    public void stop() {
        this.isStopped = true;
    }
    
    protected void scroll()
    {
        move( scrollSpeed );
        if ( isAtEdge() )
        {
            reset(); 
        }
    }
    
    public void reset()
    {
        int x = getWorld().getWidth() - Greenfoot.getRandomNumber(100);
        int y = Greenfoot.getRandomNumber( getWorld().getHeight() );
        setLocation( x , y );
    }
}
