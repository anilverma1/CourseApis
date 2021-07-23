package com.grophin.courseapis.services;

import com.grophin.courseapis.dto.request.CreateRequest;
import com.grophin.courseapis.dto.response.CreateResponse;
import com.grophin.courseapis.models.UserDetails;

import java.util.List;

public interface UserServiceInterface {

    CreateResponse addUserAgent(CreateRequest createRequest) throws Exception;
    UserDetails getUserDetails(String email) throws Exception;

    List<UserDetails> getUserDetails() throws Exception;
}
