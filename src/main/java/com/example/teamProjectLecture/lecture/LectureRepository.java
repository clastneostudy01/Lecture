package com.example.teamProjectLecture.lecture;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository: entity를 처리하는 객체
@Repository
public interface LectureRepository
	
	// <entity타입, id타입>
	extends JpaRepository<Lecture, Long> {
		
		// findByName
		// find: select ... from .. 
		// ByName: where name = ?1(매개변수값)
		// select ... from feed WHERE name = ?1;
		
		/* https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html */
		/* 2.3.2 Query creation */
		
		public List<Lecture> findbyId(long id);
		public List<Lecture> getList(Pageable pageable);
	
		// 연관강의 검색, 고민
		// public List<Lecture> findRelatedLectureByStuff(stuff.id String);
}
