import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Glyph
{
    /**
     * Constructor for objects of class Label
     */

    public Label(MyWorld world) {
        super(world);
    }
    
    public void create(String text, int fontSize, Color textColor, int width, int height, Color bgColor) {
    
        img = new GreenfootImage(width, height);
        img.setFont(new Font(fontSize));
        img.setColor(textColor);
        img.drawString(text, width / 2 - text.length()*10, height / 2 );
        setImage(img);
    }
    
}
