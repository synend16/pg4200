package ex03;

import java.util.Comparator;

public class OptimizedBubbleSort {


    public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized){
        if (array == null){
            return 0;
        }

        int counter = 0;
        int lastIndexSwapped = array.length - 1;
        boolean swapped = true;

        while (swapped) {

            swapped = false;

            int limit = array.length -1;
            if (optimized){
                limit = lastIndexSwapped;
            }


            for (int i = 0; i < limit; i++) {
                int j = i + 1;

                counter++;

                if (comparator.compare(array[i], array[j]) > 0){
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    swapped = true;
                    lastIndexSwapped = i;
                }
            }
        }
        return counter;
    }
}
