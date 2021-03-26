after all the normal config now its time to start the main coding part:

1.create a package inside the
com.springrest.springrest
-- | -com.springrest.springrest.controller
---- - | -MyController

package com.springrest.springrest.controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	//importthis
	//auto create object
	@Autowired
	private CourseService courseService;
	@GetMapping("/home")
	public String home() {
		return "this is the home page.";
	}

	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourses(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}



}


2.create a new package inside main package
-- - | -com.springrest.springrest.entites
------ | Course.java

package com.springrest.springrest.entites;
public class Course  {
	private long id;
	private String title;
	private String description;



}


Now generate :
1 - generate Consutrcotor using fields;
2 - generate Consutrcotor from super class using fields;
3 - generate setter and getter method
4 - generate toString method







3.Create the interface now.
	| -com.springrest.springrest.services
	| -CourseService.java


	package com.springrest.springrest.services;
import java.util.List;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(long courseId);

}


4.Create class CourseServiceImpl inside 	package com.springrest.springrest.services;
add interface CourseService

	package com.springrest.springrest.services;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
	List<Course> list;
	public CourseServiceImpl() {
		list = new ArrayList();
		list.add(new Course(143, "java", "java description"));
		list.add(new Course(144, "java2", "java2 description"));

	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for (Course course : list ) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}



}





















