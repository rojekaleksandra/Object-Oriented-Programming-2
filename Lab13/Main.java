public class Main {
    public static void main(String args[]) {
        Buffer b = new Buffer(5);
        new Producer(b).start();
        new Consumer(b).start();
        new Producer(b).start();
        new Consumer(b).start();
    }
}
