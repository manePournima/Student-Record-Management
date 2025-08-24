package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Student;
import com.example.demo.reposetory.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	Student student;

	public String test() {
		return "Test from Service";
	}

	private float percentages(Student student) {
		int percentage = student.getMark1() + student.getMark2() + student.getMark3() + student.getMark4()
				+ student.getMark5();
		return percentage / 5;
	}

	private String division(float percentage) {
	    if (percentage >= 60) {
	        return "First Division";
	    } else if (percentage >= 50) { // no need to check <60, because first condition already excludes it
	        return "Second Division";
	    } else {
	        return "Fail";
	    }
	}

	public Student addStudentEntry(Student student) {
		
		student.setPercentage(percentages(student));
		student.setDivision(division(percentages(student)));
		;
		return studentRepo.save(student);
	}

	public Student getStudentById(int id) {
		return studentRepo.findById(id).get();
	}
	
	public List<Student> getAllStudent(){
		return studentRepo.findAll();
	} 
	
	
	public Student updateStudent(int id, Student updatedStudent) {
	    // find existing record
	    Student existing = studentRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

	    // update only if different
	    if (updatedStudent.getName() != null && 
	        !updatedStudent.getName().equals(existing.getName())) {
	        existing.setName(updatedStudent.getName());
	    }

	    if (updatedStudent.getMark1() != existing.getMark1()) {
	        existing.setMark1(updatedStudent.getMark1());
	    }

	    if (updatedStudent.getMark2() != existing.getMark2()) {
	        existing.setMark2(updatedStudent.getMark2());
	    }

	    if (updatedStudent.getMark3() != existing.getMark3()) {
	        existing.setMark3(updatedStudent.getMark3());
	    }

	    if (updatedStudent.getMark4() != existing.getMark4()) {
	        existing.setMark4(updatedStudent.getMark4());
	    }

	    if (updatedStudent.getMark5() != existing.getMark5()) {
	        existing.setMark5(updatedStudent.getMark5());
	    }

	    // recalc percentage & division if marks changed
	    float percentage = percentages(existing);
	    existing.setPercentage(percentage);
	    existing.setDivision(division(percentage));

	    return studentRepo.save(existing);
	}

	
	public String removeData (int id) {
		studentRepo.deleteById(id);
		return "student data Removed";
	}
	
	

}
