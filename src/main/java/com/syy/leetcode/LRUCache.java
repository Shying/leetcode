package com.syy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


class LRUCache1 {
    Map<Integer, Integer> array = new HashMap<Integer, Integer>();
    int capacity = 0;
    Map<Integer, Long> access = new HashMap<Integer, Long>();
    long op = 0L;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        array.clear();
        access.clear();
    }
    
    public int get(int key) {
        if(array.containsKey(key)) {
            access.put(key, op);
            op++;
            return array.get(key);
        }
        return -1;
    }

    public void makeRoom() {
        if (array.size() < capacity) {
            return;
        }
        while (array.size() >= capacity) {
            Object[] values = access.values().toArray();
            Arrays.sort(values);
            Long min = (Long)values[0];
            int minKey = -1;
            for(Map.Entry<Integer, Long> entry: access.entrySet()) {
                if (entry.getValue().equals(min)) {
                    minKey = entry.getKey();
                    break;
                }
            }
            access.remove(minKey);
            array.remove(minKey);
        }
    }
    
    public void put(int key, int value) {
        int oldValue = this.get(key);
        if (oldValue == -1) {
            makeRoom();
        }
        array.put(key, value);
        access.put(key, op);
        op++;
    }


}

class LRUCache2 {

    Map<Integer, Integer> array = new HashMap<Integer, Integer>();
    int capacity = 0;
    List<Integer> stack = new ArrayList<Integer>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        array.clear();
        stack.clear();
    }

    public int get(int key) {
        if(array.containsKey(key)) {
            stack.remove(Integer.valueOf(key));
            stack.add(key);
            return array.get(key);
        }
        return -1;
    }

    public void makeRoom() {
        if (array.size() < capacity) {
            return;
        }
        int stackLen = stack.size();
        for (int i = 0; i < stackLen - capacity + 1; i++) {
            array.remove(stack.get(i));
            stack.remove(0);
        }
    }

    public void put(int key, int value) {
        int oldValue = this.get(key);
        if (oldValue == -1) {
            makeRoom();
        }
        array.put(key, value);
        stack.remove(Integer.valueOf(key));
        stack.add(key);
    }

}

class LRUCache {
    LinkedHashMap<Integer, Integer> array;

    public LRUCache(int capacity) {
        array = new LinkedHashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {
        if(array.containsKey(key)) {
            return array.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        array.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry: array.entrySet()) {
            builder.append(entry.getKey());
            builder.append(": ");
            builder.append(entry.getValue());
            builder.append(", ");
        }
        //        builder.append("\n");
        //        for(Map.Entry<Integer, Long> entry: access.entrySet()) {
        //            builder.append(entry.getKey());
        //            builder.append(": ");
        //            builder.append(entry.getValue());
        //            builder.append(", ");
        //        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        System.out.println(cache);

        System.out.println(cache.get(2));       // 返回 -1 (未找到)

        cache.put(2, 6);
        System.out.println(cache);

        System.out.println(cache.get(1));       // 返回 -1 (未找到)

        cache.put(1, 5);
        System.out.println(cache);

        cache.put(1, 2);    // 该操作会使得密钥 2 作废
        System.out.println(cache);

        System.out.println(cache.get(1));       // 返回 2
        System.out.println(cache);


        System.out.println(cache.get(2));       // 返回 6
        System.out.println(cache);

    }
}

