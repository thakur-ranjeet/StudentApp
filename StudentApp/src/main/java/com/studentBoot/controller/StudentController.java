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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.studentBoot.entity.Student;
import com.studentBoot.exceptions.ApiResponce;
import com.studentBoot.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
@Api(value="student-controller",description="This controller contains the functionality of viewing, adding, updating and deleting the student.")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	@ApiOperation(value="This functionality is used to add the student.",notes="You can add the student from here",response=Student.class)
    @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
    )
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		Student saveStudent = this.studentService.addStudent(student);
		return new ResponseEntity<Student>(saveStudent, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	@ApiOperation(value="This functionality is used to get list of the student.",notes="You can see how many students are available from here",response=Student.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudents = this.studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(allStudents,HttpStatus.OK);
	}
	
	@GetMapping("/{studentId}")
	@ApiOperation(value="This functionality is used to select student from their Id.",notes="You can select the student from there Id",response=Student.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId) {
		Student studentById = this.studentService.getStudentById(studentId);
		return new ResponseEntity<Student>(studentById,HttpStatus.OK);
	}
	
	@PutMapping("/{studentId}")
	@ApiOperation(value="This functionality is used to update the student from their Id.",notes="You can update the student from there Id",response=Student.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<Student> updateStudentById(@RequestBody Student student,@PathVariable int studentId) {
		Student updatedStudent = studentService.updateStudentById(student, studentId);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
	
	@DeleteMapping("/{studentId}")
	@ApiOperation(value="This functionality is used to delete the student.",notes="You can delete the student from here",response=Student.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "HTTP 200 OK success operation response code indicates that the request has succeeded."),
	        @ApiResponse(code = 201, message = "The 201 created status code that the server has fulfilled the browser's request, and as a result, has created a new resource"),
	        @ApiResponse(code = 400, message = "The HTTP code Bad Request 400 indicates a client error"),
	        @ApiResponse(code = 401, message = "The HTTP code 401 Unauthorized Access is denied due to invalid credentials"),
	        @ApiResponse(code = 403, message = "The HTTP 403 Forbidden response status code indicates that the server understands the request but refuses to authorize it."),
	        @ApiResponse(code = 404, message = "The HTTP 404 Not Found response status code indicates that the server cannot find the requested resource."),
	        }
	)
	public ResponseEntity<ApiResponce> deleteStudentById(@PathVariable("studentId") int studentId) {
		this.studentService.deleteStudentById(studentId);
		ApiResponce response=new ApiResponce();
		response.setMessage("Student record is deleted successfully with Student ID: "+studentId);
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponce>(response,HttpStatus.OK);
	}
	

}
