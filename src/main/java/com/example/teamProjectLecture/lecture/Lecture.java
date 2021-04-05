package com.example.teamProjectLecture.lecture;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.teamProjectLecture.lecture.stuff.Stuff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// ORM(Object Relational Mapping)
// 프로그래밍 객체 - 데이터베이스 객체(테이블)
// Entity(SE) - 데이터를 처리하는(저장하는) 객체
// object(SE) - entity(데이터), controller(제어), boundary(경계)
// 테이블명: feed

@Data @Builder @AllArgsConstructor @NoArgsConstructor @Entity 
public class Lecture {
	
	// @Id: PK(primary key)
	// @GeneratedValue: 값 생성 방식
	// strategy = GenerationType.IDENTITY: auto_increment	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int length;

	
	// varchar(255)
	@Column(columnDefinition = "TEXT") // TEXT
	private String title;
	private String summary;
	private String videoSrc;
	private String imageSrc;
	private String category;


// TTTTTTTTTTTTTTTTTTTT
	
	
	
// 데이터 형태 변경 고려중
	@OneToMany
	@JoinColumn(name="lectureId")
	private List<Stuff> stuffs;
}
