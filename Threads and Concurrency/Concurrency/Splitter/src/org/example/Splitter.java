package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.function.ToLongFunction;
import java.util.stream.IntStream;






public class Splitter {
    public static Collection<Callable<Long>> split(long[] vector, int n, ToLongFunction<long[]> f) {
        final int sliceLength = vector.length / n;
        return IntStream
                .range(0, n)
                .mapToObj(i -> Arrays.copyOfRange(vector, i * sliceLength, (i + 1) * sliceLength))
                .map(slice -> (Callable<Long>) () -> f.applyAsLong(slice))
                .toList();

    }
    interface Agregate{
        public long get(Collection<Callable<Long>> collection);
    }

    public static void main(String[] args){
        long[] data = {1,2,3,4};

        Collection<Callable<Long>> collection1 = split(data,2, x-> x.length);
        Collection<Callable<Long>> collection2 = split(data,2, x-> Arrays.stream(x).sum());
        Agregate agregate = u->u.stream()
                        .map(x-> {
                            try {
                                return x.call();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .reduce(0L, Long::sum);
        System.out.println("Length of " + Arrays.toString(Arrays.stream(data).toArray()) +" = "+
                agregate.get(collection1));

        System.out.println("Sum of " + Arrays.toString(Arrays.stream(data).toArray()) +" = "+
                agregate.get(collection2));

    }


}