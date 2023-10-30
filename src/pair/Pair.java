package src.pair;

public class Pair<L extends Comparable<L>, R extends Comparable<R>> {
  private L left;
  private R right;

  public Pair(L left, R right) {
    this.left = left;
    this.right = right;
  }

  public L getLeft() {
    return left;
  }

  public void setLeft(L left) {
    this.left = left;
  }

  public R getRight() {
    return right;
  }

  public void setRight(R right) {
    this.right = right;
  }
  public Comparable<?> min() {
    if (left.compareTo((L) right) <= 0) {
      return left;
    } else {
      return right;
    }
  }

  public Comparable<?> max() {
    if (left.compareTo((L) right) >= 0) {
      return left;
    } else {
      return right;
    }
  }
}