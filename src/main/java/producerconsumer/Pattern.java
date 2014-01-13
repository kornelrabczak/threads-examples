package producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author nikom
 */
public class Pattern {

    public static void main(String[] args) {

        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);

        producer.start();
        consumer.start();
    }
}
