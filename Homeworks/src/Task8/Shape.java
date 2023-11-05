package Task8;

public sealed class Shape permits Ball, Cylinder, Pyramid {
  private double volume;

  Shape(double volume) {
    this.volume = volume;
  }

  protected double getVolume() {
    return volume;
  }

  protected void setVolume(double volume) {
    this.volume = volume;
  }

  protected void print() {
    String className = "";
    switch (this) {
      case Ball b -> className = "Ball";
      case Cylinder c -> className = "Cylinder";
      case ColourPyramid cp -> className = "ColourPyramid";
      case Pyramid p -> className = "Pyramid";
      default -> className = "Shape";
    }
    System.out.println(className + " volume is: " + getVolume());
  }
}
