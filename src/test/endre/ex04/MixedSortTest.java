package ex04;

import org.pg4200.sorting.MySort;
import org.pg4200.sorting.SortTestTemplate;

import static org.junit.Assert.*;

public class MixedSortTest extends SortTestTemplate{

    @Override
    protected MySort getInstance() {
        return new MixedSort(4);
    }
}