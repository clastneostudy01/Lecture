package com.example.teamProjectLecture.lectureUser;

import java.awt.SystemColor;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamProjectLecture.lecture.Lecture;
import com.example.teamProjectLecture.lecture.LectureRepository;
import com.example.teamProjectLecture.lectureUser.LectureUser;
import com.example.teamProjectLecture.lectureUser.LectureUserRepository;

@RestController
public class LectureUserController {
	
	private LectureUserRepository lectureUserRepo;
	private LectureRepository lectureRepo;
	
	@Autowired
	public LectureUserController(LectureUserRepository lectureUserRepo, LectureRepository lectureRepo) {
		this.lectureUserRepo = lectureUserRepo;
		this.lectureRepo = lectureRepo;
	}

//	쓸 일 없지?
//	@RequestMapping(value="/lecture-users", method=RequestMethod.GET)
//	public List<LectureUser> getLectureUsers(HttpServletRequest req){
//		
//		List<LectureUser> list = lectureUserRepo.findAll(Sort.by("id").descending());		
//		return list;
//	}
	
	
	@RequestMapping(value="/lecture-users/{lectureId}", method=RequestMethod.POST)
	public LectureUser subscribe(@PathVariable("lectureId") long lectureId, @RequestBody LectureUser lectureUser, HttpServletResponse res) {
		// 임시 데이터
		long userId = 1;
		
		if(lectureUserRepo.findByLectureIdAndUserId(lectureId, userId) != (null)) {
			System.out.println("이미 구독한 강의");
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		Lecture lecture = lectureRepo.findById(lectureId);
		lectureUser.setUserId(userId);
		lectureUser.setLectureId(lectureId);
		lectureUser.setLectureTitle(lecture.getTitle());
		lectureUser.setLectureSummary(lecture.getSummary());
		lectureUser.setLectureImageSRC(lecture.getImageSRC());
		lectureUser.setSubscribedTime(new Date().getTime());
		
		System.out.println(lectureUser);
		lectureUserRepo.save(lectureUser);
		
		System.out.println("LectureUser Saving");
		return lectureUser;
	}
	
	@RequestMapping(value="/lecture-users/subscribed", method=RequestMethod.GET)
	public List<LectureUser> getLectureUserListPaging(HttpServletRequest req){
		List <LectureUser> list = lectureUserRepo.findAll(Sort.by("id"));
		return list;
	}
	
	
	@RequestMapping(value="/lecture-users/{id}", method=RequestMethod.DELETE)
	public boolean unSubscribe(@PathVariable("id") long id, HttpServletResponse res) {
		System.out.println(id);
		
		LectureUser lectureUser = lectureUserRepo.findByLectureId(id);
		
		if(lectureUser == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		lectureUserRepo.deleteById(id);
		return true;
	}
	
	
	
	
}
