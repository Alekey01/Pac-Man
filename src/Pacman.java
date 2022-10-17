import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pacman extends Actor
{
    private static final int OFFSET = 5;
    
    private static final int RIGHT_DIRECTION = 0;
    private static final int LEFT_DIRECTION = 1;
    
    private String[][] images;
    
    private int currentImage = 0;
    private int delayMouth = 0;
    private int offsetX = 0;
    private int offsetY = 0;
    private int score = 0;
    private int lives = 3;
    private int currentDirection = RIGHT_DIRECTION;
    
    private GreenfootImage winGameImage = new GreenfootImage("youwin.png");
    private GreenfootImage gameOver = new GreenfootImage("gameover.png"); 
    
    Pacman(){
        
       images = new String[2][];
       
       images[LEFT_DIRECTION] = new String[]{
           "images/pacmanInverse.png",
           "images/pacman2Inverse.png"
        };
       
       images[RIGHT_DIRECTION] = new String[]{
           "images/pacman.png",
           "images/pacman2.png"
        };
    }
    
    public void act()
    {
        handleKeys();
        moveMouth();
        moveIfNoCollision1(offsetX,offsetY);
        detectGhost();
        showHud();
        eatItem();
        youWin();
        
    }
    
    private void handleKeys(){        
        
        if(Greenfoot.isKeyDown("Right")){
            offsetY = 0;
            offsetX = OFFSET;
            currentDirection= RIGHT_DIRECTION;
            setRotation(360);
            
        }
        else if(Greenfoot.isKeyDown("Left")){
            offsetY = 0;
            offsetX = -OFFSET;
            currentDirection= LEFT_DIRECTION;
            setRotation(360);
        }
        else if(Greenfoot.isKeyDown("Up")){
            offsetX = 0;
            offsetY = -OFFSET;
            setRotation(-90);
            if(currentDirection == LEFT_DIRECTION){
                setRotation(90);
            }
        }
        else if(Greenfoot.isKeyDown("Down")){
            offsetX = 0;
            offsetY = OFFSET;
            setRotation(90);
            if(currentDirection == LEFT_DIRECTION){
                setRotation(-90);
            }
        }
    }  
    
    private void moveIfNoCollision1(int x, int y){
        if(this.getOneObjectAtOffset(3*x, 3*y, Wall.class) == null){
            setLocation(getX() + x, getY() + y);
        }
       
    }    
    
    private void moveMouth(){
        delayMouth++;
        if(delayMouth == 10){
            currentImage = (currentImage + 1) % images.length;
            setImage(images[currentDirection][currentImage]);
            delayMouth = 0;
        }
    }
    
    private void showHud(){
        getWorld().showText(String.format("Score : %d", score), 750, 20);
        getWorld().showText(String.format("Lives: %d", lives), 750, 40);
    }
    
    private void eatItem(){
        
        Item item = (Item)getOneIntersectingObject(Item.class);
        
        if(item != null){
            score += item.getScore();
            getWorld().removeObject(item);
        }
    }
    
     public void detectGhost(){
        if(isTouching(Ghost.class)){
            setLocation(30,40);
            removeLife();
        }
    }
    
    public void gameOver(){
        if(lives <= 0){
            setImage(gameOver);
            setLocation(400,250);
            setRotation(360);
            Greenfoot.stop();
        }
    }
    
     public void removeLife()
    {
        lives--;
        gameOver();
        showHud();
    }
    
    public void youWin(){
        
        if(score ==260){
            setImage(winGameImage);
            setLocation(422,353);
            setRotation(360);
            Greenfoot.stop();
        }
    }
}
