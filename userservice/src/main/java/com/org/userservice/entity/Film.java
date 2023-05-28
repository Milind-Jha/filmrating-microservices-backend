package com.org.userservice.entity;

import java.util.Arrays;

public class Film {

	private String id;
	private String name;
	private int collection;
	private String[] cast;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCollection() {
		return collection;
	}
	public void setCollection(int collection) {
		this.collection = collection;
	}
	public String[] getCast() {
		return cast;
	}
	public void setCast(String[] cast) {
		this.cast = cast;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", name=" + name + ", collection=" + collection + ", cast=" + Arrays.toString(cast)
				+ "]";
	}
	
	
}
