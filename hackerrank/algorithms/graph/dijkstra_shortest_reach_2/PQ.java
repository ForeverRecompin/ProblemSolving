import java.io.*;
import java.util.*;

public class PQ {
    public static void main(String[] args) {
	Comparator<Person> c = (o1, o2) -> ((Integer)o1.getAge()).compareTo(((Integer)o2.getAge()));
	Queue<Person> q = new PriorityQueue<>(c);
	q.offer(new Person("Ann", 18));
	q.offer(new Person("Bob", 17));
	q.offer(new Person("Sam", 16));
	q.offer(new Person("Ed", 15));
	q.offer(new Person("Ted", 10));
	while (!q.isEmpty()) {
	    Person p = q.poll();
	    System.out.println(p);
	}
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, int age) {
	this.name = name;
	this.age = age;
    }

    @Override
    public String toString() {
	return "(" + name + ", " + age + ")";
    }

    public String getName() {
	return name;
    }

    public int getAge() {
	return age;
    }
    
}
