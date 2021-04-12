package com.example.teamProjectLecture.lectureUser;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureUserService {
	
	private RabbitTemplate rabbit;
	
	@Autowired
	public LectureUserService(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}
	
	public void setSubscribe(LectureUser lectureUser) {
		System.out.println("---- Sending Subscribe ----");
		System.out.println(lectureUser);
		
		try {
			rabbit.convertAndSend("lecture.subscribe",lectureUser);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setUnSubscribe(LectureUser lectureUser) {
		System.out.println("---- Sending unSubscribe ----");
		
		try {
			rabbit.convertAndSend("lecture.unsubscribe", lectureUser);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
