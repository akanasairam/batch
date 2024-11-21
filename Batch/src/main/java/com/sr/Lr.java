package com.sr;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Lr extends JpaRepository<Ledger, Integer> {
	
	public Optional<Ledger> findByName(String name);

}
