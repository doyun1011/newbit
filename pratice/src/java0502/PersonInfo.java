package java0502;

import java.io.Serializable;

public class PersonInfo implements Serializable{

	String name;
	String city;
	int age;
	
	public PersonInfo(String name, String city, int age) {
		this.name = name;
		this.city = city;
		this.age = age;
	}
	
	public String toString() {
		return name + " : " + city + " : " + age;
	}
}
