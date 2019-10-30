package com.maxi.calendar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
	private int id;
	private String name;
	private String role;
	
	@ManyToMany(mappedBy="user")
	private List<Event> events = new ArrayList<>();
	
	public User() {
		
	}
	
	public User(String name, String role) {
		this.name=name;
		this.role=role;
	}
	
	//getters & setters		
	@Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	
	

}
