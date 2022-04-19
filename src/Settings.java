/**
 * Write a description of class Settings here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class Settings  
{
    private int x;
    private MODE mode;
    
    private static Settings theSettings = null;
    
    public enum MODE {
    
        ONE_PLAYER,
        TWO_PLAYER
    }
    /**
     * Constructor for objects of class Settings
     */
    public Settings()
    {
        this.mode = MODE.ONE_PLAYER;
    }
    
    public synchronized static Settings getInstance() {
        if(theSettings == null) {
            theSettings = new Settings();
            return theSettings;
        }
        return theSettings;
    }

    public MODE getPlayMode() {
        return mode;
    }
    
    public void setPlayMode(MODE mode) {
        this.mode = mode;
    }
    
}