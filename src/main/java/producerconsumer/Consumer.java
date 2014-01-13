package producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author nikom
 */
public class Consumer extends Thread {

    private final BlockingQueue blockingQueue;

    public Consumer(BlockingQueue sharedQueue) {
        blockingQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed : " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
