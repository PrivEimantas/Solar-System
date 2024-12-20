import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Main class which adds the planets and sattelites onto the screen
 * 
 */
public class CelestialBody extends JFrame implements ChangeListener,ActionListener{

    /*
     * system is the window for the planets to be held in
     * planets array list to hold all the planets
     * sattelites to hold all the sattelites
     */
    private SolarSystem system;
    private ArrayList<SolarBody> planets = new ArrayList<SolarBody>();
    private ArrayList<Sattelites> sattelites = new ArrayList<Sattelites>();

    /*
     * frozen checks if current system has been frozen in place by the button
     * frame,slider,panel,text,freeze all java swing to create the section for holding
     * the slider and button
     * Speed controls the rotation of the sattelites and planets
     */
    boolean frozen=false;
    JFrame frame; 
    JSlider slider; 
    JPanel panel; 
    JLabel text; 
    int speed=0;
    JButton freeze;

    
    /**
     * Constructor to draw in planets and rings
     */
    public CelestialBody(){ 
        
        //Draw in the Sun intially in centre of screen
        this.system = new SolarSystem(1200,900);
        this.system.drawSolarObject(0, 0, 60,"YELLOW");

        //rename classes to start with uppercase

        /* Adding all planets of solar system
         * Arguments order: system,
            DistanceFromOrbitPoint, 
            angle, 
            diameter,
            colour
         */

         //MERCURY
         this.planets.add(new SolarBody(system, 70, 0, 5, "DARK_GRAY"));

         //VENUS
         this.planets.add(new SolarBody(system, 90, 20, 10, "GRAY"));
 
         //EARTH
         this.planets.add(new SolarBody(system, 110, 40, 10, "BLUE"));
 
         //MARS
         this.planets.add(new SolarBody(system, 150, 100, 10, "RED"));
 
         //JUPITER
         this.planets.add(new SolarBody(system, 200, 250, 30, "ORANGE"));
 
 
         //Jupiter Galilean Moons
         this.sattelites.add(new Sattelites(system,20,240,2,"RED",200,250));
         this.sattelites.add(new Sattelites(system,15,240,2,"ORANGE",210,250));
 
 
         //ASTEROID BELT
         //Added in small gap to demonstrate the rings are moving and not stationary
         for(int i=0;i<355;i++){
             this.planets.add(new SolarBody(system,230,90+i+10,2,"LIGHT_GREY"));
         }
 
         //SATURN's RINGS
         for(int i=0;i<330;i=i+20){
             this.sattelites.add(new Sattelites(system,30,180+i,3,"LIGHT_GREY",250,140)); 
         }
         
         //SATURN
         this.planets.add(new SolarBody(system, 250, 140, 20, "LIGHT_GREY"));
 
         //URANUS
         this.planets.add(new SolarBody(system, 290, 300, 15, "CYAN"));
 
         //NEPTUNE
         this.planets.add(new SolarBody(system, 330, 350, 15, "GREEN"));

        /*
         * Creates the section to control the rotation of the system
         */
        frame = new JFrame("Solar System");
        slider = new JSlider(0,360,120);
        panel = new JPanel();
        text = new JLabel();
        text.setText("Scroll to rotate the system");
        freeze = new JButton("Freeze system");
        freeze.addActionListener(this);

        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(50);

        slider.addChangeListener(this);
        slider.setOrientation(SwingConstants.VERTICAL);

        panel.add(slider);
        panel.add(text);
        panel.add(freeze);

        frame.add(panel);
        frame.setSize(200,300);
        frame.setVisible(true);

    }

    /**
     * Redraws onto screen and causes movement on the screen by incrementing the angle
     */
    public void simulateOrbitalPath(){
        this.system.finishedDrawing(); //clear screen to remove entities initially

        
        while(true){
            this.system.drawSolarObject(0, 0, 60,"YELLOW");
            
            for(int planetCount=0;planetCount<this.planets.size();planetCount++){
                planets.get(planetCount).drawPlanet(system, this.speed); 
            } //Draw on planets and increment angle to make them move

            for(int satCount=0;satCount<this.sattelites.size();satCount++){
                sattelites.get(satCount).drawSattelite(system, this.speed);
            } //Draw on sattelites and make them move
            
            
            
            if(this.speed==360){
                this.speed=0; //Reset angle as 360 max
            }
            else if(this.frozen){ //Button been called to stop system, so do not update speed
                this.system.finishedDrawing();
            }
            else //Otherwise system not frozen
            {
                this.speed+=1;
                this.system.finishedDrawing();
            }
        }
    }

    

    //Listen to slider
    public void stateChanged(ChangeEvent e){
        
        this.speed=this.slider.getValue();

    }

    //Change boolean of frozen system
    public void actionPerformed(ActionEvent e){
        
        if(this.frozen){
            this.frozen=false;
        }
        else{
            this.frozen=true;
        }
    }




    

   


    
}