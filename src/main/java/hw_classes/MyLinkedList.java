package src.main.java.hw_classes;

import hw_iterator.MyIterator;
import interfaces.List;

public class MyLinkedList<E> implements List<E>, Iterable<E> {

    Node<E> first;

    Node<E> last;

    int size = 0;

    public void add(E el) {
        Node<E> newNode = new Node<>(el);
        Node<E> lastNode = last;

        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
        }
        size++;
    }

    public void insertHead(E el) {
        Node<E> newNode = new Node<>(el);
        Node<E> firstNode = first;

        first = newNode;
        if (firstNode == null) {
            last = newNode;
        } else {
            firstNode.setPrev(newNode);
            newNode.setNext(firstNode);
        }
        size++;
    }

    public void printList() {
        Node<E> current = first;
        System.out.print("[");
        while (current.getNext() != null) {
            System.out.print(current.getValue() + ", ");
            current = current.getNext();
        }
        System.out.print(current.getValue() + "]");
    }

    @Override
    public void add(int index, E el) {
        Node<E> newNode = new Node<>(el);

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (last == null || first == null) {
            if (index != 0) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                add(el);
            }
        } else {
            if (index == size) {
                add(el);
            } else {
                Node<E> current = getNode(index);
                Node<E> curPrev = current.getPrev();
                newNode.setNext(current);
                newNode.setPrev(curPrev);
                current.setPrev(newNode);
                if (curPrev == null)
                    first = newNode;
                else
                    curPrev.setNext(newNode);
                size++;
            }
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || first == null || last == null || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return getNode(index).getValue();
        }
    }

    public Node<E> getNode(int index) {
        Node<E> curr;
        if (index < size / 2) {
            curr = first;
            for (int i = 0; i < index; i++)
                curr = curr.getNext();
        } else {
            curr = last;
            for (int i = size - 1; i > index; i--)
                curr = curr.getPrev();
        }
        return curr;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || first == null || last == null || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node<E> current = getNode(index);
            Node<E> next = current.getNext();
            Node<E> prev = current.getPrev();

            if (prev == null) {
                first = next;
            } else {
                prev.setNext(next);
                current.setPrev(null);
            }

            if (next == null) {
                last = prev;
            } else {
                next.setPrev(prev);
                current.setNext(null);
            }

            current.setValue(null);
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        return first != null ? first.getValue() : null;
    }

    public E getLast() {
        return last != null ? last.getValue() : null;
    }

    public void clear() {
        Node<E> current = first;
        while (current != null) {
            Node<E> next = current.getNext();
            current.setValue(null);
            current.setNext(null);
            current.setPrev(null);
            current = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;

        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyIterator<E>(this);
    }
}