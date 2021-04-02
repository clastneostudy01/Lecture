package com.example.teamProjectLecture.lecture;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/lectures", method = RequestMethod.POST)
	public Lecture addLecture(@RequestBody Lecture lecture) {
		lectureRepo.save(lecture);
		return lecture;
	}

	@RequestMapping(value = "/lectures", method = RequestMethod.GET)
	public List<Lecture> list() {
		List<Lecture> list = lectureRepo.findAll(Sort.by("id"));

//		System.out.println("List 보내는 중");
//		System.out.println(list);
		return list;
	}

	@RequestMapping(value = "/lectures/{id}", method = RequestMethod.GET)
	public Lecture detail(@PathVariable("id") long id, HttpServletResponse res) {
		Lecture lecture = lectureRepo.findById(id);

		if (lecture == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

		return lecture;
	}

	// GET /lectures/search/category?keyword=굽기
	@RequestMapping(value="/lectures/search/category", method=RequestMethod.GET)
	public List<Lecture> findByCategory(@RequestParam("keyword") String keyword){
		
		List<Lecture> list = lectureRepo.findByCategory(keyword);
		return list;
	}

}
