package Task9;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RestaurantOrderManagementSystem {

    private final ConcurrentLinkedQueue<Order> orders = new ConcurrentLinkedQueue<>();
    private final ExecutorService cooks = Executors.newFixedThreadPool(4);
    private final ExecutorService waiters = Executors.newFixedThreadPool(2);
    private final Lock orderLock = new ReentrantLock();
    private final Condition orderReadyCondition = orderLock.newCondition();

    public void addOrder(Order order) {
        orderLock.lock();
        try {
            orders.add(order);
            orderReadyCondition.signalAll();
        } finally {
            orderLock.unlock();
        }
    }

    public void startProcessingOrders() {
        for (int i = 0; i < 2; i++) {
            cooks.submit(new Cook());
        }

        for (int i = 0; i < 2; i++) {
            waiters.submit(new Waiter());
        }
    }

    private class Cook implements Runnable {
        public int getMaximumPoolSize() {
            return 10;
        }
        @Override
        public void run() {
            while (true) {
                Order order = null;

                orderLock.lock();
                try {
                    while (orders.isEmpty()) {
                        orderReadyCondition.await();
                    }

                    order = orders.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    orderLock.unlock();
                }

                if (order != null) {
                    System.out.println("Cook is preparing order: " + order.getId());


                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Cook has finished preparing order: " + order.getId());
                }
            }
        }
    }

    private class Waiter implements Runnable {

        @Override
        public void run() {
            while (true) {
                Order order = null;

                orderLock.lock();
                try {
                    while (orders.isEmpty()) {
                        orderReadyCondition.await();
                    }

                    order = orders.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    orderLock.unlock();
                }

                if (order != null) {
                    System.out.println("Waiter is delivering order: " + order.getId());


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Waiter has delivered order: " + order.getId());
                }
            }
        }
    }

    public static void main(String[] args) {
        RestaurantOrderManagementSystem system = new RestaurantOrderManagementSystem();


        system.addOrder(new Order(1, Arrays.asList("Pizza", "Pasta")));
        system.addOrder(new Order(2, Arrays.asList("Burger", "Fries")));
        system.addOrder(new Order(3, Arrays.asList("Salad", "Soup")));


        system.startProcessingOrders();
    }
}

class Order {

    private final int id;
    private final List<String> items;

    public Order(int id, List<String> items) {
        this.id = id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public List<String> getItems() {
        return items;
    }
}
