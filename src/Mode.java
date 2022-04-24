import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mode extends Glyph 
{
    private Settings settings;
    private Settings.MODE mode;
    private static final GreenfootSound clickSound = new GreenfootSound("select-click.wav");
    /**
     * Constructor for objects of class Mode
     */
    public Mode(MyWorld world) {
        super(world);
    }

    public void create(String text, int width, int height, Color textColor) {
    
        img = new GreenfootImage(width, height);
        img.setFont(new Font( true, true , 20));
        img.setColor(textColor);
        img.drawString(text, width / 2 - text.length()*5, height / 2 + 10);
        setImage(img);
    }
    
    public void setMode(Settings.MODE mode ){
        this.mode = mode;
    }
    
    public void onClick() {
        settings = Settings.getInstance();
        settings.setPlayMode(mode);
        clickSound.play();
        img.setTransparency(150);
        setImage(img);
    }
    
    public void unClick() {
        img.setTransparency(255);
        setImage(img);
    }
}
