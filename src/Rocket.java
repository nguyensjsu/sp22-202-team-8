import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor implements IStopSubject
{
    private int speed = 5;
    private int coolDown = 0;
    public int life = 2;
    private boolean isStopped = false;
    private ArrayList<IStopObserver> observers;
    
    /**
     * Reference: https://www.greenfoot.org/topics/5092
     */ 
    public Rocket() {
        observers = new ArrayList<>();
        GreenfootImage image = getImage();  
        image.scale(50, 40);
        setImage(image);
    }
    
    /**
     * Act - do whatever the rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Rock.class)) {
            World world = getWorld();
            MyWorld myWorld = (MyWorld)world;
            if(life == 2){
                Heart3 heart3 = myWorld.getHeart3();
                heart3.getLifeAmount(0);
                
                Rock theRock = (Rock)(getOneIntersectingObject( Rock.class ));
                SinRock theSinRock = (SinRock)(getOneIntersectingObject( SinRock.class ));
                if (theSinRock != null) {
                    theSinRock.destroyed();
                }
                else if (theRock != null) {
                    theRock.destroyed();
                }
                life--;
            }
            else if (life == 1){
                Heart2 heart2 = myWorld.getHeart2();
                heart2.getLifeAmount(0);
                
                Rock theRock = (Rock)(getOneIntersectingObject( Rock.class ));
                SinRock theSinRock = (SinRock)(getOneIntersectingObject( SinRock.class ));
                if (theSinRock != null) {
                    theSinRock.destroyed();
                }
                else if (theRock != null) {
                    theRock.destroyed();
                }
                life--;
            }
            else if (life == 0){
                Heart1 heart1 = myWorld.getHeart();
                heart1.getLifeAmount(0);
                
                Rock theRock = (Rock)(getOneIntersectingObject( Rock.class ));
                SinRock theSinRock = (SinRock)(getOneIntersectingObject( SinRock.class ));
                if (theSinRock != null) {
                    theSinRock.destroyed();
                }
                else if (theRock != null) {
                    theRock.destroyed();
                }
                life--;
                notifyGameOverObserver( ) ;
                this.isStopped = true; 
            }
        }
        
        if (!isStopped) {
            keySet();
        }
    }
    
    protected void keySet() {
        if ( Greenfoot.isKeyDown("up") )
        {
            setLocation( getX(), getY() - speed );
        }

        if ( Greenfoot.isKeyDown("down") )
        {
            setLocation( getX(), getY() + speed );
        }

        if ( Greenfoot.isKeyDown("left") )
        {
            setLocation( getX() - speed , getY() );
        }

        if ( Greenfoot.isKeyDown("right") )
        {
            setLocation( getX() + speed , getY() );
        }
        
        if (coolDown > 0) {
            coolDown--;
        } else if (Greenfoot.isKeyDown("enter")) {
            getWorld().addObject(new Shot(this), getX(), getY());
            coolDown = 30;
        }
    }
    
    public void registerStopObserver(IStopObserver o) {
        observers.add(o);
    }
    
    public void notifyGameOverObserver(){
        for (int i = 0; i < observers.size(); i++)
        {
            IStopObserver observer = observers.get(i) ;
            observer.stop();
        }
    }
}
