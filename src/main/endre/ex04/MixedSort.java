package ex04;

import org.pg4200.sorting.MySort;

public class MixedSort implements MySort {

    private final int bubbleLimit;

    public MixedSort(int bubbleLimit) {
        this.bubbleLimit = bubbleLimit;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null){
            return;
        }

        T[] buffer = (T[]) new Comparable[array.length];

        mergeSort(0, array.length - 1, array, buffer);
    }


    private <T extends Comparable<T>> void mergeSort(int low, int high, T[]array, T[] buffer){

    }
}
