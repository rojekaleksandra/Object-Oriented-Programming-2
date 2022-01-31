import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZoneConverter {
    public ZonedDateTime convert(ZonedDateTime zdt, ZoneId zi){
        return zdt.withZoneSameInstant(zi);
    }
}
