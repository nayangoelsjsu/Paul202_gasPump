import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScreenSideButtons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenSideButtons extends Station
{
    public ScreenSideButtons(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("sounds/a.wav");
        }
        
    }    
}
