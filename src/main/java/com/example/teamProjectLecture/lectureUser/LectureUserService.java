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
	
	public void sendSubscribe(LectureUser user) {
		System.out.println("---- Sending Subscribe ----");
		System.out.println(user);
		
		try {
			rabbit.convertAndSend("lecture.subscribe",user);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void sendUnSubscribe(long lectureId) {
		System.out.println("---- Sending unSubscribe ----");
		
		try {
			rabbit.convertAndSend("lecture.unsubscribe",lectureId);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
