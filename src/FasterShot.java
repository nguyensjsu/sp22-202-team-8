import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FasterShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FasterShot extends Buff
{
    /**
     * Act - do whatever the FasterShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FasterShot() {
        super();
    }
    
    public void act()
    {
        // Add your action code here.
        super.act();
    }
    
    @Override
    protected void setImg() {
        if (this.getImage().toString().contains("fasterShot.png"))
        {   
            // set transparent img
            setImage(new GreenfootImage(10,10));
        } else {
            setImage(new GreenfootImage("fasterShot.png"));
            this.getImage().scale(40,40);
        }
    }
}
