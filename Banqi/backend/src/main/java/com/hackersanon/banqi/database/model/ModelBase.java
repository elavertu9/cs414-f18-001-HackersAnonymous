package com.hackersanon.banqi.database.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public class ModelBase implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false, insertable = false)
	private Long id;


	@Temporal(TemporalType.DATE)
	@Column
	private Date timestamp = new Date();

	public Long getId() {
		return id;
	}


	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
