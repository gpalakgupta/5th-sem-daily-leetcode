class MyHashMap {
    private List<Pair>[] bucket;
    private int size = 10000;
    public class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public MyHashMap() {
        bucket = new LinkedList[size];
        for(int i = 0; i<size; i++){
            bucket[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int bucketidx = key % size;
        List<Pair> chain = bucket[bucketidx];
        for(Pair rv : chain){
            if(rv.first == key){
                rv.second = value;
                return;
            }
        } 

        chain.add(new Pair(key,value));

    }
    
    public int get(int key) {
        int bucketidx = key % size;
        List<Pair> chain = bucket[bucketidx];
        for(Pair rv : chain){
            if(rv.first == key){
                return rv.second;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucketidx = key % size;
        List<Pair> chain = bucket[bucketidx];
        for(Pair rv : chain){
            if(rv.first == key){
                chain.remove(rv);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */