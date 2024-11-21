package com.sr;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<tb, Integer> {
	
	public Optional<tb> findByName(String name);
	

}
