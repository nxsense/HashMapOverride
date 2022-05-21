public class HashMapOverride<K, V> {
    private int starterSize = 16;
    private double coefficient = 0.75;
    private NodeOverrided[] nodes = new NodeOverrided[starterSize];
    private int threshold =(int) (nodes.length * coefficient);
    private int size;



    private int getBucket(K key){
        return key == null ? 0: key.hashCode() % nodes.length;
    }

    private void resizeNodes(){
        NodeOverrided<K, V>[] newNodes = new NodeOverrided[nodes.length * 2];
        //newNodes.clone(nodes);
        System.arraycopy(nodes, 0, newNodes, 0, nodes.length) ;
        nodes = newNodes;
        setThreshold();
    }


    public void putOverrided(K key, V value){
        int bucketNumber = getBucket(key);
        NodeOverrided node = findNode(key);
        if(nodes[bucketNumber] == null)
            nodes[bucketNumber] = new NodeOverrided(key, value, null);
        else {
            node.value = value;
            return;
        }
        nodes[bucketNumber] = new NodeOverrided<>(key, value, null);
        if (++size > threshold){
            resizeNodes();
        }
    }

    public V getOverrided(K key){
        int bucketNumber = getBucket(key);
        NodeOverrided<K ,V> node = findNode(key);
        if(node != null){
            return node.value;
        }
        return null;
    }

    public boolean containsKey(K key){
        NodeOverrided<K, V> node = findNode(key);
        if(node != null)
        {
            return true;
        }
        return false;
    }
    public boolean containsValue(V value){
        for (NodeOverrided<K, V> node : nodes) {
            if(node != null && value != null){
                if(value == node.value) return true;
            }
            //while(node.next != null)
            for (; node.next != null; node = node.next){
                if(node.value == value) return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public void setThreshold() {
        this.threshold = (int)(nodes.length * coefficient);
    }
    private NodeOverrided<K, V> findNode(K key){
        int bucket = getBucket(key);
        if(nodes[bucket] != null){
            NodeOverrided<K, V> node = nodes[bucket];
            if (node.next != null) {
                for (NodeOverrided element = node; node.next != null; element = node.next) {
                    if (element.key.equals(key)) {
                        return element;
                    }
                }
            }
            else{
                if (node.key.equals(key)) {
                    return node;
                }
            }
        }
        return null;
    }
}
