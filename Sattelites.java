/*
 * Class to hold data on sattelites
 */
public class Sattelites extends SolarBody{

    //Two extra variables needed to hava sattelites orbit the planets
    private double centreOfRotationDistance;
    private double centreOfRotationAngle;
    
    
    /**
     * 
     * @param system system screen to draw onto
     * @param DistanceFromOrbitPoint centre of orbit point
     * @param angle angle for sattelite to move
     * @param diameter size of sattelite
     * @param col colour
     * @param centreOfRotationDistance polar coordinates for centre of rotational distance
     * @param centreOfRotationAngle polar coordinates for centre of rotation angle
     * 
     * 
     * Constructor holds assigns data for this sattelite
     */
    public Sattelites(
        SolarSystem system,
        double DistanceFromOrbitPoint, 
        double angle, 
        double diameter,
        String col, 
        double centreOfRotationDistance,
        double centreOfRotationAngle)
    {
        super(system,DistanceFromOrbitPoint, angle, diameter,col); //pass to parent class
        this.DistanceFromOrbitPoint = DistanceFromOrbitPoint;
        this.angle = angle;
        this.diameter = diameter;
        this.col = col;
        this.centreOfRotationDistance = centreOfRotationDistance;
        this.centreOfRotationAngle = centreOfRotationAngle;
        
    }

    /**
     * 
     * @param system system to draw onto screen
     * @param newOrbit new angle
     * 
     * Method which will draw using drawSolarObjectAbout to make the given sattelite
     * orbit around a planet(solarBody)
     */
    public void drawSattelite(SolarSystem system, int newOrbit){

        system.drawSolarObjectAbout(DistanceFromOrbitPoint, angle+newOrbit*10, diameter, col, centreOfRotationDistance, centreOfRotationAngle+newOrbit);
    } //overwrite

}