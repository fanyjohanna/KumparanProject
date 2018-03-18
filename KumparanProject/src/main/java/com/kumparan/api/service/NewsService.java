package com.kumparan.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumparan.api.model.News;
import com.kumparan.api.repository.NewsRepository;

@Service
public class NewsService {
	
	@Autowired
	private NewsRepository NR;
	
	public List<News> findAllNews(){
		return NR.findAll();
	}

	

}
