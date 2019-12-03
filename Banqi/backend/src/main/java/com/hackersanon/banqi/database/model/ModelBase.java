package com.hackersanon.banqi.database.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ModelBase implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;
	
	@Version
	@Column(name = "ts")
	private Date timestamp;

	@Id
	public Long getId() {
		return id;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
