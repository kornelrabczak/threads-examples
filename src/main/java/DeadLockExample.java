/**
 * @author nikom
 */
public class DeadLockExample {

    public static void main(String[] args) {
        final Object resource1 = new Object();
        final Object resource2 = new Object();

        Thread threadOne = new Thread() {
            @Override
            public void run() {
                System.out.println("threadOne started.");
                synchronized (resource1) {
                    System.out.println("threadOne lock resource1.");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (resource2) {
                        System.out.println("threadOne lock resource2.");
                    }
                }
                System.out.println("threadOne complited.");
            }
        };

        Thread threadTwo = new Thread() {
            @Override
            public void run() {
                System.out.println("threadTwo started.");
                synchronized (resource2) {
                    System.out.println("threadTwo lock resource2.");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (resource1) {
                        System.out.println("threadTwo lock resource1.");
                    }
                }
                System.out.println("threadTwo complited.");
            }
        };

        threadOne.start();
        threadTwo.start();
    }

}
