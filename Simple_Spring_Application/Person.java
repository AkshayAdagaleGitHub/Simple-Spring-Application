package com.spring.app.ws.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private final UUID id;
	private String name;
	
	public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UUID getId() {
		return id;
	}
	
}
