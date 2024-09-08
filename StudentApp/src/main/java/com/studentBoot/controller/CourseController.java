package com.studentBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentBoot.entity.CourseEntity;
import com.studentBoot.exceptions.ApiResponce;
import com.studentBoot.service.CourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/course")
@CrossOrigin("*") // enables cross-origin resource sharing only for this specific method.
@Api(value="product-controller",description="This controller contains the functionality of viewing, adding, updating and deleting the product.")

public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@PostMapping("/")
	@ApiOperation(value="This functionality is used to add the product.",notes="You can add the product from here",response=CourseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<CourseEntity> addCourse(@RequestBody CourseEntity course){
		CourseEntity addedCourse = this.courseService.addCourse(course);
		return new ResponseEntity<CourseEntity>(addedCourse,HttpStatus.CREATED);
	}
	//Get all courses a student is enrolled in
	@GetMapping("/student/{studentId}")
	@ApiOperation(value="This functionality is used to get all list of the product booked by user.",notes="You can see how many products booked by user",response=CourseEntity.class)
    @ApiResponses(value = {
		@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
        }
)
	public ResponseEntity<List<CourseEntity>> getAllCoursesEnrolledByStudent(@PathVariable int studentId){
		List<CourseEntity> coursesEnrolledByStudentId = this.courseService.getCoursesEnrolledByStudentId(studentId);
		return new ResponseEntity<List<CourseEntity>>(coursesEnrolledByStudentId,HttpStatus.OK);
	}
	
	//Get all the  courses
	@GetMapping("/")
	@ApiOperation(value="This functionality is used to get all list of the product.",notes="You can see how many products are available from here",response=CourseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<List<CourseEntity>> getAllCourseList(){
		List<CourseEntity> allCourses = this .courseService.getAllCourses();
		return new ResponseEntity<List<CourseEntity>>(allCourses,HttpStatus.OK);
	}
	
	//Get Course by ID
	@GetMapping("/{courseId}")
	@ApiOperation(value="This functionality is used to get the product from Id.",notes="You can see the products from here by Id",response=CourseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<CourseEntity> getCourseById(@PathVariable("courseId") int courseId) {
		CourseEntity getcoursebyId = this.courseService.getCourseById(courseId);
		return new ResponseEntity<CourseEntity>(getcoursebyId,HttpStatus.OK);
		
	}
	
	@PutMapping("/{courseId}")
	@ApiOperation(value="This functionality is used to update the product By Id.",notes="You can update the product from here",response=CourseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<CourseEntity> updateCourse(@RequestBody CourseEntity course, @PathVariable("courseId") int courseId){
		CourseEntity updatedCourse = this.courseService.updateCourseById(course, courseId);
		return new ResponseEntity<CourseEntity>(updatedCourse,HttpStatus.OK);
	}
	
	@DeleteMapping("/{courseId}")
	@ApiOperation(value="This functionality is used to delete the product by Id.",notes="You can delete the product from here",response=CourseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<ApiResponce> deleteCourseById(@PathVariable("courseId") int courseId){
		this.courseService.deleteCourse(courseId);
		ApiResponce response=new ApiResponce();
		response.setMessage("Course Record is deleted successfully with course id: "+courseId);
		response.setStatus(true);
		return new ResponseEntity<ApiResponce>(response,HttpStatus.OK);
		
	}
	
	

}
