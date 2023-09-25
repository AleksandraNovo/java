package src;

public final class Point {
    private final double x;
    private final double y;
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "( " + x + " , " + y + " )";
    }

    public double giveX() {
        return x;
    }
    public double giveY() {
        return y;
    }

    public Point moving(double moveX, double moveY) {
        return new Point(this.x + moveX, this.y + moveY);
    }

    public Point changes(double moveXandY) {
        return new Point(this.x * moveXandY, this.y * moveXandY);
    }

}
