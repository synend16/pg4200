package ex01;

import org.pg4200.datastructure.delete.ArrayDeleteContainer;

/**
 * Created by Endre on 22.08.2017.
 * Verson: 1.0
 */
public class MyArrayList<T> extends ArrayDeleteContainer<T>{

    public MyArrayList(){super();}

    public MyArrayList(int capacity){super(capacity);}

    @Override
    public void add(T value) {

        if (size == data.length){
            Object[] bigger = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                bigger[i] = data[i];

            }
            data = bigger;
        }

        super.add(value);
    }
}