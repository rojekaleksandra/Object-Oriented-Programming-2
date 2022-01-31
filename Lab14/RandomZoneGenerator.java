import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class RandomZoneGenerator {
    private long l;
    public RandomZoneGenerator(long l){
        this.l=l;
    }

    public ZoneId generate(){
        List<ZoneId> list = ZoneId.getAvailableZoneIds().stream().map(z -> ZoneId.of(z)).collect(Collectors.toList());
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }
}
