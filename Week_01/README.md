### 这一周主要学了、记住以下几个点
1. 不能马上想到思路的题，一定要马上去看解题报告，不用浪费时间。
2. 做完题目之后一定要去看解题报告，把票数高的几种做法全部思考一遍，有必要的话，可以全部实现。
3. 学习的时候尽可能先从暴力求解的角度思考，通常暴力解法是多了一两遍循环，这个时候可以通过空间换时间的做法，优化暴力求解的算法。
4. 一定要熟悉数组、链表、队列、栈、树、图的结构和它们常见的遍历算法，因为考题绝大部分的时间复杂度都不是常数级，除了N分这种对数时间复杂度，其余大部分都至少是线性复杂度，映射到语言关键字，那么就是for、while等循环，大致可以看做是对数据的整体遍历。
5. 多做做需要几种数据结构结合的算法，比如通常对重复计算的优化是新增一个hash容器保存已计算的数据，BFS新增一个队列保存距离相等的一层父节点。
6. 给定和、积，求所有组合的，马上用递归，如果有重复子项，考虑备忘录或者动态规划。
7. 最重要的是结合无毒神掌(艾宾浩斯遗忘曲线)，切忌题只刷一遍，随着知识的拓展，老题往往能写出不一样的味道。


### Queue&Priority源码分析
> 要看实现了同一个接口的几个类的异同，最快速的方法在于查看他们的源码前面关于类的简述，很多情况下在开头的注释中会提到该类与其它同类的异同，比如当从Queue的角度看，ArrayDeque会比LinkedList更加高效。

1. Queue是接口，PriorityQueue是实现了该接口的一个类，后者拥有前者的所有方法
2. Queue的实现类比较常见有以下几种类型
* 以数组作为容器的ArrayDeque
* 以链表作为容器的LinkedList
* 以堆作为容器的PriorityQueue

下面简单分析一下以上三种数据接口
1. ArrayDeque实现了Deque接口，而Deque继承了Queue接口，并且在其基础上为原有的方法新增一对`xxxFirst`、`xxxLast`操作，实现可以在队头、队位插入、删除元素的目的，由于使用的是数组作为容器(O(1)的随机访问时间，CPU Cache按连续内存块的读取逻辑)，相较于链表，单从Queue的角度来看，它会比LinkedList更加高效。

2. LinkedList和ArrayDeque类似，也是实现了Deque接口，采用双链表的结构作为数据容器，该类持有两个字段，分别是头结点和尾节点，如果只在队头、队位做操作，其时间复杂度也是常量时间复杂度。

3. PriorityQueue采用堆作为存储数据的结构，在Java1.8中，这个堆是平衡二叉堆，用数组作为容器，而且堆中的元素带有权重(优先级)，可以在构造方法中通过传入一个实现了`Comparator`接口的对象来实现优先级比较。由于在入队和出队的时候会进行堆画，因此在入队和出队的时候时间复杂度是O(logn)。

最后，以上三种都是非线程安全的，其对应的线程安全类以上的特性是一样的，更多的分析应该放在线程同步的机制上进行分析，比如：
* 悲观锁，是锁全局对象还是锁分段，锁分段可以看concurrenthashmap(1.7版本及以前)
* 乐观锁，比如1.8的concurrenthashmap就使用synchronized和CAS算法来保证线程安全

### Deque改写
```
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String... argv) {
        testAddLast();
        testAddFirst();
    }

    private static void testAddFirst() {
        System.out.println("----------testAddFirst start-------------");
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        // 队列，输出c b a
        System.out.println(deque);

        String str = deque.peek();
        // 队头 c 不出队
        System.out.println(str);
        // 输出c b a
        System.out.println(deque);

        // 依次出队 c b a
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        // 空队列
        System.out.println(deque);

        System.out.println("----------testAddFirst end-------------");
    }
    private static void testAddLast() {
        System.out.println("----------testAddLast start-------------");
        Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        // 队列，输出a b c
        System.out.println(deque);

        String str = deque.peek();
        // 队头 a 不出队
        System.out.println(str);
        // 输出a b c
        System.out.println(deque);

        // 依次出队 a b c
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        // 空队列
        System.out.println(deque);

        System.out.println("----------testAddLast end-------------");
    }
}

```