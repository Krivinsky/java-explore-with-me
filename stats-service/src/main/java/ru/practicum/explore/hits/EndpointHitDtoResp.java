package ru.practicum.explore.hits;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class EndpointHitDtoResp {
    private String app;
    private String uri;
    private Long hits;
}
