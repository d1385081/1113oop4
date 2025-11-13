import org.junit.*;

public class QueueTest {

    @Test
    public void testEnqueueAndDequeueInteger() {
        MyQueue<Integer> intQueue = new MyQueue<>();
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);

        Assert.assertEquals(3, intQueue.size());
        Assert.assertEquals(Integer.valueOf(10), intQueue.dequeue());
        Assert.assertEquals(Integer.valueOf(20), intQueue.dequeue());
        Assert.assertEquals(Integer.valueOf(30), intQueue.dequeue());
        Assert.assertTrue(intQueue.isEmpty());
    }

    @Test
    public void testEnqueueAndDequeueString() {
        MyQueue<String> stringQueue = new MyQueue<>();
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");

        Assert.assertEquals(2, stringQueue.size());
        Assert.assertEquals("Hello", stringQueue.dequeue());
        Assert.assertEquals("World", stringQueue.dequeue());
        Assert.assertTrue(stringQueue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        MyQueue<Integer> intQueue = new MyQueue<>();
        Assert.assertTrue(intQueue.isEmpty());
        intQueue.enqueue(1);
        Assert.assertFalse(intQueue.isEmpty());
        intQueue.dequeue();
        Assert.assertTrue(intQueue.isEmpty());
    }

    @Test
    public void testSize() {
        MyQueue<Integer> intQueue = new MyQueue<>();
        Assert.assertEquals(0, intQueue.size());
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        Assert.assertEquals(2, intQueue.size());
        intQueue.dequeue();
        Assert.assertEquals(1, intQueue.size());
    }

    @Test
    public void testQueueWithObjects() {
        MyQueue<Person> personQueue = new MyQueue<>();
        Person alice = new Person("Alice", 25);
        Person bob = new Person("Bob", 30);

        personQueue.enqueue(alice);
        personQueue.enqueue(bob);

        Assert.assertEquals(alice, personQueue.dequeue());
        Assert.assertEquals(bob, personQueue.dequeue());
        Assert.assertTrue(personQueue.isEmpty());
    }
}
