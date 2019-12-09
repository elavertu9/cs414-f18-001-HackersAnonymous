package com.hackersanon.banqi.dao;

import com.hackersanon.banqi.model.ModelBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface IBaseRepository<T extends ModelBase, L extends Number> extends JpaRepository<T, Long>
{

}
