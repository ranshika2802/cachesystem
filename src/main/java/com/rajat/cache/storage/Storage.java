package com.rajat.cache.storage;

public interface Storage<Key, Value> {
  void put(Key key, Value value); //Store data into cache
  Value get(Key key); //Retrieve data from cache
  void remove(Key keyToRemove);
}
