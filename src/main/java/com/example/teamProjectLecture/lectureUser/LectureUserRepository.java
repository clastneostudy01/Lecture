package com.example.teamProjectLecture.lectureUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface LectureUserRepository

	extends JpaRepository<LectureUser, Long>{

	public LectureUser findByLectureId(long lectureId);
//	public LectureUser findByUserId(long userId);
	public LectureUser findByLectureIdAndUserId(long lectureId, long userId);
	
}