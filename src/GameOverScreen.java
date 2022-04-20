import greenfoot.*;
/**
 * Write a description of class GameScreen here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class GameOverScreen extends Screen  
{
    private Button gameoverButton;
    private Color gameoverButtonColor;
    
    /**
     * Constructor for objects of class GameScreen
     * 
     */
    public GameOverScreen(MyWorld world)
    {
        super(world, new GreenfootImage("space.jpg"));
        
        gameoverButtonColor = new Color(207, 136, 23);
        gameoverButton = new Button(world);
        gameoverButton.create("GameOver", world.WIDTH/4, world.HEIGHT/8,gameoverButtonColor);
        gameoverButton.setNextScreen(MyWorld.SCREENS.LEADERBOARD);
    }

    
    public void active()
    {
        super.active();
        world.stopped();
        world.addObject(gameoverButton, world.WIDTH/2, world.HEIGHT*3/4);
        act();
    }

    public void act()
    {
         if(Greenfoot.mouseClicked(gameoverButton)){
            gameoverButton.onClick();
            Greenfoot.start();
          }
    }
}
