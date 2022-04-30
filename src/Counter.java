import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Counter extends Actor implements IScoreSubject
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    private int target;
    private String prefix;
    
    private IScoreObserver score_o;
    private int levelTracker;
    private int cdTracker;
    private int suTracker;
    
    public Counter()
    {
        this(new String());
        levelTracker = 50;
        cdTracker = 250;
        suTracker = 100;
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix)
    {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        this.prefix = prefix;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }

    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();

        // reset level when game is reset
        if (newValue == 0) {
            levelTracker = 50;
            suTracker = 100;
            cdTracker = 250;
        }
        
        // after gaining every 50 points notify observer
        if (value >= levelTracker) {
            notifyScoreObserver();
            levelTracker += 50;
        }
        
        // after gaining every 100 points release a speed up buff
        if (value >= suTracker) {
            addSpeedUp();
            suTracker += 100;
        }
        
        // after gaining every 250 points release a faster shot buff
        if (value >= cdTracker) {
            addFasterShot();
            cdTracker += 250;
        }
    }
    
    private void addSpeedUp() {
        if (!getImage().toString().contains("speedup.png")) {
            SpeedUp su = SpeedUp.getInstance();
            int x = getWorld().getWidth() - Greenfoot.getRandomNumber(200) - 50;
            int y = Greenfoot.getRandomNumber(getWorld().getHeight() / 2);
            getWorld().addObject(su,x, y);
        }
    }
    
    private void addFasterShot() {
        FasterShot fs = FasterShot.getInstance();
        int x = getWorld().getWidth() - Greenfoot.getRandomNumber(200) - 200;
        int y = Greenfoot.getRandomNumber(getWorld().getHeight() / 2);
        getWorld().addObject(fs,x, y);
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage("Counter.png");
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    public void registerScoreObserver(IScoreObserver o) {
        this.score_o = o;
    }
    
    public void notifyScoreObserver() {
        score_o.setNextLevel();
    }
}
