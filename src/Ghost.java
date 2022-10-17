import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    public int speed = 2;
    public String direction = "down";
    
    public void act()
    {
        setLocation(getX(), getY() +speed);
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
        if(direction.equals("down")){
            direction = "up";
        }
    }
}
