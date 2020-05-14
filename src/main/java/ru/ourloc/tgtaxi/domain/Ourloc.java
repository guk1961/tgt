package ru.ourloc.tgtaxi.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Ourloc {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 
	 private String tgmessage;
	 @Transient
	 private Date doper;
	 
	 public Ourloc() {}
	 public Ourloc(String tgmessage) {
		 this.tgmessage = tgmessage;
	 }
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTgmessage() {
		return tgmessage;
	}
	public void setTgmessage(String tgmessage) {
		this.tgmessage = tgmessage;
	}
	public Date getDoper() {
		return doper;
	}
	public void setDoper(Date doper) {
		this.doper = doper;
	}
	 

}
