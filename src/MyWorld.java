import greenfoot.*;  

/**
 * Write a description of class MyWorld here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class MyWorld extends World
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    private Screen currentScreen;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private LeaderboardScreen leaderboardScreen;
    
    /**
     * Screens' names
     * 
     */
    public enum SCREENS 
    {
        MENU,
        GAME,
        LEADERBOARD
    } 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with WIDTHxHEIGHT cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        // Create screens in MyWorld
        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        leaderboardScreen = new LeaderboardScreen(this);
        
        this.currentScreen = menuScreen;
        act();
    }
    
    /**
     * A method to set nextScreen and activate the Screen
     * 
     */
    public void setNextScreen(SCREENS screen)
    {
        currentScreen.clean();
        switch(screen) {
            case MENU: currentScreen = menuScreen; break;
            case GAME: currentScreen = gameScreen; break;
            case LEADERBOARD: currentScreen = leaderboardScreen; break;
            default: currentScreen = menuScreen;
        }
        currentScreen.active();
        
    }
    /**
     * A "Act" method in the world activate the currentScreen
     * 
     */    
    public void act()
    {
        if(currentScreen != null) {
            currentScreen.active();
        }
    }
}

