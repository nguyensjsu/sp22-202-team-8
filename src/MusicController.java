import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import java.util.HashMap;

/**
 * Write a description of class musicController here.
 * 
 * @author (Jing) 
 * @version (v1.0)
 */
public class MusicController  
{
    private HashMap<MusicState, GreenfootSound> musicMap;
    private final GreenfootSound startMusic = new GreenfootSound("startMusic.wav");
    private final GreenfootSound level1GameMusic = new GreenfootSound("gameMusic.wav");
    //private static final GreenfootSound level2GameMusic = new GreenfootSound("game1.mp3");
    //private static final GreenfootSound level3GameMusic = new GreenfootSound("game1.mp3");
    private final GreenfootSound gameOverMusic = new GreenfootSound("gameOver.wav");
    
    private static MusicController theMusicController = null;
    
    private MusicState currentMusicState = MusicState.NO_MUSIC;

    enum MusicState {
        START,
        LEVEL1,
        LEVEL2,
        LEVEL3,
        GAME_OVER,
        NO_MUSIC
    }
    /**
     * Constructor for objects of class musicController
     */
    public MusicController(){}

    public synchronized static MusicController getNewInstance() {
            theMusicController = new MusicController();
            theMusicController.startUp();
            return theMusicController;
    }
    
    public synchronized static MusicController getInstance() {
        if(theMusicController == null) {
            return getNewInstance();
        }
        return theMusicController;
    }

    public void startUp() {
        musicMap = new HashMap<>();
        musicMap.put(MusicState.START,startMusic);
        musicMap.put(MusicState.LEVEL1,level1GameMusic);
        musicMap.put(MusicState.LEVEL2,level1GameMusic);
        musicMap.put(MusicState.LEVEL3,level1GameMusic);
        musicMap.put(MusicState.GAME_OVER,gameOverMusic);
        currentMusicState = MusicState.START;
        musicMap.get(currentMusicState).stop();
    }
    public void play(MusicState state)
    {
        stop();
        currentMusicState = state;
        if(currentMusicState != MusicState.NO_MUSIC) {
            musicMap.get(currentMusicState).play();
        }
    }
    public void playLoop(MusicState state)
    {
        stop();
        currentMusicState = state;
        if(currentMusicState != MusicState.NO_MUSIC) {
            musicMap.get(currentMusicState).playLoop();
        }
    }
    public void stop()
    {
        if(currentMusicState != MusicState.NO_MUSIC) {
            musicMap.get(currentMusicState).stop();
        }
        currentMusicState = MusicState.NO_MUSIC;
    }
}
