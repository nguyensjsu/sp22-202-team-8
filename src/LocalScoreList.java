import java.util.*;

/**
 * A class to keep track of the local score, includes every attempt.
 * 
 * @author Team 8 
 * @version 1.0
 */
public class LocalScoreList  
{
    private ArrayList<Integer> scores;
    private MyWorld world;

    /**
     * Constructor for objects of class LocalScoreList
     */
    public LocalScoreList()
    {
        this.world = world;
        scores = new ArrayList<Integer>();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addScore(int y)
    {
        scores.add(y);
        return;
    }
    
    public int getScore(int i)
    {
        return scores.get(i);
    }
    
    public int getSize()
    {
        return scores.size();
    }
}
