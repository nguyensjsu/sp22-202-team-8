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
    private Button lbButton;
    private Button exitButton;
    private Label screenTitle;
    private Mode onePlayerMode;
    private Mode twoPlayerMode;
    private MusicController mc;
    private MenuScreenGlyphFactory menuScreenGlyphFactory; 
    private final ArrayList<IDisplayComponent> components;
    /**
     * Constructor for objects of class MenuScreen
     */
    public MenuScreen(MyWorld world)
    {
        super(world, new GreenfootImage("startPage-medium.png"));
        components = new ArrayList<>();
        menuScreenGlyphFactory = MenuScreenGlyphFactory.getInstance(world);
        startButton = menuScreenGlyphFactory.startButton;
        lbButton = menuScreenGlyphFactory.lbButton;
        exitButton = menuScreenGlyphFactory.exitButton;
        screenTitle = menuScreenGlyphFactory.screenTitle;
        onePlayerMode = menuScreenGlyphFactory.onePlayerMode;
        twoPlayerMode = menuScreenGlyphFactory.twoPlayerMode;
        mc = MusicController.getInstance();
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
        //addSubComponent(menuScreenGlyphFactory.screenTitle);
        addSubComponent(startButton);
        addSubComponent(lbButton);
        addSubComponent(exitButton);  
        addSubComponent(onePlayerMode);
        addSubComponent(twoPlayerMode);
        display();
        act();
    }

    public void act()
    {       
        if(Greenfoot.mouseClicked(startButton)){
                startButton.onClick();
        }
        if(Greenfoot.mouseClicked(lbButton)){
               lbButton.onClick();
        }
        if(Greenfoot.mouseClicked(exitButton)){
                mc.stop();
                Greenfoot.stop();
        }
        if(Greenfoot.mouseClicked(onePlayerMode)){
               onePlayerMode.onClick();
               twoPlayerMode.unClick();
        }
        if(Greenfoot.mouseClicked(twoPlayerMode)){
               twoPlayerMode.onClick();
               onePlayerMode.unClick();
        }
    }
}
