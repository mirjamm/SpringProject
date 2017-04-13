/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * sisaldab juba find, findby jne
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findByName(String name);
}
