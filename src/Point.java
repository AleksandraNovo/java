package src;

public final class Point {
    private final double x;
    private final double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    // Методы доступа к координатам
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    // Перемещает точку на заданные координаты и возвращает новый объект Point
    public Point translate(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    // Изменяет масштаб по обеим координатам и возвращает новый объект Point
    public Point scale(double factor) {
        return new Point(this.x * factor, this.y * factor);
    }
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }


}
