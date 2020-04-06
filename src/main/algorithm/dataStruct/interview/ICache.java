package algorithm.dataStruct.interview;

public interface ICache<K, V> {

    V get(K key);

    void put(K key, V value);
}
