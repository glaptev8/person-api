package org.person.service;

public interface MessageSourceService {
  String getMessage(String sourceKey, Object ... objects);
}
