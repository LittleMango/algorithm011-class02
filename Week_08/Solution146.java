import java.util.Arrays;
import java.util.HashMap;

public class Solution146 {
    public static class LRUCache {
        // 用哨兵比较简单
        private int mCapacity;

        // value 存结点
        private HashMap<Integer, DoubleLink> hashMap;

        private DoubleLink head;
        private DoubleLink tail;

        public LRUCache(int capacity) {
            mCapacity = capacity;
            hashMap = new HashMap<>(capacity);
            head = new DoubleLink(-1, -1);
            tail = new DoubleLink(-1, -1);
            head.after = tail;
            tail.before = head;
        }

        public void put(int key, int value) {
            DoubleLink link = hashMap.get(key);
            if (link == null) {
                // 插入新节点
                link = new DoubleLink(key, value);
                hashMap.put(key, link);
                addPointToHead(link);
                // 判断容量
                if (hashMap.size() > mCapacity) {
                    hashMap.remove(tail.before.key);
                    removePointFromLink(tail.before);
                }
            } else {
                // 更新结点
                removePointFromLink(link);
                addPointToHead(link);
                link.val = value;
            }
        }

        public int get(int key) {
            DoubleLink link = hashMap.get(key);
            if (link == null) {
                return -1;
            } else {
                // 移动到头
                removePointFromLink(link);
                addPointToHead(link);
                return link.val;
            }
        }

        // 插入结点到头
        private void addPointToHead(DoubleLink point) {
            DoubleLink tmp = head.after;
            head.after = point;
            point.before = head;
            point.after = tmp;
            tmp.before = point;
        }

        // 移除任意节点
        private void removePointFromLink(DoubleLink point) {
            DoubleLink b = point.before;
            DoubleLink a = point.after;
            b.after = a;
            a.before = b;
            point.before = null;
            point.after = null;
        }

        public static class DoubleLink {
            int val;
            int key;
            DoubleLink before;
            DoubleLink after;

            public DoubleLink(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
