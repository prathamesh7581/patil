package com.erdiagram.mapping.repository;

import com.erdiagram.mapping.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}