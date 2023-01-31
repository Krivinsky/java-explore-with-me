package ru.practicum;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//import javax.validation.constraints.NotBlank;
@Builder
@Getter
@Setter
public class EndpointHitDto {

//    @NotBlank
    private String app;

//    @NotBlank
    private String uri;

//    @NotBlank
    private String ip;

    private LocalDateTime timestamp;
}
