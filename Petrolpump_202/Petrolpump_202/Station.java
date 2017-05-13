import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;


public class Station extends GasPump implements DispInterface
{
    private World world;
	private List<DispInterface> components = new ArrayList<>();
	
	public Station(World world) {
		this.world = world;
	}
	/**
     * Act - do whatever the GasStation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    /*	MouseInfo mouse = Greenfoot.getMouseInfo();
   	 if (Greenfoot.mouseClicked(null))
        {
        	System.out.println("x "+mouse.getX()+" y: "+mouse.getY());
        }*/
    }
    

	@Override
	public void viewRender() {
		// TODO Auto-generated method stub
		world.addObject((Actor) this, 450, 250);
		for (DispInterface component : components) {
			component.viewRender();
		}
	}

	@Override
	public void addToView(DispInterface c) {
		// TODO Auto-generated method stub
		components.add( c );
	}    
}
