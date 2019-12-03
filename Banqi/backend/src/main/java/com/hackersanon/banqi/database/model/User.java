package com.hackersanon.banqi.database.model;


import javax.persistence.*;

@Entity
public class User extends ModelBase
{
	@Id @Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String password;
}
