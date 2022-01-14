import java.util.Random;

public abstract class Analyzer {

    protected String[] t1;
    protected String[] t2;
    protected String[] t3;

    protected Analyzer(int n, int m) {
        t1 = new String[n];
        t2 = new String[m];
        t3 = new String[m];
        String alp="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();
        // generate t1, t2, t3 arrays content
        for(int i=0;i<n;i++){
            int len = random.nextInt(16)+5;
            t1[i] = "";
            for(int j=0;j<len;j++){
                t1[i] += alp.charAt(random.nextInt(alp.length()));
            }
        }

        for(int i=0;i<m;i++){
            t2[i] = t1[random.nextInt(n)];
        }

        for(int i=0;i<m;i++){
            int len = random.nextInt(16)+5;
            t3[i] = "";
            for(int j=0;j<len;j++){
                t3[i] += alp.charAt(random.nextInt(alp.length()));
            }
        }
    }

    protected abstract void fillCollection();

    protected abstract void searchPresentElementsInCollection();

    protected abstract void searchMissingElementsInCollection();

    protected abstract void deleteAllElementsInCollection();

    public final void analyse(String collectionName) {
        long start = System.nanoTime();
        fillCollection();
        System.out.println("Filling " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        searchPresentElementsInCollection();
        System.out.println("Searching present in " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        searchMissingElementsInCollection();
        System.out.println("Searching missing in " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        deleteAllElementsInCollection();
        System.out.println("Deleting all from " + collectionName + ": " + (System.nanoTime() - start) + " ms");
    }
}
