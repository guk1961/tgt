package ru.ourloc.tgtaxi.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "group")
public class Group {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id")
	private City city;
	
	@NotBlank(message = "Название группы не может быть пустым")
    private String name;
	private String lat;
	private String lng;
	private String description;
	
	
	public Group(City city, @NotBlank(message = "Название группы не может быть пустым") String name,
				 String lat, String lng, String description) {
		
		this.city = city;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.description = description;
	}
	public Group(){		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
