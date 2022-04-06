package com.app.inventory.api.model.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * model class to error handler
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorBody {

    private String message;
    private LocalDateTime timestamp;

}
