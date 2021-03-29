package com.example.teamProjectLecture.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.teamProjectLecture.configuration.ApiConfiguration;


@RestController
public class LectureController {
	
	private LectureRepository lectureRepo;
	
	
	
//	@Autowired
//	private ApiConfiguration apiConfig;
	
	@Autowired
	public LectureController(LectureRepository lectureRepo) {
		this.lectureRepo = lectureRepo;
	}
	
	
	
	
	// 프론트엔드 통신
	@RequestMapping(value="/lectures", method=RequestMethod.GET)
	public List<Lecture> getLectureList(HttpServletRequest req){
		List<Lecture> list = lectureRepo.findAll(Sort.by("id").descending());
		return list;
	}
	
	
	@RequestMapping(value="/lectures/{id}", method=RequestMethod.GET)
	public Lecture getLectureDetail(@PathVariable("id") long id, HttpServletResponse res) {
		Lecture lecture = lectureRepo.findById(id).orElse(null);
		
		if(lecture == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		return lecture;
	}
	
//	@RequestMapping(value="/lectures/search/category", method=RequestMethod.GET)
//	public List<Lecture> getLecturesByName(@RequestParam("keyword") String keyword){
//		
//		
//		// for문으로 텍스트 단어단위로 끊어서 검색어 처리
//		return lectureRepo.findBy(keyword);
//	}

	
}
