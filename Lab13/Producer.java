public class Producer extends Thread{
    Buffer b;

    Producer(Buffer b0) { 
        b = b0; 
    }

    public void run() {
        while (true) {
            try{
                System.out.println("Adding element to the buffer, producer: " + Thread.currentThread());
                b.put();
                Thread.sleep((int)(Math.random() * 10000));
            }catch(InterruptedException e){}
        }
    }
}
