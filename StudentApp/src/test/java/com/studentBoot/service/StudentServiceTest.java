package com.studentBoot.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import com.studentBoot.entity.Student;
import com.studentBoot.serviceimplementation.StudentServiceImplementation;

public class StudentServiceTest {

    @Test
    public void testAddStudent() {
        StudentService studentService = new StudentServiceImplementation();
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("Ranjeet Thakur");
        student.setStudentAge(23);

        studentService.addStudent(student);

        Assertions.assertEquals(student, studentService.getStudentById(1));
    }

    @Test
    public void testGetAllStudents() {
        StudentService studentService = new StudentServiceImplementation();
        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setStudentName("Ranjeet Thakur");
        student1.setStudentAge(23);

        Student student2 = new Student();
        student2.setStudentId(2);
        student2.setStudentName("Jane Doe");
        student2.setStudentAge(21);

        studentService.addStudent(student1);
        studentService.addStudent(student2);

        List<Student> students = studentService.getAllStudents();

        Assertions.assertEquals(2, students.size());
        Assertions.assertEquals(student1, students.get(0));
        Assertions.assertEquals(student2, students.get(1));
    }

    @Test
    public void testGetStudentById() {
        StudentService studentService = new StudentServiceImplementation();
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("John Doe");
        student.setStudentAge(20);

        studentService.addStudent(student);

        Student foundStudent = studentService.getStudentById(1);

        Assertions.assertEquals(student, foundStudent);
    }

    @Test
    public void testUpdateStudentById() {
        StudentService studentService = new StudentServiceImplementation();
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("John Doe");
        student.setStudentAge(20);

        studentService.addStudent(student);

        student.setStudentName("Jane Doe");
        student.setStudentAge(21);

        studentService.updateStudentById(student, 1);

        Student foundStudent = studentService.getStudentById(1);

        Assertions.assertEquals("Jane Doe", foundStudent.getStudentName());
        Assertions.assertEquals(21, foundStudent.getStudentAge());
    }

    @Test
    public void testDeleteStudentById() {
        StudentService studentService = new StudentServiceImplementation();
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("John Doe");
        student.setStudentAge(20);

        studentService.addStudent(student);

        studentService.deleteStudentById(1);

        Student foundStudent = studentService.getStudentById(1);

        Assertions.assertNull(foundStudent);
    }
}