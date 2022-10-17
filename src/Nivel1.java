import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Nivel1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
           prepare();
    }
    
    public void prepare(){

        Pacman pacman = new Pacman();
        addObject(pacman,82,99);

        Ghost ghost = new Ghost();
        addObject(ghost,282,369);
        Ghost2 ghost2 = new Ghost2();
        addObject(ghost2,504,236);

        buildWalls();
        addItems();
        
    }
    
    private void buildWalls(){
        for(int x = 10; x < 800; x+=28){
            Wall wall = new Wall();
            addObject(wall,x,10);
            wall = new Wall();
            addObject(wall,x,589);
        }

        for(int y = 10; y < 160; y+=28){
            Wall2 wall2 = new Wall2();
            addObject(wall2,10,y);
            wall2 = new Wall2();
            addObject(wall2,790,y);
        }

        for(int y = 450; y < 800; y+=28){
            Wall2 wall2 = new Wall2();
            addObject(wall2,10,y);
            wall2 = new Wall2();
            addObject(wall2,790,y);
        }
        
        Wall wall59 = new Wall();
        addObject(wall59,287,233);
        Wall2 wall248 = new Wall2();
        addObject(wall248,388,332);
        Wall wall60 = new Wall();
        addObject(wall60,488,432);
        
    }
    
    private void addItems(){
        
        addObject(new Cherry(),453,381);
        
        addObject(new Strawberry(),240,279);
        addObject(new Strawberry(),737,538);
        
        for(int x = 0; x < 550; x+=70){
            addObject(new yellowDot(),100 + x, 540);
            addObject(new yellowDot(),200 + x, 100);
        }
    }
    
}
