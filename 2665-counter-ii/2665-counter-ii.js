/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let currentValue = init;

    return new Proxy({}, {
        get: (target, key) => {
            if (key == "increment") return () => ++currentValue;
            if (key == "reset") return () => (currentValue = init);
            if (key == "decrement") return () => --currentValue;
        }
    })
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */

