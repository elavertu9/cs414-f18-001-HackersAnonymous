package com.hackersanon.banqi.database.service;

import com.hackersanon.banqi.database.model.ModelBase;

public interface IService<T extends ModelBase>
{
	T findById(Long Id);
}
