package src;

public class Task8 {

  public static void main(String[] args) {
    try {
      String s = null;
      String m = s.toLowerCase();
    } catch (NullPointerException e) {
      System.out.println(" У переменной s нельзя вызвать метод, поскольку она равна null: " + e.getMessage());

    }
  }
}
