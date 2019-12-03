package com.hackersanon.banqi.database.model;

import com.hackersanon.banqi.board.BanqiBoard;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@TypeDef(name = "banqiboard",
		defaultForType = BanqiBoard.class,
		typeClass = BanqiBoard.class)
public class Game extends ModelBase
{
	@ManyToOne
	private Board banqiboard;
	
	private Long playerOneId;
	private Long playerTwoId;
	@Id private Long id;
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getId()
	{
		return id;
	}
}
