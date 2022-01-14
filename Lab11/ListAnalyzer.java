import java.util.List;
import java.util.Iterator;

public class ListAnalyzer extends Analyzer {

    private final List<String> list;

    ListAnalyzer(List<String> l, int n, int m){
      super(n,m);
      this.list = l;
    }

    public void fillCollection(){
        for(int i=0;i<t1.length;i++)
            list.add(t1[i]);
    }

   
    public void searchPresentElementsInCollection(){
        for(int i=0;i<t2.length;i++){
            list.indexOf(t2[i]);
        }
    }

    public void searchMissingElementsInCollection(){
        for(int i=0;i<t3.length;i++){
            list.indexOf(t3[i]);
        }
    }

    public void deleteAllElementsInCollection(){
        list.clear();
    }

    public void indexedForLoop(){
        for(int i=0;i<list.size();i++){
            list.get(i);
        }
    }

    public void forEachLoop(){
        for(String s: list){
        }
    }

    public void iteratorLoop(){
       Iterator<String> it =  list.iterator();
       while( it.hasNext() ) {
           it.next();
       }
    }

    public void analyzeList(String listName) {
    fillCollection();

    long start = System.nanoTime();
    indexedForLoop();
    System.out.println("Indexed for loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");

    start = System.nanoTime();
    forEachLoop();
    System.out.println("For each loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");

    start = System.nanoTime();
    iteratorLoop();
    System.out.println("Iterator loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");
    }
}
