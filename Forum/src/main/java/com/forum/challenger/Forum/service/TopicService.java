package com.forum.challenger.Forum.service;

import com.forum.challenger.Forum.DTOs.TopicDTO;
import com.forum.challenger.Forum.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopics();
    Topic createTopic(TopicDTO topicDTO, String username);
    Topic updateTopic(Long id, TopicDTO updateTopicDTO);

    boolean deleteTopic(Long id);

    Topic createdTopic(TopicDTO topicDTO, String username);
}
