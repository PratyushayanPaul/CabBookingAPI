package com.tcs.api.CabBookingAPI.repository;

import com.tcs.api.CabBookingAPI.entity.FareEstimation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareEstimationRepository extends JpaRepository<FareEstimation, Integer> {
    FareEstimation getFareEstimationBySourceAndDestination(String source, String destination);
}
