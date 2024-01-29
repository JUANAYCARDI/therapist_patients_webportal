package com.psi.satrello.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/* Error payload for exceptions */
@Data
@AllArgsConstructor
public class ErrorDTO {
    private final String message;
    private final Integer status;

}
