package com.forum.challenger.Forum.controller;

import com.forum.challenger.Forum.DTOs.TopicDTO;
import com.forum.challenger.Forum.model.Topic;
import com.forum.challenger.Forum.service.TopicService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody TopicDTO topicDTO, Authentication authentication){
        String username = authentication.getDeclaringClass().getName();
        Topic topic = topicService.createTopic(topicDTO, username);
        return ResponseEntity.ok(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody TopicDTO updateTopicDTO){
        Topic updateTopic = topicService.updateTopic(id, updateTopicDTO);
        return ResponseEntity.ok(updateTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        boolean deleted = topicService.deleteTopic(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return  ResponseEntity.notFound().build();
        }
    }
}
