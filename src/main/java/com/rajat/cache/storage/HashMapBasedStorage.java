package com.rajat.cache.storage;

import com.rajat.exceptions.KeyNotFoundException;
import com.rajat.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{

  private Map<Key, Value> cache;
  private final Integer capacity;

  public HashMapBasedStorage(Integer capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
  }
  @Override
  public void put(Key key, Value value) {
    if(isStorageFull()) throw new StorageFullException("Storage is full.");
    cache.put(key, value);
  }

  private boolean isStorageFull() {
    return this.capacity == cache.size();
  }

  @Override
  public Value get(Key key) {
    if(!cache.containsKey(key)) throw new KeyNotFoundException(key + " not found in cache.");
    return cache.get(key);
  }

  @Override
  public void remove(Key keyToRemove) {
    if(!cache.containsKey(keyToRemove)) throw  new KeyNotFoundException(keyToRemove + " not found in cache.");
    cache.remove(keyToRemove);
  }
}
