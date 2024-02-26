package Task6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger gold = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> print(gold));
        }
        executor.shutdown();
    }

    public static synchronized void print(AtomicInteger gold) {
        int amount = (int) (Math.random() * 100);
        int currentGold = gold.getAndAdd(amount);
        System.out.println("Added " + amount + " gold. Total gold: " + (currentGold + amount));
    }
}