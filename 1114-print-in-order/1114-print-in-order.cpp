#include <mutex>

class Foo {
private:
    mutex mutexes[2];

public:
    Foo() {
        mutexes[0].lock();
        mutexes[1].lock();
    }

    void first(function<void()> printFirst) {
        printFirst();
        mutexes[0].unlock();
    }

    void second(function<void()> printSecond) {
        mutexes[0].lock();
        mutexes[0].unlock();
        printSecond();
        mutexes[1].unlock();
    }

    void third(function<void()> printThird) {
        mutexes[1].lock();
        mutexes[1].unlock();
        printThird();
    }
};
