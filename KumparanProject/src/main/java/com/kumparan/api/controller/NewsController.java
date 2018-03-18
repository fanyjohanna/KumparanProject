package com.kumparan.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kumparan.api.model.News;
import com.kumparan.api.repository.NewsRepository;
import com.kumparan.api.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsController {
	public static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	
	@Autowired
	NewsService ns;
	
	@Autowired
	NewsRepository nr;
	
	//get all news
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<News>> listAllNews(){
        List<News> news_list = ns.findAllNews();
        if (news_list.isEmpty()) {
            return new ResponseEntity<List<News>>(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<News>>(news_list, HttpStatus.OK);
    }

	//get news by id
	@GetMapping("/news/{id}")
	public News retrieveNews(@PathVariable int id) {
		Optional<News> news = nr.findById(id);
		return news.get();
	}
	
	//get news by status
	
	//create news
	@PostMapping("/createnews")
	@ResponseBody
	public ResponseEntity<Object> createStudent(@RequestBody News news) {
		News savedNews = nr.save(news);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedNews.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	//update news
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateNews(@RequestBody News news, @PathVariable int id) {
		Optional<News> newsOptional = nr.findById(id);
		if (!newsOptional.isPresent())
			return ResponseEntity.notFound().build();
		news.setId(id);
		nr.save(news);
		return ResponseEntity.noContent().build();
	}
	
	//delete news
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable int id) {
		nr.deleteById(id);
	}
	

	
	

	
	
	
	
	
	
	


}
