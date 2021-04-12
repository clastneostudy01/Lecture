package com.example.teamProjectLecture.lecture;

import java.util.List;

import com.example.teamProjectLecture.lecture.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// @Repository: entity를 처리하는 객체
@Repository
public interface LectureRepository
	
	// <entity타입, id타입>
	extends JpaRepository<Lecture, Long> {
		
		public Lecture findById(long id);
	
		// findByName
		// find: select ... from .. 
		// ByName: where name = ?1(매개변수값)
		// select ... from feed WHERE name = ?1;
		
		/* https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html */
		/* 2.3.2 Query creation */
	
//		public Page<Lecture> getPagedList(Pageable pageable);
	
	
//		public List<Lecture> findByCategory(String category);
//	
		// 재료 연관강의 검색, 고민
		// public List<Lecture> findRelatedLectureByStuff(String stuff.id);
		
		public List<Lecture> findByCategory(String category);
		
		
//		순정렬 필요없으면 바깥쪽만 지워주면 됨
//		select * from (select * from (select * from lecture where category = "끓이기" and id != "1") as l order by rand() limit 2) as ld order by id;
		@Query(value="select * from (select * from lecture where category = :category and id != :id order by rand() limit 2) as ld order by id", nativeQuery=true)
		List<Lecture> recommandByCategory(@Param("id") long id, @Param("category") String category);
//		https://kogle.tistory.com/22?category=863426
}
