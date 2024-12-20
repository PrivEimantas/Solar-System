import java.util.ArrayList;

public class SolarBody{


    //Variables needed for orbit and movement
    protected double DistanceFromOrbitPoint; //distance from orbit
    protected double angle; //angle for rotation
    protected double diameter; //size of solar body
    protected String col; // colour
    

    /**
     * 
     * @param system system screen to draw onto
     * @param DistanceFromOrbitPoint How far away from centre of orbit
     * @param angle angle to be moving at
     * @param diameter size of planet
     * @param col colour
     * 
     * 
     * Constructor assigns data for the planet(solarBody) to hold so can be used for movement
     */
    public SolarBody(
        SolarSystem system,
        double DistanceFromOrbitPoint, 
        double angle, 
        double diameter,
        String col )
    
    {
        this.DistanceFromOrbitPoint = DistanceFromOrbitPoint;
        this.angle = angle;
        this.diameter = diameter;
        this.col = col;

        system.drawSolarObject(DistanceFromOrbitPoint, angle, diameter, col);

    }

    /**
     * 
     * @param system system screen to draw onto
     * @param newOrbit new angle
     * 
     * Draws planet using drawSolarObject from SolarSystem
     * 
     */
    public void drawPlanet(SolarSystem system,int newOrbit){
                
        system.drawSolarObject(DistanceFromOrbitPoint, newOrbit+this.angle, diameter, col);

    }
    
    /*
     * Method to be reused by sattelite
     */
    public void drawSattelite(SolarSystem system,int newOrbit){
        //To be overwritten
    }


    



    
}