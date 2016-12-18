package org.ananichev;

/**
 * Created by leonid on 12/18/16.
 */
public interface Transform<T, R> {
    R transform(T t);
}
