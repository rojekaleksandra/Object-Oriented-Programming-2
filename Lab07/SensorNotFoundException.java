public class SensorNotFoundException extends Exception{
    public SensorNotFoundException(){
        super("Could not find temperature sensor with given name!");
    }
}