package com.example.teamProjectLecture.lectureUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureUserRepository

	extends JpaRepository<LectureUser, Long>{

	public LectureUser findByLectureId(long lectureId);
//	public LectureUser findByUserId(long userId);
	public LectureUser findByLectureIdAndUserId(long lectureId, String userId);
	
	
}