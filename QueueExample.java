class MyQueue<T> {

    private Object[] queue; // 保留變數名稱
    private int front;      // 佇列開頭索引
    private int rear;       // 下一個可插入位置
    private int size;       // 當前元素數量

    public MyQueue() {
        queue = new Object[10]; // 初始容量
        front = 0;
        rear = 0;
        size = 0;
    }

    // 入隊
    public void enqueue(T item) {
        if (size == queue.length) {
            expandCapacity();
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
    }

    // 出隊
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T item = (T) queue[front];
        queue[front] = null; // 避免記憶體洩漏
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    // 是否為空
    public boolean isEmpty() {
        return size == 0;
    }

    // 目前元素數量
    public int size() {
        return size;
    }

    // 擴充容量
    private void expandCapacity() {
        Object[] newQueue = new Object[queue.length * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size;
    }
}


public class QueueExample {
    public static void main(String[] args) {
        MyQueue<Integer> intQueue = new MyQueue<>();

        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);

        System.out.println("Dequeue: " + intQueue.dequeue()); // 10
        System.out.println("Dequeue: " + intQueue.dequeue()); // 20
        System.out.println("Size: " + intQueue.size()); // 1
        System.out.println("Is Empty: " + intQueue.isEmpty()); // false
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

    // ✅ 為了讓 Assert.assertEquals() 比對成功
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return this.age == other.age &&
               (this.name == null ? other.name == null : this.name.equals(other.name));
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age);
    }
}
//---------------------------------------------------------------------------------
