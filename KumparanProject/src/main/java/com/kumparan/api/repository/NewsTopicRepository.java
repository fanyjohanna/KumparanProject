package com.kumparan.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumparan.api.model.NewsTopic;

@Repository
public interface NewsTopicRepository extends JpaRepository<NewsTopic, Integer>{

}
