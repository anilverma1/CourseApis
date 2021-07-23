package com.grophin.courseapis.repos;

import com.grophin.courseapis.models.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDetailsRepo extends JpaRepository<CourseDetails,String> {
    CourseDetails findByCourseId(String courseid);
    List<CourseDetails>findByCreateUser(String user);
    List<CourseDetails>findByTitle(String title);
}
