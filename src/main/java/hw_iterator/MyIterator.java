package src.main.java.hw_iterator;

import hw_classes.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {

    private MyLinkedList.Node<T> next;

    private MyLinkedList.Node<T> prev;

    public MyIterator(MyLinkedList<T> list) {
        next = list.getNode(0);
        prev = next != null ? next.getPrev() : null;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() {
        if (hasNext()) {
            MyLinkedList.Node<T> currNext = next;
            next = next.getNext();
            prev = currNext;
            return currNext.getValue();
        } else {
            throw new NoSuchElementException();
        }
    }

    public boolean hasPrevious() {
        return prev != null;
    }

    public T previous() {
        if (hasPrevious()) {
            MyLinkedList.Node<T> currPrev = prev;
            prev = prev.getPrev();
            next = currPrev;
            return currPrev.getValue();
        } else {
            throw new NoSuchElementException();
        }
    }
}
