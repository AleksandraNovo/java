package Task8;

import java.math.BigInteger;
import java.util.Arrays;
public class Main {
  public static void main(String[] args) {
    Shape shape = new Shape(5);
    Shape ball = new Ball(1);
    Shape cylinder = new Cylinder(2, 3);
    Shape pyramid = new Pyramid(4, 1);
    Shape colourPyramid = new ColourPyramid(7, 0.5, "red");

    shape.print();
    ball.print();
    cylinder.print();
    pyramid.print();
    colourPyramid.print();
  }

}
