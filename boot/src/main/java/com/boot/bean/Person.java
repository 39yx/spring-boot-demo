package com.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person")
public class Person {
	private String name;
	private String age;
	private String nameAge;

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
	
	public String getNameAge() {
		return nameAge;
	}

	public void setNameAge(String nameAge) {
		this.nameAge = nameAge;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nameAge=" + nameAge + "]";
	}
}
