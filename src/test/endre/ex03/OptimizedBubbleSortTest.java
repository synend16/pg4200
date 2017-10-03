package ex03;

import org.junit.Test;
import org.pg4200.exercise.ex03.OptimizedBubbleSort;

import java.util.Comparator;

public class OptimizedBubbleSortTest {

    ex03.OptimizedBubbleSort optimizedBubbleSort;


    @Test
    public void arrayOfCharsInStringFormat() throws Exception {
        optimizedBubbleSort = new ex03.OptimizedBubbleSort();
        String[] array = {"c", "b", "a", "d", "e", "f"};
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String)o1;
                String s2 = (String)o2;
                return s1.compareTo(s2);
            }
        };
        int count = optimizedBubbleSort.sort(array, comparator, true);
        System.out.println(count);
    }

}