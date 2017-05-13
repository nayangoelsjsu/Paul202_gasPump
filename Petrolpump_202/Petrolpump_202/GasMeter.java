import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.*;
/**
 * Write a description of class GasMeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GasMeter extends Actor
{
    double gallons = 0;
     double cost = 0;

     long lastCurrentSecond;
     long timeSaved = 0;

     int fuellingDone = 0;
     boolean fuellingStart = false;
     boolean tankFull = false;
     
    GreenfootImage gi;
    String gallonsDone = "gallons";
    
    
    public GasMeter() {
        gi = new GreenfootImage(120,60);
    }


    public void setText(String msg)
    {
        gi.clear();
        gi.setColor(greenfoot.Color.YELLOW);
        gi.fill();

        GreenfootImage inner= new GreenfootImage(msg, 19, Color.BLACK, new Color(0, 0, 0, 96));
         int wide = gi.getWidth();
         int high = gi.getHeight();
         int leftX = (wide - inner.getWidth())/2;
         int topY = (high - inner.getHeight())/2;
         
       gi.setColor(greenfoot.Color.YELLOW);
       gi.setFont(gi.getFont().deriveFont(10f));
       gi.drawImage(inner, leftX, topY);
       setImage(gi);

        
        
    }

    public void act() {
        
        setText(this.gallonsDone);

    }
    
    
    public void drawGas(){
        setImage(gi);
        if (!tankFull) {
            if (gallons>18.00) {
                tankFull = true;
                stopPump();
                this.gallonsDone = "Tank Full \n Put Back Nozzle in Holder";
            }
            else if ((System.currentTimeMillis() - lastCurrentSecond >= 100)) {
                lastCurrentSecond += 100;
        gallons = gallons + 0.01;
        GasNozzle p = getWorld().getObjects(GasNozzle.class).get(0);
        if(p.fuelType == 87) {
            cost = gallons * 2.7;
        } else if(p.fuelType == 89) {
            cost = gallons * 3.2;
        } else if(p.fuelType == 93) {
            cost = gallons * 3.7;
        }
        this.gallonsDone = "gallons:  "+ new DecimalFormat(("00.00")).format(gallons) + "\n" + "cost:   "+ new DecimalFormat(("00.00")).format(cost);
            }
        }
    }

    public void startPump() {

        //System.out.println("dispense started");
        lastCurrentSecond = System.currentTimeMillis() - timeSaved;
        //drawGas = true;
    }
    public void stopPump() {
        timeSaved = System.currentTimeMillis() - lastCurrentSecond;
        fuellingDone = 1;
    }
    public void pumpDone() {
        //gallons = -0.1;
    }
}
