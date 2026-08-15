class MyHashSet {
    
    boolean[] set;

    public MyHashSet() {
        set = new boolean[10*10*10*10*10*10];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}
