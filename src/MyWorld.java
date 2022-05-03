import greenfoot.*;  
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class MyWorld extends World implements IStopObserver
{
    Counter counter;
    public static final int WIDTH = 1104;
    public static final int HEIGHT = 690;
    
    private Screen currentScreen;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private Leveltext leveltext;
    private List<Heart> player1hp;
    private List<Heart> player2hp;

    private GameOverScreen gameOverScreen;
    private LeaderboardScreen leaderboardScreen;
    private HorizontalScrolling horizontalScrolling;
    private Buff buff;
    private Shot shot;
    
    private MenuScreenGlyphFactory menuScreenGlyphFactory;
    private LeaderboardScreenGlyphFactory lbSGlyphFactory;
    private GameOverScreenGlyphFactory gOSGlyphFactory;
    
    private Settings settings;
    private LevelStateMachine sm;
    private MusicController mc;
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
        // Create singleton Settings and MusicControoller
        settings = new Settings();
        mc = MusicController.getNewInstance();
        // Create screens in MyWorld
        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        gameOverScreen = new GameOverScreen(this);
        leaderboardScreen = new LeaderboardScreen(this);
        
        horizontalScrolling = new HorizontalScrolling();
        buff = new Buff();
        sm = new LevelStateMachine(this);
        counter = new Counter();
        leveltext = new Leveltext();
        player1hp = new ArrayList<>();
        player2hp = new ArrayList<>();
        counter.registerScoreObserver(sm);

        setNextScreen(SCREENS.MENU);
        Greenfoot.start();
    }
    
    public Counter getCounter(){
        return counter;
    }
    
    public List<Heart> getP1HP(){
        return player1hp;
    }
    
    public List<Heart> getP2HP(){
        return player2hp;
    }
    
        /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    protected void prepare()
    {        
        Rocket rocket = new Rocket();
        shot = new Shot(rocket);
        addRocket(rocket);
        addObject(rocket,50,200);
        addHeart(rocket);
        
        settings = Settings.getInstance();
        if (settings.getPlayMode() == Settings.MODE.TWO_PLAYER) {
            Rocket2P rocket2 = new Rocket2P();
            addRocket(rocket2);
            addObject(rocket2,50,100);
            addHeart(rocket2);
            Rocket.setPlayerNum(2);
        }

        sm.setLevel1();
        
        addObject(leveltext,550,28);
        addObject(counter,980, 31);
    }
    
    private void addHeart(Rocket player) {
        List<Heart> list;
        int dis = 0;
        if (player.getClass().getName().contains("2P")) {
            list = player2hp;
            dis = 228; // start at 218
        } else {
            list = player1hp;
            dis = 38; // start at 28
        }
        
        for (int i = 0; i < 3; i++) {
            list.add(new Heart());
            dis += 40;
            addObject(list.get(i), dis, 25);
        }
    }
    
    private void addRocket(Rocket player) {
        player.registerStopObserver(this);
        player.registerStopObserver(horizontalScrolling);
        player.registerStopObserver(buff);
        player.registerStopObserver(shot);
        
        String icon_img;
        int width = 0, height = 25;
        if (player.getClass().getName().contains("2P")) {
            icon_img = "rocket2P.png";
            width = 218;
            player.setHP(player2hp);
        } else {
           icon_img = "rocket.png";
           width = 28;
           player.setHP(player1hp);
        }
        
        Icon rocketIcon = new Icon(this);
        rocketIcon.create(true, icon_img, 25, new Color(0, 0, 0, 0), 0, 0, new Color(0, 0, 0, 0));
        addObject(rocketIcon, width, height);
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
            case MENU: {
                currentScreen = menuScreen; 
                mc.setMusicState(MusicController.MusicState.START);
                mc.play();
                break;
            }
            case GAME: {
                GameScreen.initialize();
                counter.setValue(0);
                mc.setMusicState(MusicController.MusicState.LEVEL1);
                mc.play();
                for (Heart heart : player1hp) {
                    heart.setLifeAmount(1);
                }
                
                for (Heart heart : player2hp) {
                    heart.setLifeAmount(1);
                }
                currentScreen = gameScreen; 
                break;
            }
            case LEADERBOARD: {
                currentScreen = leaderboardScreen; 
                mc.stop();
                break;
            }
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
        MusicController.getInstance().stop();
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

