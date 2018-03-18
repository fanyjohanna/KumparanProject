package com.kumparan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumparan.api.model.Topic;
import com.kumparan.api.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository TR;
	
	public List<Topic> findAllTopic(){
		return TR.findAll();
	}

	public Optional<Topic> findById(int id) {
		// TODO Auto-generated method stub
		return TR.findById(id);
	}

}
