package Task8;

public sealed class Pyramid extends Shape permits ColourPyramid {
  private double height;
  private double area; // площадь основания

  Pyramid(double height, double area) {
    super(area*height/3);
    this.height = height;
    this.area = area;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    this.area = area;
  }

  @Override
  public void print() {
    super.print();
    String className = "";
    if (this instanceof ColourPyramid) {
      className = "ColourPyramid";
    } else {
      className = "Pyramid";
    }
    System.out.println(className + " area is " + getArea() + ", height is " + getHeight());
  }
}
