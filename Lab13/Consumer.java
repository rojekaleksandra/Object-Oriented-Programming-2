public class Consumer extends Thread{
    Buffer b;

    Consumer(Buffer b0) { 
        b = b0;  
    }

    public void run() {
        while (true) {
            try{
                System.out.println("Removing element to the buffer, producer: " + Thread.currentThread());
                b.get();
                Thread.sleep((int)(Math.random() * 10000));
            }catch(InterruptedException e){}
        }
    }
}
