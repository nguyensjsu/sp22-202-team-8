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
    private int shotSpeed = 6;
    
    public Shot(Rocket r) {
        this.owner = r;
    }
    /**
     * Act - do whatever the Shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (hitRock()) {
            World world = getWorld();
            MyWorld myWorld = (MyWorld)world;
            Counter counter = myWorld.getCounter();
            counter.add(10);
            getWorld().removeObject(this);
        } else if (isAtEdge()) {
            getWorld().removeObject(this);
        } else {
            setLocation( getX() + shotSpeed , getY() );
        }
    }
    
    private boolean hitRock() {
        Rock theRock = (Rock)(getOneIntersectingObject( Rock.class ));
        if (theRock != null) {
            theRock.destroyed();
            return true;
        }
        return false;
    }
}
