import greenfoot.*;
import java.util.ArrayList;
/**
 * Write a description of class MenuScreen here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class MenuScreen extends Screen implements IDisplayComponent
{
    private Button startButton;
    private Color startButtonColor;
    private final ArrayList<IDisplayComponent> components;
    /**
     * Constructor for objects of class MenuScreen
     */
    public MenuScreen(MyWorld world)
    {
        super(world, new GreenfootImage("bluerock.jpg"));
        components = new ArrayList<>();
        
        startButtonColor = new Color(0, 102, 204);
        startButton = new Button( world);
        startButton.create("Start", world.WIDTH/4, world.HEIGHT/8,startButtonColor);
        startButton.setLocation(world.WIDTH/2, world.HEIGHT*3/4);
        startButton.setNextScreen(MyWorld.SCREENS.GAME);
        
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
        addSubComponent(startButton);
        display();
        act();
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(startButton)){
               startButton.onClick();
        }
    }
}
