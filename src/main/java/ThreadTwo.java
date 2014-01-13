/**
 * @author nikom
 */
public class ThreadTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadTwo [" + Thread.currentThread().getId() + "] running.");
    }
}
