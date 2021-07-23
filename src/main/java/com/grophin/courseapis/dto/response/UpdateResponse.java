package com.grophin.courseapis.dto.response;

import lombok.Data;

import java.util.HashMap;


@Data
public class UpdateResponse {

    String ticketId;
    HashMap<String,String> updatedFields;
    String message;
}
