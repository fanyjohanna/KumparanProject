package com.kumparan.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.kumparan.api.model.Topic;
import com.kumparan.api.repository.TopicRepository;
import com.kumparan.api.service.TopicService;

@RestController
@RequestMapping("/api/topic")
public class TopicController {
	@Autowired
	TopicService ts;
	
	@Autowired
	TopicRepository nr;
	
	//get all news
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Topic>> listAllTopics(){
        List<Topic> topic_list = ts.findAllTopic();
        if (topic_list.isEmpty()) {
            return new ResponseEntity<List<Topic>>(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Topic>>(topic_list, HttpStatus.OK);
    }

	//get news by id
	@GetMapping("/{id}")
	public Topic retrieveTopic(@PathVariable int id) {
		Optional<Topic> topic = ts.findById(id);
		return topic.get();
	}
	
	//get news by status
	
	//create news
	@PostMapping("/createtopic")
	@ResponseBody
	public ResponseEntity<Object> createTopic(@RequestBody Topic topic) {
		Topic savedTopic = nr.save(topic);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTopic.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	//update topic
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateNews(@RequestBody Topic topic, @PathVariable int id) {
		Optional<Topic> newsOptional = nr.findById(id);
		if (!newsOptional.isPresent())
			return ResponseEntity.notFound().build();
		topic.setId(id);
		nr.save(topic);
		return ResponseEntity.noContent().build();
	}
	
	//delete topic
	@DeleteMapping("/{id}")
	public void deleteTopic(@PathVariable int id) {
		nr.deleteById(id);
	}
	

}
