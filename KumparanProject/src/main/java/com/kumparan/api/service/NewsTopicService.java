package com.kumparan.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kumparan.api.model.NewsTopic;
import com.kumparan.api.repository.NewsTopicRepository;

@Service
public class NewsTopicService {

	
	@Autowired
	private NewsTopicRepository ntr;
	
	public List<NewsTopic> findAllNewsTopic(){
		return ntr.findAll();
	}
}
