package com.mort.leetCode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mort
 * @Description
 * @date 2021/11/23
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 **/
public class LruCache {

    public static class DLink {
        private Integer key;
        private Integer value;
        private DLink pre;
        private DLink next;

        public DLink(Integer _key, Integer _value) {
            this.key = _key;
            this.value = _value;
        }

        public DLink() {

        }
    }

    private Map<Integer, DLink> cache = new HashMap<>();

    private int size;
    private int capacity;
    private DLink head, tail;


    public LruCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLink();
        this.tail = tail;
    }

    public Integer get(Integer key) {
        if (null == cache.get(key)) {
            return -1;
        }
        DLink dLink = cache.get(key);
        moveToHead(head, dLink);
        return dLink.value;
    }


    public void put(Integer key, Integer value) {

        DLink newNode = new DLink(key, value);
        moveToHead(head, newNode);

        if (size > capacity) {
            //移除尾部  移除缓存
            cache.remove(tail.key);
            tail.pre.next = null;
            tail.pre = null;
        }

    }

    private void moveToHead(DLink head, DLink newNode) {

        //move to header
        DLink tmpDlink = newNode.next;
        newNode.pre.next = tmpDlink;
        tmpDlink.pre = newNode.pre;

        newNode.next = head;
        newNode.pre = null;
        head.pre = newNode;
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
    }
}
