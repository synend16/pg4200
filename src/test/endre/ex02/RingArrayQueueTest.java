package ex02;

import org.junit.Test;
import org.pg4200.datastructure.queue.MyQueue;
import org.pg4200.datastructure.queue.MyQueueTestTemplate;

import static org.junit.Assert.*;

public class RingArrayQueueTest extends MyQueueTestTemplate{

    @Override
    protected <T> MyQueue<T> getNewInstance(Class<T> klass) {
        return new RingArrayQueue<>();
    }


//    @Test
//    public void enqueueWithLessThenCapacity() throws Exception {
//        RingArrayQueue<Integer> arrayQueue = new RingArrayQueue<>();
//        for (int i = 0; i < 8; i++) {
//            arrayQueue.enqueue(i+2);
//        }
//        arrayQueue.print();
//        assertEquals(java.util.Optional.of(2), arrayQueue.peek());
//    }
}