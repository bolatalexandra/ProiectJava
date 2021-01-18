package com.projectjava.project.repository;

import com.projectjava.project.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j WHERE j.id = ?1")
    public Job findById(String id);
}
