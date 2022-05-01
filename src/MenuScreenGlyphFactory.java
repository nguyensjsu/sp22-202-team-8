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
    public static Button lbButton;
    public static Button exitButton;
    public static Label screenTitle;
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
        startButton = new Button(world);
        startButton.create(false, "Start", 50, new Color(0, 0, 0, 0), 250, 70, new Color(0, 0, 0, 0));
        startButton.setLocation(world.WIDTH*9/50, world.HEIGHT*4/5);
        startButton.setNextScreen(MyWorld.SCREENS.GAME);
        
        lbButton = new Button(world);
        lbButton.create(false, "Leaderboard", 20, new Color(0, 0, 0, 0), 184, 50, new Color(0, 0, 0, 0));
        lbButton.setLocation(world.WIDTH*11/20, world.HEIGHT*4/5);
        lbButton.setNextScreen(MyWorld.SCREENS.LEADERBOARD);
        
        exitButton = new Button(world);
        exitButton.create(false, "Exit", 30, new Color(0, 0, 0, 0), 100, 50, new Color(0, 0, 0, 0));
        exitButton.setLocation(world.WIDTH*9/10, world.HEIGHT*17/20);
    
    }
    
    public void CreateLabel() {
    
    }
    
    public void CreateMode() {
        onePlayerMode = new Mode(world);
        onePlayerMode.create(true, "mode1.png", 25, new Color(0, 0, 0, 0), world.WIDTH/4, world.HEIGHT/8, new Color(0, 0, 0, 0));
        onePlayerMode.setLocation(world.WIDTH/4, world.HEIGHT*2/5);
        onePlayerMode.setMode(Settings.MODE.ONE_PLAYER);
        
        twoPlayerMode = new Mode(world);
        twoPlayerMode.create(true, "mode2.png", 25, new Color(0, 0, 0, 0), world.WIDTH/4, world.HEIGHT/8, new Color(0, 0, 0, 0));
        twoPlayerMode.setLocation(world.WIDTH/2, world.HEIGHT*2/5);
        twoPlayerMode.setMode(Settings.MODE.TWO_PLAYER);
    }
    
}
