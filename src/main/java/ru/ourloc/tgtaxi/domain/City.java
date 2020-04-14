package ru.ourloc.tgtaxi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	
	@Id
	private Long id;
	private String name;
	private String lat;
	private String lng;
	
	
	
	public City() {}

		public City(String name, String lat, String lng) {
		this.name = name;
		this.lat = lat;
		this.lng = lng;
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	

}
