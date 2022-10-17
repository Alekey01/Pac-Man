import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost2 extends Ghost
{
    
    public int speed = 2;
    public String direction = "right";
    
    public void act()
    {
        setLocation(getX() + speed, getY());
        atWall();
    }
    
    public void atWall(){
        Actor wall = getOneIntersectingObject(Wall.class);
        if(wall != null){
            speed = -speed;
            changeDirection();
        }
    }
    
    public void changeDirection(){
        if(direction.equals("right")){
            direction = "left";
        }
    }
}
