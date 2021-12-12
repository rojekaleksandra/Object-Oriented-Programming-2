public class SensorPresentException extends Exception{
    public SensorPresentException(){
        super("Sensor is already present!");
    }
}