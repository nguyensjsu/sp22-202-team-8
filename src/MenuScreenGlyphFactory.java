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
        startButton.create("Start", 50, new Color(0, 0, 0, 0), 280, 80, new Color(0, 0, 0, 0));
        startButton.setLocation(235, 640);
        startButton.setNextScreen(MyWorld.SCREENS.GAME);
        
        lbButton = new Button(world);
        lbButton.create("Leaderboard", 20, new Color(0, 0, 0, 0), 220, 60, new Color(0, 0, 0, 0));
        lbButton.setLocation(700, 640);
        lbButton.setNextScreen(MyWorld.SCREENS.LEADERBOARD);
        
        exitButton = new Button(world);
        exitButton.create("Exit", 30, new Color(0, 0, 0, 0), 120, 55, new Color(0, 0, 0, 0));
        exitButton.setLocation(1150, 680);
    
    }
    
    public void CreateLabel() {
        screenTitle = new Label(world);
        screenTitle.create("JetSpace", 50, Color.BLUE, world.WIDTH/2, world.HEIGHT/4, new Color(0, 0, 0, 0));
        screenTitle.setLocation(world.WIDTH*3/8, world.HEIGHT/5);
    
    }
    
    public void CreateMode() {
        onePlayerMode = new Mode(world);
        onePlayerMode.create("mode1.png", 25, new Color(0, 0, 0, 0), world.WIDTH/4, world.HEIGHT/8, new Color(0, 0, 0, 0));
        onePlayerMode.setLocation(320, world.HEIGHT*2/5);
        onePlayerMode.setMode(Settings.MODE.ONE_PLAYER);
        
        twoPlayerMode = new Mode(world);
        twoPlayerMode.create("mode2.png", 25, new Color(0, 0, 0, 0), world.WIDTH/4, world.HEIGHT/8, new Color(0, 0, 0, 0));
        twoPlayerMode.setLocation(630, world.HEIGHT*2/5);
        twoPlayerMode.setMode(Settings.MODE.TWO_PLAYER);
    }
    
}
