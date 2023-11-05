package Task8;

public final class ColourPyramid extends Pyramid {
  private String colour;

  ColourPyramid(double height, double area, String colour) {
    super(height, area);
    this.colour = colour;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  @Override
  public void print() {
    super.print();
    System.out.println("ColourPyramid colour is " + getColour());
  }
}
