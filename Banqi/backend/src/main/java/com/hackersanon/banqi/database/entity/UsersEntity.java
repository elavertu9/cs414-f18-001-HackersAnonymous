package com.hackersanon.banqi.database.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User") public class UsersEntity
{
	private String firstName;
	private String lastName;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Basic @Column(name = "firstName", nullable = true, length = 20) public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	@Basic @Column(name = "lastName", nullable = true, length = 20) public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	@Id @Column(name = "id", nullable = false) public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	@Override public boolean equals(Object o)
	{
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		UsersEntity that = (UsersEntity) o;
		
		if (id != that.id) {
			return false;
		}
		if (!Objects.equals(firstName, that.firstName)) {
			return false;
		}
		if (!Objects.equals(lastName, that.lastName)) {
			return false;
		}
		
		return true;
	}
	
	@Override public int hashCode()
	{
		int result = firstName != null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + id;
		return result;
	}
}
