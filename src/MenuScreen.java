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
    private MenuScreenGlyphFactory menuScreenGlyphFactory; 
    private final ArrayList<IDisplayComponent> components;
    /**
     * Constructor for objects of class MenuScreen
     */
    public MenuScreen(MyWorld world)
    {
        super(world, new GreenfootImage("bluerock.jpg"));
        components = new ArrayList<>();
        menuScreenGlyphFactory = MenuScreenGlyphFactory.getInstance(world);
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
        addSubComponent(menuScreenGlyphFactory.screenTitle);
        addSubComponent(menuScreenGlyphFactory.startButton);
        display();
        act();
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(menuScreenGlyphFactory.startButton)){
               menuScreenGlyphFactory.startButton.onClick();
        }
    }
}
