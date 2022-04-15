import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class horizontalScrolling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HorizontalScrolling extends Actor implements IStopObserver
{
    protected int scrollSpeed = -3;
    private static boolean isStopped = false;
    
    public HorizontalScrolling()
    {
        this.isStopped = false;
    }
    
    /**
     * Act - do whatever the horizontalScrolling wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!isStopped) {
            scrollLeft();
        }
    }
    
    public void stop() {
        this.isStopped = true;
    }
    
    protected void scrollLeft()
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
