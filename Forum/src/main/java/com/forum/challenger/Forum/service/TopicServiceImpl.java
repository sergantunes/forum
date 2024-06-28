package com.forum.challenger.Forum.service;

import com.forum.challenger.Forum.DTOs.TopicDTO;
import com.forum.challenger.Forum.model.Topic;
import com.forum.challenger.Forum.repository.TopicRepository;
import com.forum.challenger.Forum.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Override
    public Topic createTopic(TopicDTO topicDTO, String username) {
        return null;
    }

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic createdTopic(TopicDTO topicDTO, String username) {
        User author = userRepository.findByUsername(username);
        if(author == null) {
            throw new RuntimeException("User not found");
        }
        Topic topic = new Topic();
        topic.setTitle(topicDTO.getTitle());

        topic.setCourseName(topicDTO.getCourseName());
        topic.setMessage(topicDTO.getMessage());
        topic.setCreatedAt(LocalDateTime.now());
        topic.setAuthor((com.forum.challenger.Forum.model.User) author);

        return topicRepository.save(topic);
    }

    @Override
    public Topic updateTopic(Long id, TopicDTO updatedTopicDTO) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isEmpty()) {
            throw new RuntimeException("Topic not found");
        }

        Topic topic = optionalTopic.get();
        topic.setTitle(updatedTopicDTO.getTitle());
        topic.setCourseName(updatedTopicDTO.getCourseName());
        topic.setMessage(updatedTopicDTO.getMessage());

        return topicRepository.save(topic);
    }

    @Override
    public boolean deleteTopic(Long id) {
        if (!topicRepository.existsById(id)) {
            return false;
        }
        topicRepository.deleteById(id);
        return true;
    }

}
