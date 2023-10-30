package src.Task2;

public class Task2 {

  public static class Tuple<E> {
    private Object[] elements;
    private int size;

    public Tuple(int capacity) {
      elements = new Object[capacity];
      size = 0;
    }

    public E get(int index) {
      if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
      }
      return (E) elements[index];
    }

    public void add(E element) {
      add(element, size);
    }

    public void add(E element, int index) {
      if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
      }
      if (size == elements.length) {
        throw new IllegalStateException("Tuple is at maximum capacity.");
      }
      for (int i = size; i > index; i--) {
        elements[i] = elements[i - 1];
      }
      elements[index] = element;
      size++;
    }

    public void remove(int index) {
      if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
      }
      for (int i = index; i < size - 1; i++) {
        elements[i] = elements[i + 1];
      }
      elements[size - 1] = null;
      size--;
    }

    public void remove(E element) {
      for (int i = 0; i < size; i++) {
        if (elements[i].equals(element)) {
          remove(i);
          break;
        }
      }
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public E orElse(int index, E defaultValue) {
      if (index < 0 || index >= size) {
        return defaultValue;
      }
      return (E) elements[index];
    }
  }

}
