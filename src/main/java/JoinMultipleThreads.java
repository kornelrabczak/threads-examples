/**
 * ensure that thread T2 run after T1 and thread T3 run after T2
 * @author nikom
 */
public class JoinMultipleThreads {

    public static void main(String[] args) {
        Thread one = createThread("threadOne", 2000, null);
        Thread two = createThread("threadTwo", 1000, one);
        Thread three = createThread("threadThree", 500, two);

        one.start();
        two.start();
        three.start();
    }

    private static Thread createThread(final String name, final int millis, final Thread waitFor) {
        return new Thread(){
            public void run(){
                try {
                    if (waitFor != null) {
                        waitFor.join();
                    }
                    System.out.println(name + " is Started");
                    Thread.sleep(millis);
                    System.out.println(name + " is Completed");
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
    }
}
