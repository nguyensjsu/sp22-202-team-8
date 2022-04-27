import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart1 extends Actor
{
    private int lifeamount = 1;
    /**
     * Act - do whatever the Heart1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        updateImage();
    }
    
    private void updateImage()
    {
        if(lifeamount != 0){
            GreenfootImage image = new GreenfootImage("heart.png");
            setImage(image);
        }
        else{
            GreenfootImage image = new GreenfootImage("space2.png");
            setImage(image);
        }
    }
    
    public void getLifeAmount(int life)
    {
        lifeamount=life;
    }
}
