import java.util.Random;

public class TemperatureSensor implements Sensor{
    private final String name;
    private final int temp;
    private boolean isOn = false;

    public TemperatureSensor(String name){
        this.name =name;
        this.temp=new Random().nextInt(61)-30;
    }

    public boolean isOn(){
        return isOn;
    }

    public void setOn(){
        isOn=true;
    }

    public void setOff(){
        isOn=false;
    }

    public int read() throws IllegalStateException{
        if(this.isOn) return temp;
        throw new IllegalStateException();
    }


    @Override
    public String toString(){
        return name + ", running: " + isOn;
    }
}