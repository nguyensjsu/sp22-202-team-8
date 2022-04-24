import greenfoot.*; 
/**
 * Write a description of class MenuScreenGlyphFactory here.
 * 
 * @author (Team 8) 
 * @version (v0.1)
 */
public class MenuScreenGlyphFactory implements IGlyphFactory
{
    public static Button startButton;
    public static Label screenTitle;
    private Color startButtonColor;
    public static Mode onePlayerMode;
    public static Mode twoPlayerMode;
    
    private static MenuScreenGlyphFactory menuScreenGlyphFactory = null;
    private MyWorld world;
    /**
     * Constructor for objects of class MenuScreenGlyphFactory
     */
    public MenuScreenGlyphFactory(MyWorld world)
    {
        this.world = world;
        CreateButton();
        CreateLabel();
        CreateMode();
    }

    public synchronized static MenuScreenGlyphFactory getInstance(MyWorld world) {
        if(menuScreenGlyphFactory == null) {
            menuScreenGlyphFactory = new MenuScreenGlyphFactory(world);
            return menuScreenGlyphFactory;
        }
        return menuScreenGlyphFactory;
    }
    
    public void CreateButton() {
        startButtonColor = new Color(0, 102, 204);
        startButton = new Button( world);
        startButton.create("Start", world.WIDTH/4, world.HEIGHT/10, startButtonColor);
        startButton.setLocation(world.WIDTH/2, world.HEIGHT*4/5);
        startButton.setNextScreen(MyWorld.SCREENS.GAME);
    
    }
    
    public void CreateLabel() {
        screenTitle = new Label(world);
        screenTitle.create("JetSpace", world.WIDTH/2, world.HEIGHT/4, Color.BLUE);
        screenTitle.setLocation(world.WIDTH/2, world.HEIGHT/6);
    
    }
    
    public void CreateMode() {
        onePlayerMode = new Mode(world);
        onePlayerMode.create("OnePlayer", world.WIDTH/4, world.HEIGHT/8, Color.RED);
        onePlayerMode.setLocation(world.WIDTH*3/8, world.HEIGHT/2);
        onePlayerMode.setMode(Settings.MODE.ONE_PLAYER);
        
        twoPlayerMode = new Mode(world);
        twoPlayerMode.create("TwoPlayer", world.WIDTH/4, world.HEIGHT/8, Color.RED);
        twoPlayerMode.setLocation(world.WIDTH*5/8, world.HEIGHT/2);
        twoPlayerMode.setMode(Settings.MODE.TWO_PLAYER);
    }
    
}
