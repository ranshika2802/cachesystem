package com.rajat.exceptions;

public class KeyNotFoundException extends CacheSystemException {
  public KeyNotFoundException(String s) {
    super(s);
  }
}
