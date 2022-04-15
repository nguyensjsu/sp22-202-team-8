import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IStopSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IStopSubject
{
    void registerObserver(IStopObserver o);
    void notifyGameOverObserver();
}
