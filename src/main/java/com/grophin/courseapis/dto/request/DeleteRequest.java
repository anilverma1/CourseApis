package com.grophin.courseapis.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Valid
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteRequest {

    @NotEmpty
    @NotNull
    String courseId;

    @NotEmpty
    @NotNull
    String username;

}
