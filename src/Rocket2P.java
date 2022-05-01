import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket2P extends Rocket
{
    private int speed;
    private int coolDown;
    private int coolDownRange;
    private int speedEffect;
    private int cdEffect;
    private int lift;
    private static boolean isStopped;
    private ArrayList<IStopObserver> observers;
    
    /**
     * Reference: https://www.greenfoot.org/topics/5092
     */ 
    public Rocket2P() {
        observers = new ArrayList<>();
        GreenfootImage image = getImage();  
        image.scale(50, 40);
        setImage(image);
        speed = 5;
        coolDown = 0;
        coolDownRange = 25;
        speedEffect = 0;
        cdEffect = 0;
        life = 2;
        isStopped = false;
    }
    
    @Override
    protected void updateHP() {
        if (isTouching(Rock.class) && !isStopped) {
            if (life == 0){
                //notifyGameOverObserver( ) ;
                isStopped = true; 
                super.crashedCount++;
            }
            removeRock();
            World world = getWorld();
            MyWorld myWorld = (MyWorld)world;
            Heart heart = myWorld.getP2HP().get(life);
            heart.setLifeAmount(0);
            life--;
            life = Math.max(0, life);
        }
    }
    
    @Override
    protected void move() {
        if (!isStopped) {
            getBuff();
            keySet();
        }
    }
    /**
     * Act - do whatever the rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }

    @Override
    protected void keySet(){
        if ( Greenfoot.isKeyDown("w") )
        {
            setLocation( getX(), getY() - speed );
        }

        if ( Greenfoot.isKeyDown("s") )
        {
            setLocation( getX(), getY() + speed );
        }

        if ( Greenfoot.isKeyDown("a") )
        {
            setLocation( getX() - speed , getY() );
        }

        if ( Greenfoot.isKeyDown("d") )
        {
            setLocation( getX() + speed , getY() );
        }
        
        if (coolDown > 0) {
            coolDown--;
        } else if (Greenfoot.isKeyDown("space")) {
            getWorld().addObject(new Shot(this), getX(), getY());
            coolDown = coolDownRange;
        }
    }
    
    public void registerObserver(IStopObserver o) {
        observers.add(o);
    }
    
    public void notifyGameOverObserver(){
        super.notifyGameOverObserver();
        for (int i = 0; i < observers.size(); i++)
        {
            IStopObserver observer = observers.get(i) ;
            observer.stop();
        }
    }
    
    @Override
    protected void getBuff() {
        speedEffect--;
        cdEffect--;
        speedEffect = Math.max(0, speedEffect);
        cdEffect = Math.max(0, cdEffect);
        
        // when exceed the effect time, set speed to initial value
        if (speedEffect == 0) {
            this.speed = 5;
        }
        
        // when exceed the effect time, set cool down time to initial value
        if (cdEffect == 0) {
            this.coolDownRange = 25;
        }
        
        // check speed up buff
        if (isTouching(SpeedUp.class)) {
            // maximum speed is 10
            this.speed = Math.min(2 + speed, 10);
            this.speedEffect = 300;
            SpeedUp theSU = (SpeedUp)getOneIntersectingObject(SpeedUp.class);
            getWorld().removeObject(theSU);
        }
        
        // check faster shot buff
        if (isTouching(FasterShot.class)) {
            // minimum cool down range is 10
            this.coolDownRange = Math.max(coolDownRange - 10, 10);
            this.cdEffect = 300;
            FasterShot theFS = (FasterShot)getOneIntersectingObject(FasterShot.class);
            getWorld().removeObject(theFS);
        }
    }
}
