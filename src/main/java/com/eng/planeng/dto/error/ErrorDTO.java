package com.eng.planeng.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDTO {

    private HttpStatus status;
    private String message;
}
