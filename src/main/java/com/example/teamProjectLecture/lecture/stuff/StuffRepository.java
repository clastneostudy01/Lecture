package com.example.teamProjectLecture.lecture.stuff;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffRepository

	extends JpaRepository<Stuff, Long> {
	
	public List<Stuff> findByLectureId(long lectureId);
}
