import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
      /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
         GreenfootImage bg = new GreenfootImage(".\\images\\fundo.png");
         bg.scale(getWidth(), getHeight());
         setBackground(bg);
        
        Greenfoot.start();
    }
    public void act()
    {
        
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new MemoryWorld());
    }
}
