package src.main.java.hw_iterator;

import java.util.Iterator;

public class DoubleIterator<T> implements Iterator<T> {

    private Iterator<T> first;
    private Iterator<T> second;

    public DoubleIterator(Iterator<T> first, Iterator<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean hasNext() {
        if (first.hasNext() || second.hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next(){
        if (first.hasNext()) {
            return first.next();
        } else {
            return second.next();
        }
    }

}
