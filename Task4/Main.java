package Task4;

public class Main {
    private static final Object lock = new Object();
    private static int number = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddPrinter());
        Thread evenThread = new Thread(new EvenPrinter());

        oddThread.start();
        evenThread.start();
    }

    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (number <= 10) {
                    if (number % 2 != 0) {
                        System.out.println("Odd Thread: " + number);
                        number++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (number <= 10) {
                    if (number % 2 == 0) {
                        System.out.println("Even Thread: " + number);
                        number++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}