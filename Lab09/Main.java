import java.util.Arrays;
import java.lang.reflect.*;
import java.lang.Math;
public class Main{

    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> !w.isEmpty()).toArray(String[]::new);
    }

    public static void main(String[] args) {
        try {
            String[] splitted = splitArgs(args[0]);

            if(splitted.length==3){
                Method m = Math.class.getMethod(splitted[0], double.class, double.class);
                System.out.println("Result: " + m.invoke(double.class, Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])));
            }
            else if(splitted.length==2){
                Method m = Math.class.getMethod(splitted[0], double.class);
                System.out.println("Result: " + m.invoke(double.class, Double.parseDouble(splitted[1])));
            }
            else{
                System.out.println("Wrong number of arguments passed to the function, enter one or two numbers.");
            }
        }
        catch(IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println("Function arguments must be numbers.");
        }
        catch(InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch(ExceptionInInitializerError e){
            System.out.println(e.getMessage());
        }
        catch(NoSuchMethodException e){
            System.out.println("There is no such method.");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No arguments to calculate.");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}