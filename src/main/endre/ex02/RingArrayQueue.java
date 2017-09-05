package ex02;

import org.pg4200.datastructure.queue.MyQueue;

public class RingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;

    private int head = -1;
    private int tail = -1;


    public RingArrayQueue(){
        this(10);
    }

    public RingArrayQueue(int capacity){
        data = new Object[capacity];
    }



    @Override
    public void enqueue(Object value) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }


}
