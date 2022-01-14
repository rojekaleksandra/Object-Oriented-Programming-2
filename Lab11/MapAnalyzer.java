import java.util.Map;

public class MapAnalyzer extends Analyzer {

    private final Map<String, String> map;

    MapAnalyzer(Map<String, String> map, int n, int m){
      super(n,m);
      this.map = map;
    }

    public void fillCollection(){
        for(int i=0;i<t1.length;i++)
            map.put(t1[i], t1[i]);
    }

   
    public void searchPresentElementsInCollection(){
        for(int i=0;i<t2.length;i++){
            map.get(t2[i]);
        }
    }

    public void searchMissingElementsInCollection(){
        for(int i=0;i<t3.length;i++){
            map.get(t3[i]);
        }
    }

    public void deleteAllElementsInCollection(){
        map.clear();
    }
}