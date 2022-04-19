import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (team 8) 
 * @version (v0.1)
 */
/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Glyph
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Label
     */

    public Label(MyWorld world) {
        super(world);
    }
    
    public void create(String text, int width, int height, Color textColor) {
    
        img = new GreenfootImage(width, height);
        img.setFont(new Font(40));
        img.setColor(textColor);
        img.drawString(text, width / 2 - text.length()*9, height / 2 + 10);
        setImage(img);
    }
    
}
