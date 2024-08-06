package com.erdiagram.mapping.repository;

import com.erdiagram.mapping.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}