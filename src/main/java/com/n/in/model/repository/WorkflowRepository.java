package com.n.in.model.repository;

import com.n.in.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkflowRepository extends JpaRepository<Workflow, Integer> {
    @Query("SELECT w.id FROM Workflow w WHERE w.enabled = true")
    List<Integer> findIdsByEnabledTrue();
}
