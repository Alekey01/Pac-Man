import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Item extends Actor
{
    private int score;
    
    Item(int score){
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
}
