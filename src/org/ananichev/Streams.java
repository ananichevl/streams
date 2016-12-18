package org.ananichev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by leonid on 12/18/16.
 */
public class Streams<T> {
    private List<T> list;

    public Streams(List<T> list) {
        this.list = new ArrayList<>(list);
    }

    public static<T> Streams<T> of(List<T> list){
        return new Streams(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate){
        list.removeIf(predicate.negate());
        return this;
    }

    public<R> Streams<T> transform(Transform<? super T, R> transform){
        List<R> copy = new ArrayList<>();
        for(T el : list){
            copy.add(transform.transform(el));
        }
        return this;
    }

    public<K, V> Map<K, V> toMap(MapGetKey<T, K> getKey, MapGetValue<T, V> getValue){
        Map<K, V> map = new HashMap<>();
        for(T t : list){
            map.put(getKey.getKey(t), getValue.getValue(t));
        }
        return map;
    }

}
