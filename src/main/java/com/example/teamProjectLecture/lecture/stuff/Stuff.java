package com.example.teamProjectLecture.lecture.stuff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor @Entity 
public class Stuff {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long lectureId;
	private long quantity;
	
	@Column(columnDefinition = "TEXT")
	private String name;
	private String unit;
}

