import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IScoreSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IScoreSubject
{
    void registerScoreObserver(IScoreObserver o);
    void notifyScoreObserver();
}
