package com.rajat.cache.evictionpolicy;

public interface EvictionPolicy<Key> {
  void keyAccessed(Key key);
  Key evictKey();
}
