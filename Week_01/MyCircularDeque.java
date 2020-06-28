
public class MyCircularDeque {

    public static void main(String... argv) {
        MyCircularDeque circularDeque = new MyCircularDeque(4);
        // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
        System.out.println(circularDeque.insertFront(3));			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  				// 返回 2
        System.out.println(circularDeque.isFull());				        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());				// 返回 4
    }

    private final int capacity;

    private int head = 1;

    private int tail = 0;

    private final int[] elements;

    private int count = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k < 1) {
            throw new RuntimeException("参数不能小于1");
        }
        capacity = k;
        elements = new int[capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (count == capacity) {
            return false;
        } else {
            head--;
            if (head < 0) {
                head = capacity - 1;
            }
            elements[head] = value;
            count++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (count == capacity) {
            return false;
        } else {
            tail++;
            if (tail > capacity - 1) {
                tail = 0;
            }
            elements[tail] = value;
            count++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (count <= 0) {
            return false;
        } else {
            head++;
            if (head > capacity - 1) {
                head = 0;
            }
            count--;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (count <= 0) {
            return false;
        } else {
            tail--;
            if (tail < 0) {
                tail = capacity - 1;
            }
            count--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (count <= 0) {
            return 0;
        } else if (head == -1){
            return elements[0];
        } else {
            return elements[head];
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (count <= 0) {
            return 0;
        } else if (tail == -1){
            return elements[0];
        } else {
            return elements[tail];
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count <= 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == capacity;
    }
}

/*
["MyCircularDeque","insertFront","getRear","insertFront","getRear","insertLast","getFront","getRear","getFront","insertLast","deleteLast","getFront"]
[[3],[9],[],[9],[],[5],[],[],[],[8],[],[]]
 */