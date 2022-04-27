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
    private int speed = 5;
    private int coolDown = 0;
    private boolean isStopped = false;
    private ArrayList<IStopObserver> observers;
    
    /**
     * Reference: https://www.greenfoot.org/topics/5092
     */ 
    public Rocket2P() {
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
            coolDown = 50;
        }
    }
    
    public void registerObserver(IStopObserver o) {
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
