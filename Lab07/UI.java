import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UI {
    private final Scanner scanner;
    private final SensorManager sensorManager;

    public UI(Scanner scanner) {
        this.scanner = scanner;
        sensorManager = new SensorManager();
    }

    public void run() {
        Map<Character, Option> optionMap = Arrays.stream(Option.values())
                .collect(Collectors.toMap(Option::getCharacter, Function.identity()));

        System.out.println("Options:");
        optionMap.values().forEach(System.out::println);

        char typedChar;

        mainLoop: while (true) {
            sensorManager.printSensors();
            System.out.print("> ");
            typedChar = scanner.next().charAt(0);

            Option pickedOption = optionMap.get(typedChar);
            if (pickedOption == null) {
                System.out.println("Option not recognized");
                continue;
            }

            String name;
            switch (pickedOption) {
                case EXIT:
                    break mainLoop;
                case ADD_TEMP_SENSOR:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    try{
                        sensorManager.addTemperatureSensor(name);
                    }
                    catch (SensorPresentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case ADD_AVG_SENSOR:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    try{
                        sensorManager.addAverageSensor(name);
                    }
                    catch (SensorPresentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case ADD_TEMP_TO_AVG:
                    System.out.println("Average sensor name:");
                    System.out.print("> ");
                    String average = scanner.next();
                    System.out.println("Temperature sensor name: ");
                    System.out.print("> ");
                    String temperature = scanner.next();
                    try{
                        sensorManager.addTemperatureSensorToAverageSensor(average, temperature);
                    }
                    catch (SensorNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    catch(ClassCastException e){
                        System.out.println("Wrong average sensor name");
                    }
                    break;
                case TURN_OFF:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    try{
                        sensorManager.turnOff(name);
                    }
                    catch (SensorNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case TURN_ON:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    try{
                        sensorManager.turnOn(name);
                    }
                    catch (SensorNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case PRINT_TEMP:
                    System.out.println("Sensor name:");
                    System.out.print("> ");
                    name = scanner.next();
                    try{
                        System.out.println(sensorManager.getSensorReadings(name));
                    }
                    catch (SensorNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    catch (IllegalStateException e){
                        System.out.println("Sensor is not running");
                    }
                    break;
                case PRINT_TEMP_LIST:
                System.out.println("Sensor name:");
                System.out.print("> ");
                name = scanner.next();
                try{
                    System.out.println(sensorManager.getAverageSensorReadingList(name));
                }
                catch (SensorNotFoundException e){
                    System.out.println(e.getMessage());
                }
                catch (IllegalStateException e){
                    System.out.println("Sensor is not running");
                }
                    break;
            }
            System.out.println();
        }
    }
}
