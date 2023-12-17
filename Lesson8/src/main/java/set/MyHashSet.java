package Lesson8.src.main.java.set;

import org.w3c.dom.Node;

import java.util.*;

public class MyHashSet<E> implements set.BaseSet<E> {

    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 30;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<E>[] table;
    private int size;
    private final float loadFactor;
    private int threshold;


    private static int hash(Object key) {
        return key.hashCode();
    }

    public MyHashSet(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    public MyHashSet() {
        this.loadFactor = LOAD_FACTOR;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = Math.min(table.length * 2, MAX_CAPACITY);
        Node<E>[] newTable = new Node[newCapacity];
        ArrayList<Node<E>> nodes = new ArrayList<>();

        for (Node<E> node : table) {
            while (node != null) {
                nodes.add(node);
                node = node.next;
            }
        }

        for (Node<E> node : nodes) {
            int hash = hash(node.hash);
            node.next = newTable[hash];
            newTable[hash] = node;
        }

        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }


    @Override
    public void add(E e) {
        if (table == null) {
            table = new Node[DEFAULT_CAPACITY];
            threshold = (int) (DEFAULT_CAPACITY * loadFactor);
        }
        if (size >= threshold) {
            resize();
        }
        int index = hash(e) & (table.length - 1);
        Node<E> node = table[index];
        while (node != null) {
            if (node.key.equals(e)) {
                return;
            }
            node = node.next;
        }
        Node<E> newNode = new Node<>(hash(e), e, table[index]);
        table[index] = newNode;
        size++;
    }


    @Override
    public void remove(Object o) {
        if (table == null) {
            return;
        }

        int index = hash(o) & (table.length - 1);
        Node<E> current = table[index];
        Node<E> previous = null;

        while (current != null) {
            if (current.key.equals(o)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }


    @Override
    public void clear() {
        if (table != null) {
            Arrays.fill(table, null);
            size = 0;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (table != null) {
            int index = hash(o) & (table.length - 1);
            Node<E> node = table[index];
            while (node != null) {
                if (node.key.equals(o)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyHashSet<?> myHashSet = (MyHashSet<?>) o;

        if (size != myHashSet.size) return false;

        for (Object element : this) {
            if (!myHashSet.contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new HashSetIterator();
    }

    private class HashSetIterator implements Iterator<E> {

        private Node<E> head;
        private Node<E> current;

        public HashSetIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E element = current.key; // Предположим, что в узле есть поле key для хранения значения
            current = current.next;  // Предположим, что узел содержит ссылку на следующий узел
            return element;
        }
    }

    @Override

    public String toString() {
        StringJoiner sj = new StringJoiner(", ");
        for (Node<E> node : table) {
            while (node != null) {
                sj.add(String.valueOf(node.key));
                node = node.next;
            }
        }
        return sj.toString();
    }


    static class Node<T> {

        final int hash;
        final T key;
        Node<T> next;

        public Node(int hash, T key, Node<T> next) {
            this.hash = hash;
            this.key = key;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?> node = (Node<?>) o;
            return hash == node.hash && Objects.equals(key, node.key) && Objects.equals(
                    next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hash, key, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", next=" + next +
                    '}';
        }
    }
}
