import greenfoot.*; 
/**
 * Write a description of class MenuScreenGlyphFactory here.
 * 
 * @author (Team 8) 
 * @version (v0.1)
 */
public class LeaderboardScreenGlyphFactory implements IGlyphFactory
{
    public static Button backToMenuButton;
    public static Label screenTitle;
    public static Leaderboard leaderboard;
    private Color backToMenuButtonColor;
    private static LeaderboardScreenGlyphFactory leaderboardScreenGlyphFactory = null;
    private MyWorld world;
    /**
     * Constructor for objects of class MenuScreenGlyphFactory
     */
    public LeaderboardScreenGlyphFactory(MyWorld world)
    {
        this.world = world;
        CreateButton();
        CreateLabel();
    }

    public synchronized static LeaderboardScreenGlyphFactory getInstance(MyWorld world) {
        if(leaderboardScreenGlyphFactory == null) {
            leaderboardScreenGlyphFactory = new LeaderboardScreenGlyphFactory(world);
            return leaderboardScreenGlyphFactory;
        }
        return leaderboardScreenGlyphFactory;
    }
    
    public void CreateButton() {
        backToMenuButtonColor = new Color(165, 165, 165);
        backToMenuButton = new Button(world);
        backToMenuButton.create("Back", world.WIDTH/4, world.HEIGHT/10, backToMenuButtonColor);
        backToMenuButton.setLocation(world.WIDTH/2, world.HEIGHT*3/4);
        backToMenuButton.setNextScreen(MyWorld.SCREENS.MENU);
    
    }
    
    public void CreateLabel() {
        screenTitle = new Label(world);
        screenTitle.create("Leaderboard", world.WIDTH/2, world.HEIGHT/8, Color.RED);
        screenTitle.setLocation(world.WIDTH/2, world.HEIGHT/6);
        leaderboard = new Leaderboard(world);
        leaderboard.create(String.valueOf(world.getCounter().getValue()), world.WIDTH/2, world.HEIGHT/4, Color.YELLOW);
        leaderboard.setLocation(world.WIDTH/2, world.HEIGHT/2);
    }
}
