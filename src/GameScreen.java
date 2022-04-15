import greenfoot.*;
/**
 * Write a description of class GameScreen here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class GameScreen extends Screen  
{
    private Button gameoverButton;
    private Color gameoverButtonColor;
    
    /**
     * Constructor for objects of class GameScreen
     * 
     */
    public GameScreen(MyWorld world)
    {
        super(world, new GreenfootImage("cell.jpg"));
        
        gameoverButtonColor = new Color(207, 136, 23);
        gameoverButton = new Button("GameOver", world.WIDTH/4, world.HEIGHT/8, world, gameoverButtonColor);
        gameoverButton.setNextScreen(MyWorld.SCREENS.LEADERBOARD);
    }

    
    public void active()
    {
        super.active();
        world.addObject(gameoverButton, world.WIDTH/2, world.HEIGHT*3/4);
        act();
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(gameoverButton)){
            gameoverButton.onClick();
        }
    }
}
