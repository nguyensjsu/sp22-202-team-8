import greenfoot.*; 
/**
 * Write a description of class MenuScreenGlyphFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreenGlyphFactory implements IGlyphFactory
{
    public Button startButton;
    public Label screenTitle;
    private Color startButtonColor;
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
        startButton.create("Start", world.WIDTH/4, world.HEIGHT/8, startButtonColor);
        startButton.setLocation(world.WIDTH/2, world.HEIGHT*3/4);
        startButton.setNextScreen(MyWorld.SCREENS.GAME);
    
    }
    
    public void CreateLabel() {
        screenTitle = new Label(world);
        screenTitle.create("JetSpace", world.WIDTH/2, world.HEIGHT/4, Color.BLUE);
        screenTitle.setLocation(world.WIDTH/2, world.HEIGHT/4);
    
    }
}
