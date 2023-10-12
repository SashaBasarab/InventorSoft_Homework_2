package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T extends Comparable<T>> implements Set<T> {

    private T start;
    private T finish;
    private Function<T, T> step;
    private Set<T> elements;

    public Range(T start, T finish, Function<T, T> step) {
        this.start = start;
        this.finish = finish;
        this.step = step;
        this.elements = new HashSet<>();
    }

    public static void main(String[] args) {
        Range.of(1, 1000000000);
    }

    public int size() {
        int size = 0;
        for (T item : this) {
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (start.equals(finish)) {
            return true;
        }
        return !iterator().hasNext() && elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        for (T item : this) {
            if (Objects.equals(o, item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private T current = start;

            @Override
            public boolean hasNext() {
                return current.compareTo(finish) <= 0;
            }

            @Override
            public T next() {
                T result = current;
                current = step.apply(current);
                return result;
            }
        };
    }

    @Override
    public Object[] toArray() {
        List<T> list = new ArrayList<>();
        for (T item : this) {
            list.add(item);
        }
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        List<T> list = new ArrayList<>();
        for (T item : this) {
            list.add(item);
        }
        return list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return elements.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return elements.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return elements.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public void clear() {
        elements.clear();
    }

    public static <T extends Comparable<T>> Range<T> of(T start, T finish, Function<T, T> step) {
        return new Range<>(start, finish, step);
    }

    public static Range<Long> of(Long start, Long finish) {
        return of(start, finish, longToIncrement -> longToIncrement + 1);
    }
    public static Range<Integer> of(Integer start, Integer finish) {
        return of(start, finish, integerToIncrement -> integerToIncrement + 1);
    }

    public static Range<Short> of(Short start, Short finish) {
        return of(start, finish, shortToIncrement -> (short)(shortToIncrement + 1));
    }

    public static Range<Byte> of(Byte start, Byte finish) {
        return of(start, finish, byteToIncrement -> (byte)(byteToIncrement + 1));
    }

    public static Range<Double> of(Double start, Double finish) {
        return of(start, finish, doubleToIncrement -> doubleToIncrement + 0.1);
    }

    public static Range<Float> of(Float start, Float finish) {
        return of(start, finish, floatToIncrement -> floatToIncrement + 0.1f);
    }
}