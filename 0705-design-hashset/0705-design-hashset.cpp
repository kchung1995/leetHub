class MyHashSet {
private:
    int MAX_SIZE = 1000001;
vector<bool> keySet;
public:
    MyHashSet() : keySet(MAX_SIZE) {
    }
    
    void add(int key) {
        keySet[key] = true;
    }
    
    void remove(int key) {
        keySet[key] = false;
    }
    
    bool contains(int key) {
        return keySet[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */

