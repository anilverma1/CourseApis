package com.grophin.courseapis.dto.response;

import lombok.Data;

@Data
public class CreateResponse {

    String id;
    String name;
    int status;
    String message;
}
