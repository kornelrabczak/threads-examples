import org.junit.Test;

/**
 * @author nikom
 */
public class ThreadsExample {

    @Test
    public void shouldRunTwoThreads() {
        new ThreadOne().start();
        new Thread(new ThreadTwo()).start();
    }

    @Test
    public void firstThreadShouldEndAfterSecond() {
        Thread firstThread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " is Started");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is Completed");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        firstThread.start();

    }
}
