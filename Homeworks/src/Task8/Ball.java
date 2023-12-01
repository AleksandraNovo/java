package Task8;

public non-sealed class Ball extends Shape {
  private double radius;

  Ball(double radius) {
    super(4*Math.PI*Math.pow(radius, 3) / 3);
    this.radius = radius;
  }

  double getRadius() {
    return radius;
  }

  void setRadius(double radius) {
    this.radius = radius;
  }

  @Override
  public void print() {
    super.print();
    System.out.println("Ball radius is " + getRadius());
  }
}
