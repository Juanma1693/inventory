package com.app.inventory.api.model.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorBody {

    private String message;
    private LocalDateTime timestamp;

}
