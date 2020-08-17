package com.atrium.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.atrium.entities.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class StudentDao {

	@Getter
	@Setter
	private HibernateTemplate hibernateTemplate;

	// save Student :- create
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;

	}

	// read:- getting single entry
	public Student getStudent(int studentId) {
		return this.hibernateTemplate.get(Student.class, studentId);
	}

	// get all entries
	public List<Student> getAllStudents() {
		return this.hibernateTemplate.loadAll(Student.class);

	}

	// update entry
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);

	}

	// delete the entry
	@Transactional
	public boolean deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		if (student != null) {
			this.hibernateTemplate.delete(student);
			return true;
		}
		return false;

	}

}
