package com.example.teamProjectLecture.lectureUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.teamProjectLecture.lectureUser.LectureUser;
import com.example.teamProjectLecture.lectureUser.LectureUserRepository;


public class LectureUserController {
	
	private LectureUserRepository lectureUserRepo;
	
	@Autowired
	public LectureUserController(LectureUserRepository lectureUserRepo) {
		this.lectureUserRepo = lectureUserRepo;
	}


	@RequestMapping(value="lecture-users", method=RequestMethod.POST)
	public LectureUser subscribe(@RequestBody LectureUser lectureUser) {

		System.out.println(lectureUser);
		lectureUserRepo.save(lectureUser);
		
		System.out.println("LectureUser Saving");
		return lectureUser;
	}
	
	
}
