class MyQueue<T> {

    public MyQueue() {
    }

    public void enqueue(T item) {
    }

    public T dequeue() {
        return queue.first();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // 返回队列中的元素数量
    public int size() {
        return queue.size();
    }
}

public class QueueExample {
    public static void main(String[] args) {
        MyQueue<Integer> intQueue = new MyQueue<>();
        //do some test if needed
    }
}


//我的Junit測試會測這個Object，這邊以下請不要修改
//---------------------------------------------------------------------------------
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
//---------------------------------------------------------------------------------