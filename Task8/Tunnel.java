package Task8;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {

    private final List<Ship> ships = new ArrayList<>(5);
    private int capacity = 5;

    public Tunnel(int capacity) {
        this.capacity = capacity;
    }

    public void addShip(Ship ship) {
        if (ships.size() < capacity) {
            ships.add(ship);
        } else {
            throw new IllegalStateException("Tunnel is full. Cannot add more ships.");
        }
    }

    public void removeShip(Ship ship) {
        ships.remove(ship);
    }

    public List<Ship> getTunnel() {
        return ships;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}