package com.example.teamProjectLecture.lectureUser;

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
public class LectureUser {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long userId;
	private long lectureId;

	// varchar(255)
	@Column(columnDefinition = "TEXT")	// TEXT
	private String lectureTitle;
	private String lectureSummary;
	private String lectureImageSrc;
	
	private long subscribedTime;
//	private long lecturePlayTime;
}
