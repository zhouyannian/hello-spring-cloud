package com.zhouyn.demo.serviceProvider.repository;

import com.zhouyn.demo.serviceProvider.entity.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student, Long> {
    List<Student> findByStudentName(String studentName);
}
