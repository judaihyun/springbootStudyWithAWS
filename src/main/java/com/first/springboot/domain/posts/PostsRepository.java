package com.first.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query(value = "SELECT * FROM Posts ORDER BY id DESC", nativeQuery = true)
    //@Query(value = "SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
