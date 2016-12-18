package org.ananichev;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by leonid on 12/18/16.
 */
public class StreamsTest {

    @Test
    public void testToMap() {
        Person p1 = new Person(22, "Alex");
        Person p2 = new Person(24, "Tom");
        Person p3 = new Person(25, "Bob");
        Person p4 = new Person(14, "Kate");

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Map m  = Streams.of(list).filter(person -> person.getAge() > 20).transform(person -> new Person(person.getAge() + 30, person.getName())).toMap(Person::getName, p -> p);
        Map<String, Person> expected = new HashMap<>();
        expected.put("Alex", p1);
        expected.put("Tom", p2);
        expected.put("Bob", p3);
        assertEquals(expected, m);
    }
}
