package com.rajat.factories;

import com.rajat.cache.Cache;
import com.rajat.cache.evictionpolicy.LRUEvictionPolicy;
import com.rajat.cache.storage.HashMapBasedStorage;

public class CacheFactory <Key, Value>{

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache(new HashMapBasedStorage<>(capacity),
                new LRUEvictionPolicy<>(capacity)
                );
    }
}
