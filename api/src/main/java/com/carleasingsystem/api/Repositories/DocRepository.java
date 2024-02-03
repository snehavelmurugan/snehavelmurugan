package com.carleasingsystem.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.carleasingsystem.api.Entities.Doc;

@Repository
	public interface DocRepository extends JpaRepository<Doc,Long>
	{

}
