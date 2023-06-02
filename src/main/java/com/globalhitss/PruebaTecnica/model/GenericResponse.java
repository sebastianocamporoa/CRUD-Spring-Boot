package com.globalhitss.PruebaTecnica.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.globalhitss.PruebaTecnica.repository.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String message;
    List<User> users;
}
