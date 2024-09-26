package com.rajat.cache;

import com.rajat.cache.storage.Storage;
import com.rajat.cache.evictionpolicy.EvictionPolicy;
import com.rajat.exceptions.KeyNotFoundException;
import com.rajat.exceptions.StorageFullException;

public class Cache<Key, Value> {

  private Storage<Key, Value> storage;
  private EvictionPolicy<Key> evictionPolicy;

  public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
    this.storage = storage;
    this.evictionPolicy = evictionPolicy;
  }
  
  public void put(Key key, Value value) {
    try {
      this.storage.put(key, value);
      this.evictionPolicy.keyAccessed(key);
    } catch (StorageFullException sfe) {
      System.out.println("Storage Full.. Will try to evict");
      Key keyToRemove = this.evictionPolicy.evictKey();
      if(keyToRemove == null) throw new RuntimeException("Unexpected state..Storage full but not evicting..");
      this.storage.remove(keyToRemove);
      System.out.println("Creating space by evicting item.."+keyToRemove);
      this.storage.put(key, value);
    }
  }

  public Value get(Key key) {
    try {
      Value value = this.storage.get(key);
      this.evictionPolicy.keyAccessed(key);
      return value;
    } catch (KeyNotFoundException keyNotFoundException) {
      System.out.println("Tried to access non-existing key.");
      return null;
    }
  }
}
