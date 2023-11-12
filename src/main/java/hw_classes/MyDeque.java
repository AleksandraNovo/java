package src.main.java.hw_classes;

import interfaces.Deque;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyDeque<E> implements Deque<E> {

    private Stack<E> inbox = new Stack<E>();
    private Stack<E> outbox = new Stack<E>();

    @Override
    public void addFirst(E e) {
        inbox.push(e);
    }

    @Override
    public void addLast(E e) {
        outbox.push(e);
    }

    @Override
    public E removeFirst() {
        if (inbox.isEmpty()) {
            while (!outbox.isEmpty()) {
                inbox.push(outbox.pop());
            }
        }
        if (inbox.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return inbox.pop();
        }
    }

    @Override
    public E removeLast() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        if (outbox.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return outbox.pop();
        }
    }

    @Override
    public E peekFirst() {
        if (inbox.isEmpty()) {
            while (!outbox.isEmpty()) {
                inbox.push(outbox.pop());
            }
        }
        return inbox.peek();
    }

    @Override
    public E peekLast() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.peek();
    }

    @Override
    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    @Override
    public int size() {
        return inbox.size() + outbox.size();
    }

    @Override
    public void printDeque() {
        System.out.print("[");
        E el = removeFirst();
        while (el != null) {
            System.out.print(el + ", ");
            el = removeFirst();
        }
        System.out.print("]");
    }
}
