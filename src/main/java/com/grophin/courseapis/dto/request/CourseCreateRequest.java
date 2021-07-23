package com.grophin.courseapis.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Valid
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CourseCreateRequest {

    @NotNull
    @NotEmpty
    String id;

    @NotNull
    @NotEmpty
    String type;

    @NotNull
    String user;

    @NotNull
    @NotEmpty
    String description;

    @NotNull
    @NotEmpty
    String title;

    @NotNull
    @NotEmpty
    String cost;

    @NotNull
    @NotEmpty
    String contents;


}
