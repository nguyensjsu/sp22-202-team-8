import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Leaderboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaderboard extends Glyph
{
    private Counter counter;
    /**
     * Constructor for objects of class Leaderboard
     */
    public Leaderboard(MyWorld world) {
        super(world);
        counter = world.getCounter();
    }
    
    public void create(String text, int width, int height, Color textColor) {
        img = new GreenfootImage(width, height);
        img.setFont(new Font(40));
        img.setColor(textColor);
        /**
        for (int i = 0; i < world.getScores().size(); i++) {
            img.drawString(String.valueOf(world.getScores().get(i)), width / 2 - text.length()*9, height / 2 + 10);
        }
        */
        setImage(img);
    }
}
