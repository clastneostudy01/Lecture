package com.example.teamProjectLecture.lecture.stuff;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuffController {

	private StuffRepository stuffRepo;
	
	@Autowired
	public StuffController(StuffRepository stuffRepo) {
		this.stuffRepo = stuffRepo;
	}
	
	@RequestMapping(value = "/stuffs", method = RequestMethod.POST)
	public Stuff addStuff(@RequestBody Stuff stuff) {
		
		Stuff stuffE = new Stuff();
		
		stuffE.setLectureId(stuff.getLectureId());
		stuffE.setName(stuff.getName());
		stuffE.setQuantity(stuff.getQuantity());
		stuffE.setUnit(stuff.getUnit());
		
		stuffRepo.save(stuff);
		return stuff;
	}
	
	@RequestMapping(value = "/stuffs/{lectureId}", method = RequestMethod.GET)
	public List<Stuff> stuffList(@PathVariable("lectureId") long lectureId, HttpServletResponse res){
		
		List<Stuff> list = stuffRepo.findByLectureId(lectureId);

		if (list == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return list;
	}
	
}
