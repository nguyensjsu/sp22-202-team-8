import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leveltext here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leveltext extends Actor
{
    private int level = 1;
    /**
     * Act - do whatever the Leveltext wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        update();
    }
    
    public void update()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        Counter counter = myWorld.getCounter();
        
        if(counter.getValue() >= 50){
            level = (counter.getValue()/50)+1;
            if(level > 3){
                level = 3;
            }
        }
        GreenfootImage img = getImage();
        img.clear();
        setImage(new GreenfootImage("Level : " + level , 20 , Color.ORANGE, Color.BLACK));
    }
    
}
