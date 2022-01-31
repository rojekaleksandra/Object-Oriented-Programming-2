public class Buffer {
    private int max;
    private int current;

    Buffer(int max) {
        this.max = max;
    }

    synchronized public void get() {
        while (current == 0) {
            try {
                System.out.println("Buffer is empty, waiting...");
                wait();
            } catch (InterruptedException e) {}
        }
        current--;
        System.out.println("Element removed from the buffer. Space:" + current + "/" + max);
        notify();
    }

    synchronized public void put() {
        while (current == max) {
            try {
                System.out.println("Buffer is full, waiting...");
                wait();
            } catch (InterruptedException e) {}
        }
        current++;
        System.out.println("Element added to the buffer. Space:" + current + "/" + max);
        notify();
    }

}