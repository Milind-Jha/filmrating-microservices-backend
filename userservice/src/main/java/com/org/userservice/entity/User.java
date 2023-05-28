package com.org.userservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	private String id;
//	public void setId(String id) {
//		this.id = id;
//	}
	private String name;
	private String email;
	private String about;
	@Transient
	private List<Rating> ratings = new ArrayList<>();
	
//	public String getId() {
//		return id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getAbout() {
//		return about;
//	}
//	public void setAbout(String about) {
//		this.about = about;
//	}
//	public List<Rating> getRatings() {
//		return ratings;
//	}
//	public void setRatings(List<Rating> ratings) {
//		this.ratings = ratings;
//	}
	
	
}
