package com.rajat;

import com.rajat.cache.Cache;
import com.rajat.factories.CacheFactory;

public class Main {
    public static void main(String[] args) {
        CacheFactory cacheFactory = new CacheFactory();
        Cache<Integer, String> cache = cacheFactory.defaultCache(4);

        cache.put(1, "abc");
        cache.put(2, "fabc");
        cache.put(3, "afdbc");
        cache.put(1, "rajat");

        cache.put(4, "abgfdc");

        cache.put(5, "abhc");


    }
}