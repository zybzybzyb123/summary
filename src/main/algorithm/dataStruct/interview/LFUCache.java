package algorithm.dataStruct.interview;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LFUCache {

    private class Node {

        private int key;
        private int val;
        private int freq;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }

        public Node() {}
    }

    private Map<Integer, Node> lfuCache;
    private Map<Integer, LinkedHashSet<Node>> freqMap;
    private int size;
    private int capacity;
    private int minFreq;

    public LFUCache(int capacity) {
        lfuCache = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        Node node = lfuCache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
         Node node = lfuCache.get(key);
         if (node != null) {
             node.val = value;
             freqInc(node);
         } else {
             if (size == capacity) {
                 Node deadNode = removeNode();
                 lfuCache.remove(deadNode.key);
                 size--;
             }
             node = new Node(key, value);
             addNode(node);
             lfuCache.put(key, node);
             size++;
         }
    }

    private void freqInc(Node node) {
        int freq = node.freq;
        Set<Node> oldFreqNodeSet = freqMap.get(freq);
        oldFreqNodeSet.remove(node);
        if (freq == minFreq && oldFreqNodeSet.size() == 0) {
            minFreq++;
        }
        node.freq++;
        LinkedHashSet<Node> nodeSet = freqMap.getOrDefault(freq + 1, new LinkedHashSet<>());
        nodeSet.add(node);
        freqMap.put(freq + 1, nodeSet);
    }

    private Node removeNode() {
        Set<Node> minFreqNodeSet = freqMap.get(minFreq);
        Node deadNode = minFreqNodeSet.iterator().next();
        minFreqNodeSet.remove(deadNode);
        return deadNode;
    }

    private void addNode(Node node) {
        freqMap.computeIfAbsent(1, LinkedHashSet::new);
        LinkedHashSet<Node> nodeSet = freqMap.getOrDefault(1, new LinkedHashSet<>());
        nodeSet.add(node);
        freqMap.put(1, nodeSet);
        minFreq = 1;
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);
        lfuCache.put(3, 3);
        lfuCache.get(2);
        lfuCache.put(4, 4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);
    }
}
