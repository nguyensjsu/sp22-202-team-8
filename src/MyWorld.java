import greenfoot.*;  

/**
 * Write a description of class MyWorld here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class MyWorld extends World implements IStopObserver
{
    Counter counter;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    private Screen currentScreen;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private Leveltext leveltext;
    private Heart1 heart1;
    private Heart2 heart2;
    private Heart3 heart3;
    private GameOverScreen gameOverScreen;
    private LeaderboardScreen leaderboardScreen;
    private HorizontalScrolling horizontalScrolling;
    private Buff buff;
    private Shot shot;
    
    private MenuScreenGlyphFactory menuScreenGlyphFactory;
    private LeaderboardScreenGlyphFactory lbSGlyphFactory;
    private GameOverScreenGlyphFactory gOSGlyphFactory;
    
    private Settings settings;
    //private boolean is2p = false;
    private LevelStateMachine sm;
    
    private static MyWorld me;
     /* Screens' names
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
        // Create GlyphFactory for screens
        menuScreenGlyphFactory = new MenuScreenGlyphFactory(this);
        lbSGlyphFactory = new LeaderboardScreenGlyphFactory(this);
        gOSGlyphFactory = new GameOverScreenGlyphFactory(this);
        // Create screens in MyWorld
        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        gameOverScreen = new GameOverScreen(this);
        leaderboardScreen = new LeaderboardScreen(this);
        
        settings = new Settings();
        
        horizontalScrolling = new HorizontalScrolling();
        buff = new Buff();
        sm = new LevelStateMachine(this);
        counter = new Counter();
        leveltext = new Leveltext();
        heart1 = new Heart1();
        heart2 = new Heart2();
        heart3 = new Heart3();
        counter.registerScoreObserver(sm);
        
        setNextScreen(SCREENS.MENU);
        Greenfoot.start();
    }
    
    public Counter getCounter(){
        return counter;
    }
    
    public Heart1 getHeart(){
        return heart1;
    }
    
    public Heart2 getHeart2(){
        return heart2;
    }
    
    public Heart3 getHeart3(){
        return heart3;
    }
    
        /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    protected void prepare()
    {        
        Rocket rocket = new Rocket();
        shot = new Shot(rocket);
        Rocket2P rocket2 = new Rocket2P();
        rocket.registerStopObserver(this);
        rocket.registerStopObserver(horizontalScrolling);
        rocket.registerStopObserver(buff);
        rocket.registerStopObserver(shot);
        addObject(rocket,50,200);
        
        settings = Settings.getInstance();
        if (settings.getPlayMode() == Settings.MODE.TWO_PLAYER) {
            rocket2.registerObserver(this);
            rocket2.registerObserver(horizontalScrolling);
            rocket2.registerStopObserver(buff);
            addObject(rocket2,50,100);
        }

        sm.setLevel1();
        
        addObject(leveltext,402,28);
        addObject(heart1,28,25);
        addObject(heart2,68,25);
        addObject(heart3,108,25);
        addObject(counter,731,31);
    }
    
    protected void addRocks(int number)
    {
        for(int i = 0; i<number; i++)
            addObject(new Rock(), getWidth()-Greenfoot.getRandomNumber(200), Greenfoot.getRandomNumber( getHeight() ) );
    }
    
    /**
     * A method to set nextScreen and activate the Screen
     * 
     */
    public void setNextScreen(SCREENS screen)
    {
        if(currentScreen !=null)
            currentScreen.clean();
            
        switch(screen) {
            case MENU: currentScreen = menuScreen; break;
            case GAME: {
                GameScreen.initialize();
                counter.setValue(0);
                heart1.getLifeAmount(1);
                heart2.getLifeAmount(1);
                heart3.getLifeAmount(1);
                currentScreen = gameScreen; 
                break;
            }
            case LEADERBOARD: currentScreen = leaderboardScreen; break;
            default: currentScreen = menuScreen;
        }
        currentScreen.active();
        
    }
    
    public void setGameScreen() {
        currentScreen = gameScreen;
        currentScreen.active();
    }
    
    public void stop() {
        currentScreen = gameOverScreen;
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

