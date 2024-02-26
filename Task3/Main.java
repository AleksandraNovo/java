package Task3;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arr) {
                    for (int i = 0; i < 10; i++) {
                        arr[i] = i + 1;
                        System.out.println("Added element: " + arr[i]);
                    }
                    arr.notify();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arr) {
                    try {
                        arr.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Array elements:");
                    for (int i = 0; i < 10; i++) {
                        System.out.print(arr[i] + " ");
                    }
                }
            }
        });

        t2.start();
        t1.start();
    }
}
