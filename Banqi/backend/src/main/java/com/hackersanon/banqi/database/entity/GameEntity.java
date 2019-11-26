package com.hackersanon.banqi.database.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.IOException;

@Entity @Table(name = "game")
public class GameEntity
{
	private int id;
	private String gameObject;
	
	
	@Column(name = "gameObject", columnDefinition = "json")
	public String getGameObject()
	{
		return gameObject;
	}
	
	public void setGameObject(String gameObject)
	{
		this.gameObject = gameObject;
	}
	
	@Id @Column(name = "id", nullable = false)
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		GameEntity that = (GameEntity) o;
		
		if (id != that.id) {
			return false;
		}
		if (gameObject != null ? !gameObject.equals(that.gameObject) : that.gameObject != null) {
			return false;
		}
		
		return true;
	}
	
	@Override public int hashCode()
	{
		int result = gameObject != null ? gameObject.hashCode() : 0;
		result = 31 * result + id;
		return result;
	}
	
	public void serializeGameData() throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		this.gameObject = objectMapper.writeValueAsString(gameObject);
	}
}
