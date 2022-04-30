import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
public class Button extends Glyph 
{
    private MyWorld.SCREENS nextScreen;
    
    public Button(MyWorld world) {
        super(world);
    }
    
    public void create(String text,int fontSize, Color textColor, int width, int height, Color backgroundColor) {
    
        img = new GreenfootImage(width, height);
        img.setColor(backgroundColor);
        img.fill();
        
        img.setFont(new Font("Merlin", fontSize));
        img.setColor(textColor);
        img.drawString(text, width / 2 - text.length() * 8, height / 2 + 10);
        setImage(img);
    }
    
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
