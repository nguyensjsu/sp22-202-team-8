/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 implements ILevelState 
{
    // instance variables - replace the example below with your own
    private ILevelStateMachine sm;

    /**
     * Constructor for objects of class Level2
     */
    public Level3(ILevelStateMachine machine)
    {
        sm = machine; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void nextLevel() {
        sm.setLevel3();
    };
}
