import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class AverageSensor implements Sensor{
    private final String name;
    private Set<Sensor> sensors = new HashSet<>();

    public AverageSensor(String name){
        this.name=name;
    }

    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }


    public boolean isOn(){
        for(Sensor i : sensors){
            if(!i.isOn()) return false;
        }
        return true;
    }

    public void setOn(){
        for(Sensor i : sensors){
            i.setOn();
        }
    }

    public void setOff(){
        for(Sensor i : sensors){
            i.setOff();
        }
    }

    public int read() throws IllegalStateException{
        int sum =0;
        for(Sensor i : sensors){
            if (!i.isOn()) throw new IllegalStateException();
            sum +=i.read();
        }
        return sum/sensors.size();
    }

    public List<Integer> readings(){
        List<Integer> list = new ArrayList<>();
        for (Sensor i : sensors){
            list.add(i.read());
        }
        return list;
    }

    @Override
    public String toString(){
        String s = name + ": [";
        for(Sensor i :sensors) s += " " + i.toString();
        return s + "]";
    }
}