/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    return function(x) {
        let result = x;
        for (let i = functions.length - 1; i >= 0; i--) {
            result = functions[i](result);
        }
        return result;
    }
};

/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let count = n -1;
    return function() {
        count++;
        return count;
    };
};

/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    return {
        toBe: (any) => {
            if(any !== val) throw new Error ("Not Equal");
            return val === any;
        },
        notToBe: (any) => {
            if(any === val) throw new Error("Equal");
            return val !== any;
        }
    };
};

/**
 * @param {number} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter2 = function(init) {
    let count = init;
    return {
        increment: () => { return ++count;},
        reset: () => { return count = init;},
        decrement: () => { return --count;}
    };
};

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    for(i=0; i<arr.length ; i++){
        arr[i] = fn(arr[i], i)
    }
    return arr;
};

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const result = [];
    let i = 0;
    let j = 0;
    while (i < arr.length) {
        if (fn(arr[i], i)) {
            result[j] = arr[i];
            j++;
        }
        i++;
    }
    return result;
};

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let acc = init;
    for (let i = 0; i < nums.length; i++) {
        acc = fn(acc, nums[i]);
    }
    return acc;
};

/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    return function(x) {
        let result = x;
        for (let i = functions.length - 1; i >= 0; i--) {
            result = functions[i](result);
        }
        return result;
    }
};

/**
 * @return {number}
 */
var argumentsLength = function(...args) {
    return args.length
};

/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    let called = false;
    return function(...args){
        if (!called) {
            called = true;
            return fn(...args)
        } else return undefined
    }
};

/**
 * @param {Function} fn
 */
function memoize(fn) {
    const map = new Map();
    return function(...args) {
        const key = args.join("-")
        if (map.has(key)) {
            return map.get(key);
        } else {
            const result = fn(...args);
            map.set(key, result);
            return result;
        }
    }
}

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    return await promise1 + await promise2;
};

/**
 * @param {number} millis
 */
async function sleep(millis) {
    await new Promise(r => setTimeout(r, millis));
}

/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    const callTime = setTimeout(() => fn.apply(null, args), t);
    const cancelFn = function() {
        clearTimeout(callTime);
    };

    return cancelFn;
};

/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    fn(...args)
    const id = setInterval(() => {fn(...args)}, t)
    const cancelFun = function () {
        clearInterval(id);
    };
    return cancelFun;
};

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    return async function(...args) {
        return new Promise(async (resolve, reject) => {
            const id = setTimeout(() => { reject("Time Limit Exceeded");}, t);
            try {
                resolve(await fn(...args))
            } catch(e) {
                reject(e)
            }

        });
    }
};
// ----------------TimeLimitedCache------------------
var TimeLimitedCache = function() {
    this.map = new Map();
};

/**
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const inCache = this.map.get(key);
    if (inCache) {
        clearTimeout(inCache.timeout);
    }
    const timeout = setTimeout(() => this.map.delete(key), duration);
    this.map.set(key, { value, timeout });
    return Boolean(inCache);
};

/**
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    return this.map.has(key) ? this.map.get(key).value : -1;
};

/**
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return this.map.size;
};
// ----------------------------------

/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let id = null;
    return function(...args) {
        clearTimeout(id);
        id = setTimeout(() => fn(...args), t)
    }
};

/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        let results = [];
        let count = 0;

        if (functions.length == 0) {
            resolve(results);
        }

        for (let i = 0; i < functions.length; i ++) {
            functions[i]()
                .then((r) => {
                    results[i] = r;
                    count++;
                    if (count == functions.length) {
                        resolve(results);
                    }
                })
                .catch((error) => {
                    reject(error);
                });
        }
    });
};
/**
 * @param {Object | Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    return !Object.keys(obj).length
};

/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    const results = [];
    let i = 0;
    while (i < arr.length) {
        const newArray = []
        let j = 0;
        while (j < size && i < arr.length) {
            newArray[j] = arr[i]
            i++;
            j++;
        }
        results.push(newArray);
        j++;
    }
    return results;
};

Array.prototype.last = function() {
    return this.length ? this[this.length - 1] : -1;
};

/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function(fn) {
    const result = {};
    for(let i = 0; i < this.length; i++) {
        const key = fn(this[i])
        if (result[key]) {
            result[key].push(this[i])
        } else {
            result[key] = [this[i]]
        }
    }
    return result
};

/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function(arr, fn) {
    return arr.sort((a,b) => fn(a) - fn(b))
};

/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const all = arr1.concat(arr2);
    const obj = {};
    all.forEach(el => {
        if (!obj[el.id]) {
            obj[el.id] = el;
            return;
        }
        Object.assign(obj[el.id], el)
    });

    return Object.values(obj);
};