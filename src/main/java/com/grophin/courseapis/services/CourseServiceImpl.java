package com.grophin.courseapis.services;

import com.grophin.courseapis.constants.Constants;
import com.grophin.courseapis.dto.request.CourseCreateRequest;
import com.grophin.courseapis.dto.request.DeleteRequest;
import com.grophin.courseapis.dto.request.UpdateRequest;
import com.grophin.courseapis.dto.response.CreateResponse;
import com.grophin.courseapis.dto.response.UpdateResponse;
import com.grophin.courseapis.models.*;
import com.grophin.courseapis.repos.CourseDetailsRepo;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceInterface {


    CourseDetailsRepo courseDetailsRepo;

    @Autowired
    public CourseServiceImpl(CourseDetailsRepo courseDetailsRepo) {
        this.courseDetailsRepo = courseDetailsRepo;
    }



    @Override
    public CreateResponse addCourse(CourseCreateRequest courseCreateRequest) throws Exception {
        CreateResponse agentCreateResponse = new CreateResponse();
        try{


            CourseDetails courseDetails = new CourseDetails();
            courseDetails.setCourseId(courseCreateRequest.getId());
            courseDetails.setDescription(courseCreateRequest.getDescription());
            courseDetails.setCreateUser(courseCreateRequest.getUser());
            courseDetails.setTitle(courseCreateRequest.getTitle());
            courseDetails.setType(courseCreateRequest.getType());
            courseDetails.setContents(courseCreateRequest.getContents());
            courseDetails.setCost(Integer.parseInt(courseCreateRequest.getCost()));
            Date date1=new Date();
            courseDetails.setCreateDate(date1);
            this.courseDetailsRepo.save(courseDetails);

            agentCreateResponse.setId(courseCreateRequest.getId());
            agentCreateResponse.setName(courseCreateRequest.getTitle());
            agentCreateResponse.setStatus(1);
            agentCreateResponse.setMessage("Ticket Created Successfully");

        }
        catch (Exception ex){
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
            agentCreateResponse.setStatus(0);
            agentCreateResponse.setMessage("Exception while creating the ticket: \n"+stringWriter);
        }

        return agentCreateResponse;
    }

    @Override
    public List<CourseDetails> fetchAllCourses() throws Exception {
        List<CourseDetails> tickets = this.courseDetailsRepo.findAll();
        return tickets;
    }

    @Override
    public CourseDetails fetchByCourseId(String courseId) throws Exception {
        return this.courseDetailsRepo.findByCourseId(courseId);

    }

    @Override
    public List<CourseDetails> fetchByUserName(String user) throws Exception {
            return this.courseDetailsRepo.findByCreateUser(user);
    }

    @Override
    public List<CourseDetails> fetchByTitle(String title) throws Exception {
        return this.courseDetailsRepo.findByTitle(title);

    }

    @Override
    public UpdateResponse updateDetails(UpdateRequest updateRequest) throws Exception {

        UpdateResponse updateResponse = new UpdateResponse();
        try{
            CourseDetails courseDetails = this.courseDetailsRepo.findByCourseId(updateRequest.getCourseId());
            if(courseDetails.getCreateUser().equalsIgnoreCase(updateRequest.getUsername())){

            if(updateRequest.getDataMap().get(Constants.CONTENTS) != null){
                courseDetails.setContents(updateRequest.getDataMap().get(Constants.CONTENTS));
            }

            if(updateRequest.getDataMap().get(Constants.DESCRIPTION) != null){
                courseDetails.setDescription(updateRequest.getDataMap().get(Constants.DESCRIPTION));
            }

            if(updateRequest.getDataMap().get(Constants.TYPE) != null){
                courseDetails.setType(updateRequest.getDataMap().get(Constants.TYPE));
            }

            if(updateRequest.getDataMap().get(Constants.COST) != null){
                courseDetails.setTitle(updateRequest.getDataMap().get(Constants.COST));
            }

            if(updateRequest.getDataMap().get(Constants.TITLE) != null){
                courseDetails.setTitle(updateRequest.getDataMap().get(Constants.TITLE));
            }

            this.courseDetailsRepo.save(courseDetails);
            updateResponse.setTicketId(updateRequest.getCourseId());
            updateResponse.setMessage("Successfully Updated.");
            updateResponse.setUpdatedFields(updateRequest.getDataMap());
            }
            else{
                throw new Exception("Access Denied: User is not Authenticated for this transaction.");
            }

        }
        catch (Exception ex){
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
            updateResponse.setTicketId(updateRequest.getCourseId());
            updateResponse.setMessage("Exception while updating details\n."+stringWriter);
            updateResponse.setUpdatedFields(updateRequest.getDataMap());
        }
        return updateResponse;
    }


    @Override
    public UpdateResponse deleteCourse(DeleteRequest deleteRequest) throws Exception {
        UpdateResponse updateResponse = new UpdateResponse();
        try{
            CourseDetails courseDetails = this.courseDetailsRepo.findByCourseId(deleteRequest.getCourseId());
            if(courseDetails.getCreateUser().equalsIgnoreCase(deleteRequest.getUsername())){

            this.courseDetailsRepo.delete(courseDetails);
            updateResponse.setTicketId(deleteRequest.getCourseId());
            updateResponse.setMessage("Successfully Deleted.");
            updateResponse.setUpdatedFields(null);

            }else {
                throw new Exception("Access Denied: User is not Authenticated for this transaction.");
            }
        }
        catch (Exception ex){
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
            updateResponse.setTicketId(deleteRequest.getCourseId());
            updateResponse.setMessage("Exception while Deleting\n."+stringWriter);
            updateResponse.setUpdatedFields(null);
        }

        return updateResponse;
    }
}
