package producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author nikom
 */
public class Producer extends Thread {

    public static final int MAX_PRODUCTS = 10;
    private final BlockingQueue blockingQueue;

    public Producer(BlockingQueue sharedQueue) {
        blockingQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_PRODUCTS; i++) {
            try {
                System.out.println("Produced : " + i);
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
