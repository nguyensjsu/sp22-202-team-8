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
    private boolean Rockhit = false;
    private boolean SinRockhit = false;
    
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
            if(Rockhit){
                ScoreContext context = new ScoreContext(new OperationHitRock());
                int sum = context.executeStrategy(counter.getValue());
                counter.setValue(sum);
            }
            else if (SinRockhit){
                ScoreContext context = new ScoreContext(new OperationHitSinRock());
                int sum = context.executeStrategy(counter.getValue());
                counter.setValue(sum);
            }
            getWorld().removeObject(this);
        } else if (isAtEdge()) {
            getWorld().removeObject(this);
        } else {
            setLocation( getX() + shotSpeed , getY() );
        }
    }
    
    private boolean hitRock() {
        Rock theRock = (Rock)(getOneIntersectingObject( Rock.class ));
        SinRock theSinRock = (SinRock)(getOneIntersectingObject( SinRock.class ));
        
        if (theSinRock != null) {
            SinRockhit = true;
            theSinRock.destroyed();
            return true;
        }
        else if (theRock != null) {
            Rockhit = true;
            theRock.destroyed();
            return true;
        }
        return false;
    }
}
