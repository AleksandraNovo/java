package Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pier extends Thread {

    private final Cargo type;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public Pier(Cargo type) {
        this.type = type;
    }

    public void unload(Ship ship) throws InterruptedException {
        System.out.println("Starting to unload " + ship.getName() + " type " + ship.getCargo());
        switch (ship.getCargoCapacity()) {
            case 10 -> TimeUnit.SECONDS.sleep(1);
            case 50 -> TimeUnit.SECONDS.sleep(5);
            case 100 -> TimeUnit.SECONDS.sleep(10);
            default -> {
                assert false;
            }
        }
        lock.lock();
        try {
            Main.tunnel.removeShip(ship);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
        System.out.println(ship.getName() + " unload");
    }

    @Override
    public void run() {
        List<Ship> unloadShipList = new ArrayList<>();
        while (flagUnload) {
            lock.lock();
            try {
                while (tunnel.getTunnel().isEmpty()) {
                    condition.await();
                }
                for (Ship ship : tunnel.getTunnel()) {
                    if (ship.getCargo() == type) {
                        unloadShipList.add(ship);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            for (Ship ship : unloadShipList) {
                try {
                    unload(ship);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            unloadShipList.clear();
        }
    }
}