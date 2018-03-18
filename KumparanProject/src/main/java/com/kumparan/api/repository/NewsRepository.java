package com.kumparan.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumparan.api.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

	Optional<News> findByStatus(String status);

}
