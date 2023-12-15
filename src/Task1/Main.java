package src.Task1;

public class Main {
  public static void main(String[] args) {
    Matrix<Integer> matrix1 = new WorkWithMatrix<>(3, 3);
    matrix1.addElement(1);
    matrix1.addElement(2);
    matrix1.addElement(3);
    matrix1.addElement(4);
    matrix1.addElement(5);
    matrix1.addElement(6);
    matrix1.addElement(7);
    matrix1.addElement(8);
    matrix1.addElement(9);

    System.out.println(matrix1.getElement(1, 1)); // Вывод: 5

    matrix1.removeElement(0, 2);
    System.out.println(matrix1.getElement(0, 2)); // Вывод: null

    // Использование конструктора на основе другой матрицы
    Integer[][] newMatrix = {{1, 2}, {3, 4}};
    Matrix<Integer> matrix2 = new WorkWithMatrix<>(newMatrix);

    System.out.println(matrix2.getElement(1, 0)); // Вывод: 3
  }
}