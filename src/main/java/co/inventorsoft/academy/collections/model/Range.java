package co.inventorsoft.academy.collections.model;

import java.util.*;
import java.util.function.Function;

public class Range<T> implements Set<T> {

    private TreeSet<T> rangeSet;

    public Range(){
        rangeSet = new TreeSet<>();
    }

    public int size() {
        return rangeSet.size();
    }

    public boolean isEmpty(){
        return rangeSet.isEmpty();
    }

    public boolean contains(Object o) {
        return rangeSet.contains(o);
    }

    public Iterator<T> iterator()
    {
        return rangeSet.iterator();
    }

    public Object[] toArray() {
        return rangeSet.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return rangeSet.toArray(a);
    }

    public boolean add(T t) {
        return rangeSet.add(t);
    }

    public boolean remove(Object o) {
        return rangeSet.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return rangeSet.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return rangeSet.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return rangeSet.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return rangeSet.removeAll(c);
    }

    public void clear() {
        rangeSet.clear();
    }

    public static <T extends Comparable> Range<T> of(T start, T finish, Function<T, T> step) {
        Range<T> range = new Range<T>();
        if (start.compareTo(finish) == 0) {
            return range;
        }

        T nextElement = start;

        do {
            range.add(nextElement);
            nextElement = step.apply(nextElement);
        } while (nextElement.compareTo(finish) <= 0);

        return range;
    }

    public static Range<Integer> of(Integer start, Integer finish) {
        return of(start, finish, new Function<Integer, Integer>() {
            public Integer apply(Integer integerToIncrement) {
                return integerToIncrement + 1;
            }
        });
    }

    public static Range<Short> of(Short start, Short finish) {
        return of(start, finish, new Function<Short, Short>() {
            public Short apply(Short shortToIncrement) {
                return (short)(shortToIncrement + 1);
            }
        });
    }

    public static Range<Byte> of(Byte start, Byte finish) {
        return of(start, finish, new Function<Byte, Byte>() {
            public Byte apply(Byte byteToIncrement) {
                return (byte)(byteToIncrement + 1);
            }
        });
    }

    public static Range<Double> of(Double start, Double finish) {
        return of(start, finish, new Function<Double, Double>() {
            public Double apply(Double doubleToIncrement) {
                return doubleToIncrement + 0.1;
            }
        });
    }

    public static Range<Float> of(Float start, Float finish) {
        return of(start, finish, new Function<Float, Float>() {
            public Float apply(Float floatToIncrement) {
                return floatToIncrement + 0.1f;
            }
        });
    }
}