package Task8;

public non-sealed class Cylinder extends Shape {
  private double height;
  private double radius;

  Cylinder(double height, double radius) {
    super(Math.PI*Math.pow(radius, 2) * height);
    this.height = height;
    this.radius = radius;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  @Override
  public void print() {
    super.print();
    System.out.println("Cylinder height is " + getHeight() + ", radius is " + getRadius());
  }
}
