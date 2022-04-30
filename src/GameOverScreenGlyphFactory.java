import greenfoot.*; 
/**
 * Write a description of class GameOverScreenGlyphFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreenGlyphFactory implements IGlyphFactory  
{
    public static Label screenTitle;
    public static Button tryAgainButton;
    public static Button leaderboardButton;
    private Color ButtonBgColor;
    private Color screenTitleColor;
    
    private static GameOverScreenGlyphFactory gOSGlyphFactory = null;
    private MyWorld world;
    /**
     * Constructor for objects of class GameOverScreenGlyphFactory
     */
    public GameOverScreenGlyphFactory(MyWorld world)
    {
        this.world = world;
        CreateButton();
        CreateLabel();
    }
    
    public synchronized static GameOverScreenGlyphFactory getInstance(MyWorld world) {
        if(gOSGlyphFactory == null) {
            gOSGlyphFactory = new GameOverScreenGlyphFactory(world);
            return gOSGlyphFactory;
        }
        return gOSGlyphFactory;
    }

    public void CreateButton() {
        ButtonBgColor = new Color(207, 136, 23);
        
        tryAgainButton = new Button(world);
        tryAgainButton.create("Try again", 30, Color.WHITE, world.WIDTH/4, world.HEIGHT/10, ButtonBgColor);
        tryAgainButton.setLocation(world.WIDTH/3, world.HEIGHT*3/4);
        tryAgainButton.setNextScreen(MyWorld.SCREENS.GAME);

        leaderboardButton = new Button(world);
        leaderboardButton.create("Leaderboard", 30, Color.WHITE, world.WIDTH/4, world.HEIGHT/10,ButtonBgColor);
        leaderboardButton.setLocation(world.WIDTH*2/3, world.HEIGHT*3/4);
        leaderboardButton.setNextScreen(MyWorld.SCREENS.LEADERBOARD);
       
    }
    
    public void CreateLabel() {
        screenTitle = new Label(world);
        screenTitleColor = Color.ORANGE;
        screenTitle.create("Game Over", 50, screenTitleColor, world.WIDTH/2, world.HEIGHT/4,new Color(0, 0, 0, 0));
        screenTitle.setLocation(world.WIDTH/2, world.HEIGHT/3);

    }
}
