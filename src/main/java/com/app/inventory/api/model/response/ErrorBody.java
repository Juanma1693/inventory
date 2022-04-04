package com.app.inventory.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorBody {

    private String message;
    private String detailMessage;
    private LocalDateTime timestamp;

}
