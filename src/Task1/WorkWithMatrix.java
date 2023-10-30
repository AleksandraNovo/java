package src.Task1;

public class WorkWithMatrix<T> implements Matrix<T> {

  public T[][] matrix;

  public WorkWithMatrix(int lines, int columns) {
    matrix = (T[][]) new Object[lines][columns];
  }
  public WorkWithMatrix(T[][] newMatrix) {
    int lines = newMatrix.length;
    int columns = newMatrix[0].length;
    matrix = (T[][]) new Object[lines][columns];
    for (int i = 0; i < lines; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = newMatrix[i][j];
      }
    }
  }
  public void addElement(T element) {
    int lines = matrix.length;
    int columns = matrix[0].length;
    T[][] newMatrix = (T[][]) new Object[lines][columns];
    for (int i = 0; i < lines; i++) {
      for (int j = 0; j < columns; j++) {
        newMatrix[i][j] = matrix[i][j];
      }
    }
    matrix = newMatrix;
    matrix[lines - 1][columns - 1] = element;
  }
  public void removeElement(int line, int column) {
    int lines = matrix.length;
    int columns = matrix[0].length;
    if (line >= 0 && line < lines && column >= 0 && column < columns) {
      matrix[line][column] = null;
    } else {
      throw new IndexOutOfBoundsException("Invalid matrix index");
    }
  }
  public T getElement(int row, int column) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    if (row >= 0 && row < rows && column >= 0 && column < columns) {
      return matrix[row][column];
    } else {
      throw new IndexOutOfBoundsException("Invalid matrix index");
    }
  }

}

