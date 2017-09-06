package ex02;

import org.pg4200.datastructure.queue.MyQueue;

public class RingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;

    private int tail = -1;
    private int head = -1;



    public RingArrayQueue(){
        this(10);
    }

    public RingArrayQueue(int capacity){
        data = new Object[capacity];
    }



    @Override
    public void enqueue(Object value) {
        //System.out.println(isFull());
        if (isEmpty()){
            System.out.println("\nempty array, setting head and tail to 0\n");
            head = 0;
            tail = 0;
        }
        if (isFull()){
            System.out.println("creating new array");
            Object[] tmp = new Object[data.length * 2];

            int  size = data.length;
            for(int i=0; i<size; i++){
                tmp[i] = data[i + head];
            }
            head = 0;
            tail = size-1;
            data = tmp;
        }
        System.out.println("adding " + value + " to index " + tail);
        data[tail] = value;
        //tail = (tail + 1) % data.length;
        tail++;


    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new RuntimeException();
        }

        T value = (T) data[head];

        if (size() == 1){
            //Now the array will be empty
            head = -1;
            tail = -1;
        }else {
            head++;
        }

        return value;
    }

    @Override
    public T peek() {
        return (T) data[head];
    }

    @Override
    public int size(){
        if (head < 0) return 0;
        System.out.println("tail is now " + tail);
        int front = Math.abs((data.length-1) - head);
        int back = Math.abs((data.length-1) - tail);
        return (Math.abs(front-back));
    }




    private boolean isFull(){

        //TODO erstatte kode med youtube video
        //https://www.youtube.com/watch?v=ia__kyuwGag
        //if (head == tail) return false;

        //if (head < tail){
        //    return (tail-head +1) == data.length;
        //}

        //return (head - tail) == 1;
        //System.out.println("head: " + head + " tail: " + tail);
        return (head == (tail + 1) % data.length);
    }


    public void print(){
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        RingArrayQueue<Integer> ringArrayQueue = new RingArrayQueue<>();
        for (int i = 0; i < 19; i++) {
            ringArrayQueue.enqueue(2*i);
        }
        ringArrayQueue.dequeue();
        System.out.println("\n\nPrinting Array");
        ringArrayQueue.print();
    }


}
