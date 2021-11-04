//package com.zhouyn.demo.serviceProvider.api;
//
//import com.zhouyn.demo.serviceProvider.entity.Student;
//import com.zhouyn.demo.serviceProvider.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * Hello Sprin Cloud -- Product Service
// *
// * @author zhouyn(zhouyannian @ 163.com)
// * @data 2019年4月24日下午10点45分
// * @since 1.0.0
// */
//@RestController
//@RequestMapping("/student")
//public class StudentEndpoint {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @GetMapping(value = "/name/{className}")
//    public List<Student> findByClassname(@PathVariable String className) {
//        return studentRepository.findByStudentName(className);
//    }
//
//    @GetMapping(value = "/{id}")
//    public Student findById(@PathVariable Long id) {
//        return studentRepository.findById(id).get();
//    }
//}
