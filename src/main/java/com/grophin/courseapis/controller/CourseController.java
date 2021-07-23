package com.grophin.courseapis.controller;

import com.grophin.courseapis.dto.request.CourseCreateRequest;
import com.grophin.courseapis.dto.request.DeleteRequest;
import com.grophin.courseapis.dto.request.UpdateRequest;
import com.grophin.courseapis.dto.response.CreateResponse;
import com.grophin.courseapis.dto.response.UpdateResponse;
import com.grophin.courseapis.models.CourseDetails;
import com.grophin.courseapis.services.CourseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    CourseServiceInterface courseServiceInterface;

    @PostMapping(
            path = "/add",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    ResponseEntity<CreateResponse> addAgent(@Valid @RequestBody CourseCreateRequest courseCreateRequest)throws Exception{
        CreateResponse agentCreateResponse = courseServiceInterface.addCourse(courseCreateRequest);
        if(agentCreateResponse.getStatus() == 1){
            return new ResponseEntity<>(agentCreateResponse, HttpStatus.OK);
        }

        return new ResponseEntity<>(agentCreateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(
            path = "/fetchall",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    ResponseEntity<List<CourseDetails>> fetchAllTicketDetails() throws Exception{
        return new ResponseEntity<>(courseServiceInterface.fetchAllCourses(),HttpStatus.OK);
    }

    @GetMapping(
            path = "/fetch/{courseId}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    ResponseEntity<CourseDetails> findByCourseId(@PathVariable String courseId) throws Exception{
        return new ResponseEntity<>(courseServiceInterface.fetchByCourseId(courseId),HttpStatus.OK);
    }

    @GetMapping(
            path = "/fetch/user/{username}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    ResponseEntity<List<CourseDetails>> findByCreateUser(@PathVariable String username) throws Exception{
        return new ResponseEntity<>(courseServiceInterface.fetchByUserName(username),HttpStatus.OK);
    }

    @GetMapping(
            path = "/fetch/title/{title}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    ResponseEntity<List<CourseDetails>> findByTitle(@PathVariable String title) throws Exception{
        return new ResponseEntity<>(courseServiceInterface.fetchByTitle(title),HttpStatus.OK);
    }

    @PutMapping(
            path = "/updatedetails",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    ResponseEntity<UpdateResponse> updateDetails(@Valid @RequestBody UpdateRequest updateRequest) throws Exception{
        return new ResponseEntity<>(courseServiceInterface.updateDetails(updateRequest),HttpStatus.OK);
    }



    @DeleteMapping(
            path="/deletecourse",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<UpdateResponse> deleteCourse(@Valid @RequestBody DeleteRequest deleteRequest) throws Exception{
        return new ResponseEntity<>(courseServiceInterface.deleteCourse(deleteRequest),HttpStatus.OK);
    }

}

