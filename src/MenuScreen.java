import greenfoot.*;

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class MenuScreen extends Screen 
{
    private Button startButton;
    private Color startButtonColor;
    /**
     * Constructor for objects of class MenuScreen
     */
    public MenuScreen(MyWorld world)
    {
        super(world, new GreenfootImage("bluerock.jpg"));
        
        startButtonColor = new Color(0, 102, 204);
        startButton = new Button("Start", world.WIDTH/4, world.HEIGHT/8, world, startButtonColor);
        startButton.setNextScreen(MyWorld.SCREENS.GAME);
        
    }

    public void active()
    {
        super.active();
        world.addObject(startButton, world.WIDTH/2, world.HEIGHT*3/4);
        act();
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(startButton)){
               startButton.onClick();
        }
    }
}
