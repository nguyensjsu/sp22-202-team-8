import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import java.util.HashMap;

/**
 * Write a description of class musicController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicController  
{
    private HashMap<MusicState, GreenfootSound> musicMap;
    private static final GreenfootSound startMusic = new GreenfootSound("introMusic.mp3");
    private static final GreenfootSound level1GameMusic = new GreenfootSound("gameMusic.mp3");
    private static final GreenfootSound level2GameMusic = new GreenfootSound("gameMusic.mp3");
    private static final GreenfootSound level3GameMusic = new GreenfootSound("gameMusic.mp3");
    
    private static MusicController theMusicController = null;
    
    private MusicState currentMusicState = MusicState.NO_MUSIC;
    private MusicState prevMusicState = MusicState.NO_MUSIC;

    enum MusicState {
        START,
        LEVEL1,
        LEVEL2,
        LEVEL3,
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
            theMusicController = new MusicController();
            theMusicController.startUp();
            return theMusicController;
        }
        return theMusicController;
    }

    public void startUp() {
        musicMap = new HashMap<>();
        musicMap.put(MusicState.START,startMusic);
        musicMap.put(MusicState.LEVEL1,level1GameMusic);
        musicMap.put(MusicState.LEVEL2,level2GameMusic);
        musicMap.put(MusicState.LEVEL3,level3GameMusic);
        currentMusicState = MusicState.START;
    }
    public void play()
    {
        if(prevMusicState != MusicState.NO_MUSIC){
            if(musicMap.get(prevMusicState).isPlaying()){
                musicMap.get(prevMusicState).stop();
            }
        }
        
        if(currentMusicState != MusicState.NO_MUSIC) {
            if(!musicMap.get(currentMusicState).isPlaying()){
                musicMap.get(currentMusicState).playLoop();
            }
        }
    }
    
    public void stop()
    {
        if(currentMusicState != MusicState.NO_MUSIC) {
            if(musicMap.get(currentMusicState).isPlaying()){
                musicMap.get(currentMusicState).stop();
            }
        }
        prevMusicState = currentMusicState;
        currentMusicState = MusicState.NO_MUSIC;
    }
    
    public void setMusicState(MusicState state){
        prevMusicState = currentMusicState;
        currentMusicState = state;
    }
}
