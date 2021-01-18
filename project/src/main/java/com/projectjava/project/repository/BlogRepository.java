package com.projectjava.project.repository;

import com.projectjava.project.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("SELECT b FROM Blog b WHERE b.id = ?1")
    public Blog findById(String id);
}
