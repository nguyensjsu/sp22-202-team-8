import greenfoot.*;

/**
 * Write a description of class LeaderboardScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeaderboardScreen extends Screen 
{
    private Button backToMenuButton;
    private Button tryAgainButton;
    private Color buttonColor;

    /**
     * Constructor for objects of class LeaderboardScreen
     */
    public LeaderboardScreen(MyWorld world)
    {
        super(world, new GreenfootImage("sandstone.jpg"));
        
        buttonColor = new Color(165, 165, 165);
        backToMenuButton = new Button("Back", world.WIDTH/5, world.HEIGHT/8, world, buttonColor);
        backToMenuButton.setNextScreen(MyWorld.SCREENS.MENU);
        tryAgainButton = new Button("TryAgain", world.WIDTH/5, world.HEIGHT/8, world, buttonColor);
        tryAgainButton.setNextScreen(MyWorld.SCREENS.GAME);
    }

    public void active()
    {
        super.active();
        
        world.addObject(tryAgainButton, world.WIDTH/3, world.HEIGHT*3/4);
        world.addObject(backToMenuButton, world.WIDTH*2/3, world.HEIGHT*3/4);
        act();
    }

    

    public void act()
    {
        if(Greenfoot.mouseClicked(tryAgainButton)){
            tryAgainButton.onClick();
        }
        
        if(Greenfoot.mouseClicked(backToMenuButton)){
            backToMenuButton.onClick();
        }
    }
}
