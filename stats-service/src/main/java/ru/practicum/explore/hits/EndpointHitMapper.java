package ru.practicum.explore.hits;

public class EndpointHitMapper {

    public static EndpointHit toEndpointHit(EndpointHitDto endpointHitDto) {
        return EndpointHit.builder()
                .app(endpointHitDto.getApp())
                .uri(endpointHitDto.getUri())
                .ip(endpointHitDto.getIp())
                .build();
    }

    public static EndpointHitDto toEndpointHitDto(EndpointHit endpointHit) {
        return EndpointHitDto.builder()
                .app(endpointHit.getApp())
                .uri(endpointHit.getUri())
                .ip(endpointHit.getIp())
                .build();
    }

    public static EndpointHitDtoResp toEndpointHitDtoResp(EndpointHit endpointHit) {
        return EndpointHitDtoResp.builder()
                .app(endpointHit.getApp())
                .uri(endpointHit.getUri())
                .build();
    }
}
