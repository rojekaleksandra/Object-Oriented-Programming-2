import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SensorManager {

    private final Map<String, Sensor> sensorMap;

    public SensorManager() {
        sensorMap = new HashMap<>();
    }

    public void printSensors() {
        sensorMap.values().forEach(System.out::println);
    }

    public void addTemperatureSensor(String name) throws SensorPresentException{
        if (sensorMap.containsKey(name)) throw new SensorPresentException();
        sensorMap.put(name, new TemperatureSensor(name));
    }
    public void addAverageSensor(String name) throws SensorPresentException{
        if (sensorMap.containsKey(name)) throw new SensorPresentException();
        sensorMap.put(name, new AverageSensor(name));
    }
    public void addTemperatureSensorToAverageSensor(String average, String temperature) throws SensorNotFoundException{
        if(!sensorMap.containsKey(average) || !sensorMap.containsKey(temperature)) throw new SensorNotFoundException();
        ((AverageSensor)sensorMap.get(average)).addSensor(sensorMap.get(temperature));
    }
    public void turnOff(String name) throws SensorNotFoundException{
        if(!sensorMap.containsKey(name)) throw new SensorNotFoundException();
        sensorMap.get(name).setOff();
        
    }
    public void turnOn(String name) throws SensorNotFoundException{
        if(!sensorMap.containsKey(name)) throw new SensorNotFoundException();
        sensorMap.get(name).setOn();
    }
    
    public int getSensorReadings(String name) throws SensorNotFoundException{
        if(!sensorMap.containsKey(name)) throw new SensorNotFoundException();
        return sensorMap.get(name).read();
    }
    public List<Integer> getAverageSensorReadingList(String name) throws SensorNotFoundException{
        if(!sensorMap.containsKey(name)) throw new SensorNotFoundException();
        return ((AverageSensor)sensorMap.get(name)).readings();
    }
}
