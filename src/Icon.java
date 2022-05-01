import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Icon extends Glyph
{
    public Icon(MyWorld world) {
        super(world);
    }
    
    @Override
    public void create(Boolean hasInputImg, String str, int fontSize, Color textColor, int width, int height, Color bgColor) {
        if(hasInputImg) {
            img = new GreenfootImage(str);
            img.scale(40, 30);
            setImage(img);
        }
    }
}
