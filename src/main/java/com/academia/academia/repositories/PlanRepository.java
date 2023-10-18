package com.academia.academia.repositories;

import com.academia.academia.models.PlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanModel, Integer> {
}
