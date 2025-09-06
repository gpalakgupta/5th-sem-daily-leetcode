class MyHashSet {
    List<Integer>  lt = new ArrayList<>();
    public MyHashSet() {   
    }
    
    public void add(int key) {
        if(lt.contains(key)){
            return;
        }
        lt.add(key); 
    }
    
    public void remove(int key) {
        if(lt.contains(key)) {
            lt.remove(Integer.valueOf(key));
        }  
    }
    
    public boolean contains(int key) {
        return lt.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */