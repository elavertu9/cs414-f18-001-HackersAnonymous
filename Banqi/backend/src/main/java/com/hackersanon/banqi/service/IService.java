package com.hackersanon.banqi.service;

import com.hackersanon.banqi.model.ModelBase;

public interface IService<T extends ModelBase>
{
	T findById(Long Id);
}
