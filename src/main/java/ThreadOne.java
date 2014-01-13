/**
 * @author nikom
 */
public class ThreadOne extends Thread {

    @Override
    public void run() {
        System.out.println("ThreadOne [" + this.getId() + "] running.");
    }
}
