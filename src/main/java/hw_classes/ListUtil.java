package src.main.java.hw_classes;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUtil {

    public static List<Integer> rangeList(int from, int to) {
        return new AbstractList<>() {
            @Override
            public Integer get(int index) {
                if (index < 0 || index + 1 > to - from) {
                    throw new IndexOutOfBoundsException();
                }
                return index + from;
            }

            @Override
            public int size() {
                return (to - from);
            }

            @Override
            public int indexOf(Object o) {
                for (int i = from; i < to; i++){
                    if (o.equals(i)) {
                        return i - from;
                    }
                }
                return -1;
            }

            @Override
            public int lastIndexOf(Object o) {
                for (int i = to - 1; i > from - 1; i--) {
                    if (o.equals(i)) {
                        return i - from;
                    }
                }
                return -1;
            }

            @Override
            public boolean contains(Object o) {
                for (int i = from; i < to + 1; i++) {
                    if (o.equals(i)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public static List<Integer> medianSort(List<Integer> list) {
        int median;

        if (list.isEmpty()) {
            return list;
        }
        int size = list.size();
        Collections.sort(list);
        if (list.size() % 2 != 0) {
            median = list.get(size / 2);
        } else {
            median = (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
        }
        Comparator<Integer> myComparator = new MedianComparator(median);
        list.sort(myComparator);

        return list;
    }

    private static class MedianComparator implements Comparator<Integer> {
        int mediana;
        public MedianComparator(int mediana) {
            this.mediana = mediana;
        }

        @Override
        public int compare(Integer first, Integer second) {
            if (Math.abs(mediana - first) > Math.abs(mediana - second)) {
                return 1;
            } else if (Math.abs(mediana - first) == Math.abs(mediana - second))  {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
