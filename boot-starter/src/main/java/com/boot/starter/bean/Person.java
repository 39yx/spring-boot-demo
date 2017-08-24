package com.boot.starter.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = Person.PERSON_PREFIX)
public class Person {
	public static final String PERSON_PREFIX = "personboot.starter";
	private String name;
	private String age;
	
	private PersonChilden children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public PersonChilden getChildren() {
		return children;
	}

	public void setChildren(PersonChilden children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", children=" + children + "]";
	}
}
