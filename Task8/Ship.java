package Task8;

public class Ship {

    private final String name;
    private final int cargoCapacity;
    private final Cargo cargo;

    public Ship(String name, int cargoCapacity, Cargo cargo) {
        this.name = name;
        this.cargoCapacity = cargoCapacity;
        this.cargo = cargo;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getName() {
        return name;
    }
}