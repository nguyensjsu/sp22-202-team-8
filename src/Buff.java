import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buff extends Actor implements IStopObserver
{
    /**
     * Act - do whatever the Buff wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int timer;
    private int duration;
    private int frequency;
    private static boolean isStopped;
    
    public Buff() {
         timer = 0;
         duration = 500;
         frequency = 20;
         GreenfootImage image = getImage();  
         image.scale(40,40);
         setImage(image);
         isStopped = false;
    }
    
    public void act()
    {
        if (!isStopped) {
            timer++;
            if (timer < duration) {
                if (timer % (frequency * 2) == 0) {
                    setImg();
                }
            } else if (timer < 2 * duration) {
                if (timer % frequency == 0) {
                    setImg();
                }
            } else if (timer < 2.5 * duration) {
                if (timer % (frequency / 2) == 0) {
                    setImg();
                }
            } else {
                getWorld().removeObject(this);
            }
        }
    }
    
    protected void setImg() {
        // wait for override
    }

    public void stop() {
        isStopped = true;
    }
}
