import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class Button extends Actor implements IDisplayComponent
{
    private String buttonName;
    private int width, height;
    private int x, y; // location
    private GreenfootImage background;
    private MyWorld.SCREENS nextScreen;
    protected MyWorld world;
    
    public Button(String name,int width, int height, MyWorld world, Color color) {
        this.buttonName = name;
        this.width = width;
        this.height = height;
        this.world = world;
        
        background = new GreenfootImage(width, height);
        background.setColor(color);
        background.fill();
        
        background.setFont(new Font(25)); 
        background.setColor(Color.WHITE);
        background.drawString(buttonName, width / 2 - buttonName.length() * 7, height / 2 + 10);
        setImage(background);
    }
    
    public void addSubComponent( IDisplayComponent c ) {
        // nothing
    };
    
    public void removeSubCompnent( IDisplayComponent c ) {
        // nothing
    };
    
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    };
    
    public void display() {
        world.addObject(this, x, y);
    };
    
    public void setNextScreen(MyWorld.SCREENS nextScreen){
        this.nextScreen = nextScreen;
    }
    
    /**
     * This method is called when button is clicked.
     * To transite to nextScreen.
     */   
    public void onClick() {
        world.setNextScreen(nextScreen);
    }
    
    
}
