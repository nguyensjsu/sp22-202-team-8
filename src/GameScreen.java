import greenfoot.*;
/**
 * Write a description of class GameS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameScreen extends Screen 
{

    private static boolean initialized = false;
    
    /**
     * Constructor for objects of class GameS
     */
    public GameScreen(MyWorld world)
    {
        super(world, new GreenfootImage("space.jpg"));
    }

    public static void initialize() {
        initialized= false;
    }
    
    public void active()
    {
        super.active();
        act();
    }
    
    public void act()
    {
        if (!initialized) {
            world.prepare();
            initialized = true;
            
        }
    }
}
