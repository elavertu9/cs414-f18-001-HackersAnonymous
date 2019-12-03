package com.hackersanon.banqi.database.dao;

import com.hackersanon.banqi.database.model.ModelBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T extends ModelBase> extends JpaRepository<T, Long>
{

}
