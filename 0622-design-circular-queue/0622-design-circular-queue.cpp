class MyCircularQueue {
    
    int head;
    int currentLength;
    int queue[1000] = {0, };
    int queueSize;
    
public:
    MyCircularQueue(int k) {
        head = 0;
        currentLength = 0;
        queueSize = k;
    }
    
    bool enQueue(int value) {
        if (isFull()) return false;
        queue[(head + currentLength) % queueSize] = value;
        currentLength++;
        return true;
    }
    
    bool deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % queueSize;
        currentLength--;
        return true;
    }
    
    int Front() {
        if (isEmpty()) return -1;
        return queue[head];
    }
    
    int Rear() {
        if (isEmpty()) return -1;
        return queue[(head + currentLength - 1) % queueSize];
    }
    
    bool isEmpty() {
        if (currentLength == 0) return true;
        return false;
    }
    
    bool isFull() {
        if (currentLength == queueSize) return true;
        return false;
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */