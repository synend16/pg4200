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

    @Test
    public void testPeekWhileQueueIsEmpty() throws Exception {
        try{
            queue.peek();
            fail();
        }catch (RuntimeException e){
            //expected to fail
        }
    }

    @Test
    public void testIfToStringReturnsString() throws Exception {
        queue.enqueue(2);
        queue.enqueue(6);
        queue.enqueue(10);

        System.out.println(queue.toString());
        assertEquals("2\n6\n10\n", queue.toString());
    }
}