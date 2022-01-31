import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ResultPrinter {
    public void print(ZonedDateTime zdt1, ZonedDateTime zdt2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("%s %s => %s %s\n", zdt1.format(formatter), zdt1.getZone(), zdt2.format(formatter), zdt2.getZone());
    }
}
