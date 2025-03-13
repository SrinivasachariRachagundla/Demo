package com.spring.boot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "spring framework", "spring framework description"),
					new Topic("java", "core jave", "core java description"),
					new Topic("javascript", "java script", "java script description"),
					new Topic("javascript1", "java script1", "java script description1")));

	public List<Topic> getAllTopics() {
		return topics;
		/*
		 * List<Topic> topics = new ArrayList<>();
		 * topicRepository.findAll().forEach(topics::add); return topics;
		 */
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

		// return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		// topicRepository.save(topic);
		
		topics.add(topic);

	}

	public void updateTopic(Topic topic) {

		for (int i = 0; i < topics.size(); i++) {

			Topic t = topics.get(i);

			if (t.getId().equals(topic.getId())) {
				topics.set(i, topic);
				return;
			}
		}

		// topicRepository.save(topic);

	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));

		/// topicRepository.delete(id);

	}
}
