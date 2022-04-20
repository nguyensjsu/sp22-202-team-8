import greenfoot.*;
import java.util.ArrayList;
/**
 * Write a description of class GameScreen here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class GameOverScreen extends Screen implements IDisplayComponent 
{
    private GameOverScreenGlyphFactory gOSGlyphFactory; 
    private final ArrayList<IDisplayComponent> components;
    /**
     * Constructor for objects of class GameScreen
     * 
     */
    public GameOverScreen(MyWorld world)
    {
        super(world, new GreenfootImage("space.jpg"));
        
        components = new ArrayList<>();
        gOSGlyphFactory = GameOverScreenGlyphFactory.getInstance(world);

    }

    public void addSubComponent( IDisplayComponent c ) {
        components.add(c);
    };
    
    public void removeSubCompnent( IDisplayComponent c ) {
        components.remove(c);
    };
    
    public void display(){
        for (IDisplayComponent dc : components) 
            dc.display();
    };
    
    public void setLocation(int x, int y){
    // do nothing
    }; 
    
    public void active()
    {
        super.active();
        world.stopped();
        
        addSubComponent(gOSGlyphFactory.screenTitle);
        addSubComponent(gOSGlyphFactory.tryAgainButton);
        addSubComponent(gOSGlyphFactory.leaderboardButton);

        display();
        act();
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(gOSGlyphFactory.leaderboardButton)){
            gOSGlyphFactory.leaderboardButton.onClick();
            //Greenfoot.start();
        }
        if(Greenfoot.mouseClicked(gOSGlyphFactory.tryAgainButton)){
            gOSGlyphFactory.tryAgainButton.onClick();
        } 
    }
}
