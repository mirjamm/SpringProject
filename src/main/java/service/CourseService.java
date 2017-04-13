/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> findAll();
    //get,update,delete,getby
}
