package Task2;

class MyThread extends Thread {
    private String name;
    private int count;

    public MyThread(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(name);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new MyThread("Thread 1", 5);
        Thread thread2 = new MyThread("Thread 2", 3);

        thread1.start();
        thread2.start();
    }
}