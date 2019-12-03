package com.hackersanon.banqi.database.model;

import com.hackersanon.banqi.board.Square;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Board extends ModelBase
{
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Square> banqiBoard = new ArrayList<>();

	@Id
	private Long id;
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getId()
	{
		return id;
	}
	

	public List<Square> getBoard()
	{
		return banqiBoard;
	}
	
	public void setBoard(ArrayList<Square> board)
	{
		this.banqiBoard = board;
	}
}
