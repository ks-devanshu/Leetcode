class MyHashMap {
    
    private int[] map;

    public MyHashMap() {
        map = new int[(10*10*10*10*10*10)+1];
    }
    
    public void put(int key, int value) {
        map[key] = value+1;
    }
    
    public int get(int key) {
        return map[key]-1;
    }
    
    public void remove(int key) {
        map[key] = 0;
    }
}
