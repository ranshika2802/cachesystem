package com.rajat.exceptions;

public class StorageFullException extends CacheSystemException {
  public StorageFullException(String s) {
    super(s);
  }
}
