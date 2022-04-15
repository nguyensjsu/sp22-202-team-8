import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends Actor
{
    private Rocket owner;
    private int shotSpeed = 10;
    
    public Shot(Rocket r) {
        this.owner = r;
    }
    /**
     * Act - do whatever the Shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation( getX() + shotSpeed , getY() );
        if (isAtEdge())
            getWorld().removeObject(this);
    }
}
