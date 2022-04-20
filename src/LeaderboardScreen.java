import greenfoot.*;
import java.util.ArrayList;
/**
 * Write a description of class LeaderboardScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeaderboardScreen extends Screen implements IDisplayComponent
{
    private LeaderboardScreenGlyphFactory lbGlyphFactory; 
    private final ArrayList<IDisplayComponent> components;
    //private Button backToMenuButton;
    //private Button tryAgainButton;
    //private Color buttonColor;

    /**
     * Constructor for objects of class LeaderboardScreen
     */
    public LeaderboardScreen(MyWorld world)
    {
        super(world, new GreenfootImage("sandstone.jpg"));
        components = new ArrayList<>();
        lbGlyphFactory = LeaderboardScreenGlyphFactory.getInstance(world);
        //buttonColor = new Color(165, 165, 165);
        //backToMenuButton = new Button(world);
        //backToMenuButton.create("Back", world.WIDTH/5, world.HEIGHT/8,buttonColor); 
        //backToMenuButton.setNextScreen(MyWorld.SCREENS.MENU);
        //tryAgainButton = new Button(world);
        //tryAgainButton.create("TryAgain", world.WIDTH/5, world.HEIGHT/8,buttonColor); 
        //tryAgainButton.setNextScreen(MyWorld.SCREENS.GAME);
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
        addSubComponent(lbGlyphFactory.screenTitle);
        addSubComponent(lbGlyphFactory.backToMenuButton);
        display();
        act();

    }

    public void act()
    {
        if(Greenfoot.mouseClicked(lbGlyphFactory.backToMenuButton)){
            lbGlyphFactory.backToMenuButton.onClick();
        }
    }
}
