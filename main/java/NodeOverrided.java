public class NodeOverrided<K, V> {
    V value;
    K key;
    NodeOverrided<K, V> next;

    public NodeOverrided(K key, V value, NodeOverrided<K, V> next) {
        this.value = value;
        this.key = key;
        this.next = next;
    }

    public NodeOverrided() {
    }
}

